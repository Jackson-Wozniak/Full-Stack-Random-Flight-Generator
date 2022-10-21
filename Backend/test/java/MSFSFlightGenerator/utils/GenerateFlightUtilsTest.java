package MSFSFlightGenerator.utils;

import flightcreation.model.entity.Airport;
import flightcreation.service.AirportService;
import flightcreation.utils.GenerateFlightUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class GenerateFlightUtilsTest {

    @Autowired
    private AirportService airportService;

    @Test
    void airportsMeasureCorrectDistance(){
        Airport airport1 = airportService.findAirportById("KMHT");
        Airport airport2 = airportService.findAirportById("KBOS");
        assertNotNull(airport1);
        assertNotNull(airport2);
        assertEquals(45,
                Math.round(GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2)));
    }

    @Test
    void sameAirportIsDistanceOfZeroMiles(){
        Airport airport1 = airportService.findAirportById("KBOS");
        Airport airport2 = airportService.findAirportById("KBOS");
        assertEquals(0,
                GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2));
    }

    @Test
    void distanceIsMeasuredCorrectly(){
        assertEquals(.87, GenerateFlightUtils.calculateFlightHours(100, 100));
        assertEquals("00:52", GenerateFlightUtils.convertHoursToHHmm(.87));
    }

    @Test
    void twoHoursIsFormattedCorrectly(){
        assertEquals("02:00", GenerateFlightUtils.convertHoursToHHmm(2));
    }

}