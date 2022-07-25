package MSFSFlightGenerator.customflightgen;

import MSFSFlightGenerator.customflightgen.airport.Airport;
import MSFSFlightGenerator.customflightgen.airport.AirportService;
import MSFSFlightGenerator.customflightgen.plane.Plane;
import MSFSFlightGenerator.customflightgen.plane.PlaneService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

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
        setFlightDistance();
    }

    public Flight(){
        //empty entity constructor
    }

    //calculate flight distance using coordinates
    //uses Haversine formula
    public void setFlightDistance(){
        //make sure that flight components exist in the class
        if(airport1 == null || airport2 == null || plane == null){
            throw new CustomException("flight time could not be calculated");
        }
        double latitude1 = Math.toRadians(airport1.getLatitude());
        double longitude1 = Math.toRadians(airport1.getLongitude());
        double latitude2 = Math.toRadians(airport2.getLatitude());
        double longitude2 = Math.toRadians(airport2.getLongitude());

        double differenceInLongitude = longitude2 - longitude1;
        double differenceInLatitude = latitude2 - latitude1;

        double a = Math.pow(Math.sin(differenceInLatitude / 2), 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(differenceInLongitude / 2),2);

        this.flightDistance = Math.round(((3956) * (2 * Math.asin(Math.sqrt(a)))) * 100.00) / 100.00;
    }

    //calculate flight time using distance and speed
    public void setFlightTime(){
        //make sure that flight components exist in the class
        if(this.flightDistance == 0.0d || plane == null){
            throw new CustomException("cannot find flight time");
        }
        this.flightHours = Math.round((this.flightDistance/plane.getSpeedInKnots()) * 100.00) / 100.00 ;
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
