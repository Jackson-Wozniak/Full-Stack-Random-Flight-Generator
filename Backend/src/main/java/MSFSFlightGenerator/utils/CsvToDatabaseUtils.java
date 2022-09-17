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

public class CsvToDatabaseUtils {

    public static void savePlanesFromCsv(
            File file, PlaneService planeService) throws IOException {
        Files.lines(file.toPath())
                .forEach(a -> {
                    a = a.replace("\"", "");
                    String[] array = a.split(",");
                    planeService.saveNewPlane(new Plane(
                            array[0],
                            array[4],
                            Integer.parseInt(array[1]),
                            Integer.parseInt(array[2]),
                            array[3]));
                });
    }

    public static void saveAirportsFromCsv(
            File file, AirportService airportService) throws IOException {
        Files.lines(file.toPath()).forEach(a -> {
            a = a.replace("\"", "");
            String[] array = a.split(",");
            airportService.saveNewAirport(new Airport(
                    array[0],
                    array[1],
                    array[2],
                    Double.parseDouble(array[3]),
                    Double.parseDouble(array[4]),
                    array[5],
                    array[6]));
        });
    }

    public static void saveLandmarkToDb(
            File file, LandmarkService landmarkService) throws IOException {
        Files.lines(file.toPath()).forEach(a -> {
            String[] array = a.split("\\)\\(");
            landmarkService.saveLandmark(new Landmark(
                    array[0],
                    array[1],
                    array[2],
                    array[3],
                    array[4]));
        });
    }

    public static void saveRouteFromCsv(
            File file, PopularRouteService popularRouteService) throws IOException {
        Files.lines(file.toPath()).forEach(route -> {
            String[] data = route.split(",");
            popularRouteService.saveRouteToDb(new PopularRoute(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3],
                    data[4]));
        });
    }
}
