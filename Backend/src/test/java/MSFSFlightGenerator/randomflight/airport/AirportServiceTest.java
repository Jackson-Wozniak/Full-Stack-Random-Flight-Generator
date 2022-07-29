package MSFSFlightGenerator.randomflight.airport;

import MSFSFlightGenerator.randomflight.plane.Plane;
import MSFSFlightGenerator.randomflight.plane.PlaneService;
import MSFSFlightGenerator.randomflight.utils.CalculateFlightInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AirportServiceTest {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private AirportService airportService;

    @Test
    void oneHourParametersAreFollowed(){
        Plane plane = planeService.findRandomPlane();
        List<Airport> airports = airportService.getAirportsWithMaxHours(
                "1", plane.getSpeedInKnots());
        double flightDistance = CalculateFlightInfo.calculateFlightDistanceInMiles(
                airports.get(0),
                airports.get(1));
        assertTrue(CalculateFlightInfo.calculateFlightHours(plane.getSpeedInKnots(), flightDistance) < 1);
    }

    @Test
    void twoHourParametersAreFollowed(){
        Plane plane = planeService.findRandomPlane();
        List<Airport> airports = airportService.getAirportsWithMaxHours(
                "2", plane.getSpeedInKnots());
        double flightDistance = CalculateFlightInfo.calculateFlightDistanceInMiles(
                airports.get(0),
                airports.get(1));
        assertTrue(CalculateFlightInfo.calculateFlightHours(plane.getSpeedInKnots(), flightDistance) < 2);
    }

}