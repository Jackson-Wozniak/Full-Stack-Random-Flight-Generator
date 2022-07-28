package MSFSFlightGenerator.randomflight.service;

import MSFSFlightGenerator.randomflight.entity.Airport;
import MSFSFlightGenerator.randomflight.exception.CustomException;
import MSFSFlightGenerator.randomflight.repository.AirportRepository;
import MSFSFlightGenerator.randomflight.utils.CalculateFlightInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public Airport findRandomAirport(){
        return airportRepository.getRandomAirport();
    }

    public void saveNewAirport(Airport airport){
        airportRepository.save(airport);
    }


    /*
    if plane speed is < 150 + max hours < 2, flight is always domestic
    if plane speed is < 150 + max hours < 5, flight stays within continent
     */
    public List<Airport> getAirportsWithMaxHours(double maxHours, int planeSpeed){
        Airport airport1;
        Airport airport2;
        /*
        domesticFlight used to check if plane and duration is low enough that
        both airports are to be within a single country
        */
        boolean domesticFlight = planeSpeed <= 150 && maxHours <= 2.0;
        while(true){
            airport1 = airportRepository.getRandomAirport();
            if(domesticFlight){
                airport2 = airportRepository.getRandomAirportByCountry(airport1.getCountry());
            }else{
                airport2 = airportRepository.getRandomAirportByContinent(airport1.getContinent());
            }
            double flightDistance = CalculateFlightInfo.calculateFlightDistanceInMiles(airport1, airport2);
            if(flightDistance / planeSpeed > maxHours){
                continue;
            }
            break;
        }
        return List.of(airport1, airport2);
    }
}
