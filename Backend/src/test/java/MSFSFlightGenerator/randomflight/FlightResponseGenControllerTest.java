package MSFSFlightGenerator.randomflight;

import MSFSFlightGenerator.model.response.FlightResponse;
import MSFSFlightGenerator.service.AirportService;
import MSFSFlightGenerator.service.PlaneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class FlightResponseGenControllerTest {

    @Autowired
    private AirportService airportService;

    @Autowired
    private PlaneService planeService;


    @Test
    //make sure that flight constructor auto calls setDistance and setTime method
    void makeSureFlightDistanceExists(){
        FlightResponse flightResponse = new FlightResponse(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
        assertNotEquals(0.0d, flightResponse.getFlightDistanceInMiles());
    }

}