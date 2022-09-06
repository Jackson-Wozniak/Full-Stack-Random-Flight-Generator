package MSFSFlightGenerator.model.response;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.utils.GenerateFlightUtils;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightResponse {

    private Plane plane; //will be stored in database
    private Airport airport1; //will be stored in database
    private Airport airport2; //will be stored in database
    private double flightDistanceInMiles;
    private String flightHours;

    public FlightResponse(Airport airport1, Airport airport2, Plane plane) {
        this.airport1 = airport1;
        this.airport2 = airport2;
        this.plane = plane;
        setFlightDistanceInMiles();
        setFlightTime();
    }

    public void setFlightDistanceInMiles(){
        this.flightDistanceInMiles = GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2);
    }

    public void setFlightTime(){
        this.flightHours = GenerateFlightUtils.convertHoursToHHmm(
                GenerateFlightUtils.calculateFlightHours(plane.getSpeedInKnots(), flightDistanceInMiles));
    }
}
