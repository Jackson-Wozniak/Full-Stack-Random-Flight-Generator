package flightcreation.model.request;

import flightcreation.enums.PlaneType;
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

    public boolean isAValidPlaneType(){
        try{
            PlaneType.valueOf(this.planeType.toUpperCase());
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean isValidFlight(double maxFlightHours){
        if(this.maxFlightHours.equals("any")) return true;

        return Double.parseDouble(this.maxFlightHours) > maxFlightHours;
    }
}
