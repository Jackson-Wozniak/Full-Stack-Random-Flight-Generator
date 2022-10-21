package flightcreation.utils;

import flightcreation.model.entity.Airport;
import flightcreation.model.entity.Plane;
import flightcreation.service.AirportService;
import flightcreation.service.PlaneService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/*
A helper class for saving airport, plane, landmark
and route data from csv format to a MySQL database
 */
public class CsvToDatabaseUtils {

    public static List<Plane> savePlanesFromCsv(File file) throws IOException {
        return Files.lines(file.toPath()).map(plane -> {
            plane = plane.replace("\"", "");
            String[] planeColumns = plane.split(",");
            return new Plane(
                    planeColumns[0],
                    planeColumns[4],
                    //save speed as integer
                    Integer.parseInt(planeColumns[1]),
                    //save range as integer
                    Integer.parseInt(planeColumns[2]),
                    planeColumns[3]);
        }).collect(Collectors.toList());
    }

    public static List<Airport> ConvertCsvToAirports(File file) throws IOException {
        return Files.lines(file.toPath())
                .map(airport -> {
                    airport = airport.replace("\"", "");
                    String[] airportColumns = airport.split(",");
                        return new Airport(
                                airportColumns[0],
                                airportColumns[1],
                                airportColumns[2],
                                //save latitude as double
                                Double.parseDouble(airportColumns[3]),
                                //save longitude as double
                                Double.parseDouble(airportColumns[4]),
                                airportColumns[5],
                                airportColumns[6]);
                }).collect(Collectors.toList());
    }
}
