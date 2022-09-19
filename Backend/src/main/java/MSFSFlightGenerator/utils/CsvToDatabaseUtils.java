package MSFSFlightGenerator.utils;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.model.entity.Landmark;
import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.model.entity.PopularRoute;
import MSFSFlightGenerator.service.AirportService;
import MSFSFlightGenerator.service.LandmarkService;
import MSFSFlightGenerator.service.PlaneService;
import MSFSFlightGenerator.service.PopularRouteService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
A helper class for saving airport, plane, landmark
and route data from csv format to a MySQL database
 */
public class CsvToDatabaseUtils {

    public static void savePlanesFromCsv(File file, PlaneService planeService) throws IOException {
        Files.lines(file.toPath()).forEach(plane -> {
            plane = plane.replace("\"", "");
            String[] planeColumns = plane.split(",");
            planeService.saveNewPlane(new Plane(
                    planeColumns[0],
                    planeColumns[4],
                    //save speed as integer
                    Integer.parseInt(planeColumns[1]),
                    //save range as integer
                    Integer.parseInt(planeColumns[2]),
                    planeColumns[3]));
        });
    }

    public static void saveAirportsFromCsv(File file, AirportService airportService) throws IOException {
        Files.lines(file.toPath()).forEach(airport -> {
            airport = airport.replace("\"", "");
            String[] airportColumns = airport.split(",");
            airportService.saveNewAirport(new Airport(
                    airportColumns[0],
                    airportColumns[1],
                    airportColumns[2],
                    //save latitude as double
                    Double.parseDouble(airportColumns[3]),
                    //save longitude as double
                    Double.parseDouble(airportColumns[4]),
                    airportColumns[5],
                    airportColumns[6]));
        });
    }

    public static void saveLandmarkToDb(File file, LandmarkService landmarkService) throws IOException {
        Files.lines(file.toPath()).forEach(landmark -> {
            String[] landmarkColumns = landmark.split("\\)\\(");
            landmarkService.saveLandmark(new Landmark(
                    landmarkColumns[0],
                    landmarkColumns[1],
                    landmarkColumns[2],
                    landmarkColumns[3],
                    landmarkColumns[4]));
        });
    }

    public static void saveRouteFromCsv(File file, PopularRouteService routeService) throws IOException {
        Files.lines(file.toPath()).forEach(route -> {
            String[] routeColumns = route.split(",");
            routeService.saveRoute(new PopularRoute(
                    //parses int because it is saved as the flight ranking #
                    Integer.parseInt(routeColumns[0]),
                    routeColumns[1],
                    routeColumns[2],
                    routeColumns[3],
                    routeColumns[4]));
        });
    }
}
