package MSFSFlightGenerator.randomflight.utils;

import MSFSFlightGenerator.randomflight.airport.Airport;
import MSFSFlightGenerator.randomflight.plane.Plane;
import MSFSFlightGenerator.randomflight.airport.AirportService;
import MSFSFlightGenerator.randomflight.plane.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SaveFromCsv {

    private final AirportService airportService;
    private final PlaneService planeService;

    @Autowired
    public SaveFromCsv(AirportService airportService, PlaneService planeService){
        this.airportService = airportService;
        this.planeService = planeService;
    }

    public void savePlanesFromCsv() throws IOException {
        File file = new File("Text-files/planes.csv");
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

    //method to save from csv file to database directly
    //icao,type,name,latitude_deg,longitude_deg,continent,iso_country,municipality
    public void saveAirportsFromCsv() throws IOException {
        File file = new File("Text-files/airports.csv");
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
}
