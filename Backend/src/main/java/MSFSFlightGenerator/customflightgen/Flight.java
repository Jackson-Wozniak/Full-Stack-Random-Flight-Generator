package MSFSFlightGenerator.customflightgen;

import MSFSFlightGenerator.customflightgen.airport.Airport;
import MSFSFlightGenerator.customflightgen.plane.Plane;

public class Flight {

    private Plane plane; //will be stored in database
    private Airport airport1; //will be stored in database
    private Airport airport2; //will be stored in database

    public Flight(Plane plane,
                  Airport airport1,
                  Airport airport2) {
        this.plane = plane;
        this.airport1 = airport1;
        this.airport2 = airport2;
    }

    public Flight(){

    }

    //calculate flight distance using coordinates
    public double getFlightDistanceInMiles(){
        double latitude1 = airport1.getLatitude();
        double longitude1= airport1.getLongitude();

        double latitude2 = airport2.getLatitude();
        double longtitude2 = airport2.getLongitude();


        return 0.0;
    }

    //calculate flight time using distance and speed
    public double getFlightTime(){
        int planeSpeed = plane.getSpeedInMph();
        return 0.0;
    }
}
