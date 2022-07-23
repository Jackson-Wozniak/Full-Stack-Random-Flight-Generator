package MSFSFlightGenerator.customflightgen.airport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }



    public void saveAirportsFromCsv() throws IOException {
        File file = new File("Text-files/airports.csv");
        Files.lines(file.toPath()).forEach(a -> {
            a = a.replace("\"", "");
            String[] array = a.split(",");
            airportRepository.save(new Airport(
                    array[0],
                    array[1],
                    array[2],
                    Double.parseDouble(array[3]),
                    Double.parseDouble(array[4]),
                    array[5],
                    array[6],
                    array[7]));
        });
    }
}
