package MSFSFlightGenerator.randomflight;

import MSFSFlightGenerator.randomflight.airport.Airport;
import MSFSFlightGenerator.randomflight.plane.Plane;
import MSFSFlightGenerator.randomflight.utils.CalculateFlightInfo;

public class Flight {

    private Plane plane; //will be stored in database
    private Airport airport1; //will be stored in database
    private Airport airport2; //will be stored in database
    private double flightDistance;
    private double flightHours;

    public Flight(Airport airport1, Airport airport2, Plane plane) {
        this.airport1 = airport1;
        this.airport2 = airport2;
        this.plane = plane;
        setFlightDistance();
        setFlightTime();
    }

    public Flight(){
        //empty entity constructor
    }


    public void setFlightDistance(){
        this.flightDistance = CalculateFlightInfo.calculateFlightDistanceInMiles(airport1, airport2);
    }


    public void setFlightTime(){
        this.flightHours = CalculateFlightInfo.calculateFlightHours(plane.getSpeedInKnots(), flightDistance);
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

    public double getFlightDistance() {
        return this.flightDistance;
    }

    public double getFlightHours() {
        return this.flightHours;
    }
}
