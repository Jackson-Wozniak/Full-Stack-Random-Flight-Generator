package MSFSFlightGenerator.model.response;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.utils.GenerateFlightUtils;

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

    public FlightResponse(){
        //empty entity constructor
    }


    public void setFlightDistanceInMiles(){
        this.flightDistanceInMiles = GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2);
    }


    public void setFlightTime(){
        this.flightHours = GenerateFlightUtils.convertHoursToHHmm(
                GenerateFlightUtils.calculateFlightHours(plane.getSpeedInKnots(), flightDistanceInMiles));
    }



    public Plane getPlane() {
        return this.plane;
    }

    public Airport getAirport1() {
        return this.airport1;
    }

    public Airport getAirport2() {
        return this.airport2;
    }

    public double getFlightDistanceInMiles() {
        return this.flightDistanceInMiles;
    }

    public String getFlightHours() {
        return this.flightHours;
    }
}
