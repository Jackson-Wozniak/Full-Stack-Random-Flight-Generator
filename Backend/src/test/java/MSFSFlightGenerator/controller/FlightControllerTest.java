package MSFSFlightGenerator.controller;

import MSFSFlightGenerator.model.request.FlightRequest;
import MSFSFlightGenerator.model.response.FlightResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void randomFlightResponseIsNotNull() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get("/api/v1/flight/random")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        FlightResponse flight = objectMapper.readValue(
                response.getContentAsString(),
                FlightResponse.class);
        assertNotNull(flight);
    }

    @Test
    void customFlightFollowsParameters() throws Exception {
        MockHttpServletResponse response =
                mockMvc.perform(post("/api/v1/flight/custom")
                                .content(asJsonString(new FlightRequest("10", "jet")))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        FlightResponse flight = objectMapper.readValue(
                response.getContentAsString(),
                FlightResponse.class);
        assertEquals("Jet", flight.getPlane().getType());
        assertTrue(HHMMFormatIsLessThanHours(flight.getFlightHours(), 10));
    }

    @Test
    void customFlightFollowsParametersTwo() throws Exception {
        MockHttpServletResponse response =
                mockMvc.perform(post("/api/v1/flight/custom")
                                .content(asJsonString(new FlightRequest("2", "propeller")))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        FlightResponse flight = objectMapper.readValue(
                response.getContentAsString(),
                FlightResponse.class);
        assertEquals("Propeller", flight.getPlane().getType());
        assertTrue(HHMMFormatIsLessThanHours(flight.getFlightHours(), 2));
    }

    private static String asJsonString(FlightRequest flightRequest) {
        try {
            return objectMapper.writeValueAsString(flightRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean HHMMFormatIsLessThanHours(String formatted, double hours){
        String[] formattedArray = formatted.split(":");
        return Double.parseDouble(formattedArray[0]) <= hours;
    }
}