package MSFSFlightGenerator.randomflight.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateFlightInfoTest {

    @Test
    void calculateTimeWith10kMiles200Knots(){
        assertEquals(43.45, CalculateFlightInfo.calculateFlightHours(200, 10000));
    }

    @Test
    void timeFormatTestAt3hours(){
        assertEquals("03:00", CalculateFlightInfo.convertHoursToHHmm(3.0));
    }

    @Test
    void timeFormatTestAt300hours(){
        assertEquals("300:00", CalculateFlightInfo.convertHoursToHHmm(300.0));
    }

    @Test
    void timeFormatTestAt3Point45hours(){
        assertEquals("03:27", CalculateFlightInfo.convertHoursToHHmm(3.45));
    }

}