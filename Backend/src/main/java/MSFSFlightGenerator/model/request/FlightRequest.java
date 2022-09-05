package MSFSFlightGenerator.model.request;

import lombok.Getter;
import lombok.Setter;

/*
This class is used to parse the JSON returned from flightGenController class when
receiving a flight that includes specific parameters
 */
@Getter
@Setter
public class FlightRequest {

    private String maxFlightHours;
    private String planeType;

    public FlightRequest(String maxFlightHours, String planeType) {
        this.maxFlightHours = maxFlightHours;
        this.planeType = planeType;
    }
}
