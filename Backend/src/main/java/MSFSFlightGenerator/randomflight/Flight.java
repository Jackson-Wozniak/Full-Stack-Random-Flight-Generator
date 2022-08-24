package MSFSFlightGenerator.randomflight;

import MSFSFlightGenerator.randomflight.airport.Airport;
import MSFSFlightGenerator.randomflight.plane.Plane;
import MSFSFlightGenerator.randomflight.utils.CalculateFlightInfo;

public class Flight {

    private Plane plane; //will be stored in database
    private Airport airport1; //will be stored in database
    private Airport airport2; //will be stored in database
    private double flightDistanceInMiles;
    private String flightHours;

    public Flight(Airport airport1, Airport airport2, Plane plane) {
        this.airport1 = airport1;
        this.airport2 = airport2;
        this.plane = plane;
        setFlightDistanceInMiles();
        setFlightTime();
    }

    public Flight(){
        //empty entity constructor
    }


    public void setFlightDistanceInMiles(){
        this.flightDistanceInMiles = CalculateFlightInfo.calculateFlightDistanceInMiles(airport1, airport2);
    }


    public void setFlightTime(){
        this.flightHours = CalculateFlightInfo.convertHoursToHHmm(
                CalculateFlightInfo.calculateFlightHours(plane.getSpeedInKnots(), flightDistanceInMiles));
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
