package flightcreation.utils;

import flightcreation.exception.FlightGeneratorException;
import flightcreation.model.entity.Airport;

/*
A helper class for calculating flight time and distance
 */
public class GenerateFlightUtils {

    //Haversine formula for finding distance w/- coordinates
    public static double calculateFlightDistanceInMiles(Airport airport1, Airport airport2){
        if(airport1 == null || airport2 == null){
            throw new FlightGeneratorException("flight time could not be calculated");
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

    public static double calculateFlightHours(int planeSpeedInKnots, double flightDistanceInMiles){
        double planeSpeedInMph = planeSpeedInKnots * 1.15077945;
        return Math.round((flightDistanceInMiles/planeSpeedInMph) * 100.00) / 100.00;
    }

    public static String convertHoursToHHmm(double flightHours) {
        double flightMinutes = flightHours * 60;
        double hours = flightMinutes / 60;
        double minutes = flightMinutes % 60;
        return String.format("%02d:%02d", (int) Math.floor(hours), Math.round(minutes));
    }
}
