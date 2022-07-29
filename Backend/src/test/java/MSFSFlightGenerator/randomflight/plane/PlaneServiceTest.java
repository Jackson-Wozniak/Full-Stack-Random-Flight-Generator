package MSFSFlightGenerator.randomflight.plane;

import MSFSFlightGenerator.randomflight.airport.AirportService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlaneServiceTest {

    @Autowired
    private PlaneService planeService;

    @Test
    void airlinerPlaneParametersAreFollowed(){
        Plane plane = planeService.findRandomPlaneByType("airliner");
        assertEquals("Airliner", plane.getType());
    }

    @Test
    void propellerPlaneParametersAreFollowed(){
        Plane plane = planeService.findRandomPlaneByType("propeller");
        assertEquals("Propeller", plane.getType());
    }

}