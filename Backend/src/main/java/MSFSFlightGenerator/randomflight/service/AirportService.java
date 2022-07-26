package MSFSFlightGenerator.randomflight.service;

import MSFSFlightGenerator.randomflight.entity.Airport;
import MSFSFlightGenerator.randomflight.exception.CustomException;
import MSFSFlightGenerator.randomflight.repository.AirportRepository;
import org.springframework.stereotype.Service;

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
        if(airportRepository.findAll().size() == 0){
            throw new CustomException("cannot find airports");
        }
        return airportRepository.findAll();
    }

    public Airport findRandomAirport(){
        return airportRepository.getRandomAirport();
    }

    public void saveNewAirport(Airport airport){
        airportRepository.save(airport);
    }
}
