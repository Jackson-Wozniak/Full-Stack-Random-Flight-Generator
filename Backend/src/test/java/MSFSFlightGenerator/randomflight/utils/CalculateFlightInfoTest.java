package MSFSFlightGenerator.randomflight.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateFlightInfoTest {

    @Test
    void calculateTimeWith10kMiles200Knots(){
        assertEquals(43.45, CalculateFlightInfo.calculateFlightHours(200, 10000));
    }

}