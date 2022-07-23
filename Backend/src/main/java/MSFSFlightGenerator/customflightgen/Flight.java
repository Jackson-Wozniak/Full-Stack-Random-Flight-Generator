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
        //make sure that flight components exist in the class
        if(airport1 == null || airport2 == null || plane == null){
            throw new CustomException("flight time could not be calculated");
        }
        double latitude1 = airport1.getLatitude();
        double longitude1 = airport1.getLongitude();
        double latitude2 = airport2.getLatitude();
        double longitude2 = airport2.getLongitude();

        double differenceInLongitude = longitude2 - longitude1;
        double differenceInLatitude = latitude2 - latitude1;

        double a = Math.pow(Math.sin(differenceInLatitude / 2), 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(differenceInLongitude / 2),2);

        return (3956) * (2 * Math.asin(Math.sqrt(a)));
    }

    //calculate flight time using distance and speed
    //uses Haversine formula
    public double getFlightTime(){
        //make sure that flight components exist in the class
        double flightDistance = getFlightDistanceInMiles();
        int planeSpeed = plane.getSpeedInMph();

        return flightDistance/planeSpeed;
    }
}
