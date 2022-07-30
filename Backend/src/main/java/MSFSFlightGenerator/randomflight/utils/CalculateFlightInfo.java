package MSFSFlightGenerator.randomflight.utils;

import MSFSFlightGenerator.randomflight.airport.Airport;
import MSFSFlightGenerator.randomflight.CustomException;

/*
This class is used to calculate flight time and distance
 */
public class CalculateFlightInfo {

    //calculate flight distance using coordinates
    //using Haversine formula
    public static double calculateFlightDistanceInMiles(Airport airport1, Airport airport2){
        if(airport1 == null || airport2 == null){
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

        return Math.round(((3956) * (2 * Math.asin(Math.sqrt(a)))) * 100.00) / 100.00;
    }

    //calculate flight time using distance and speed
    public static double calculateFlightHours(int planeSpeedInKnots, double flightDistanceInMiles){
        //knots to miles per hour
        double newPlaneSpeedInMph = planeSpeedInKnots * 1.15077945;
        return Math.round((flightDistanceInMiles/newPlaneSpeedInMph) * 100.00) / 100.00;
    }
}
