package MSFSFlightGenerator.randomflight;

/*
This class is used to parse the JSON returned from flightGenController class when
receiving a flight that includes specific parameters
 */
public class FlightParameters {

    private String maxFlightHours;
    private String planeType;

    public FlightParameters(String maxFlightHours, String planeType) {
        this.maxFlightHours = maxFlightHours;
        this.planeType = planeType;
    }

    public String getMaxFlightHours() {
        return maxFlightHours;
    }

    public void setMaxFlightHours(String maxFlightHours) {
        this.maxFlightHours = maxFlightHours;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }
}