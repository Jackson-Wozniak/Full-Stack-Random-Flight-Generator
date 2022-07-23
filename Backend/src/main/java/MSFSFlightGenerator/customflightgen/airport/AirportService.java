package MSFSFlightGenerator.customflightgen.airport;

import MSFSFlightGenerator.customflightgen.CustomException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public Airport findAirportById(String name){
        return airportRepository.findById(name)
                        .orElseThrow(() -> new CustomException("cannot find airport"));
    }

    public List<Airport> findAllAirports(){
        return airportRepository.findAll();
    }

    public Airport findRandomAirport(){
        return airportRepository.getRandomAirport();
    }

    //method to save from csv file to database directly
    //icao,type,name,latitude_deg,longitude_deg,continent,iso_country,municipality
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
                    array[6]));
        });
    }
}
