package MSFSFlightGenerator.service;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.repository.AirportRepository;
import MSFSFlightGenerator.utils.GenerateFlightUtils;
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
    maxFlightHours is String so that the method can check if flight time is "any"
    if plane speed is < 150 + max hours < 2, flight is always domestic
    if plane speed is < 150 + max hours < 5, flight stays within continent
     */
    public List<Airport> getAirportsWithMaxHours(String maxFlightHours, int planeSpeed){
        if(maxFlightHours.equals("any")){
            return List.of(airportRepository.getRandomAirport(), airportRepository.getRandomAirport());
        }
        Airport airport1;
        Airport airport2;
        /*
        domesticFlight used to check if plane and duration is low enough that
        both airports are to be within a single country
        */
        double maxHours = Double.parseDouble(maxFlightHours);
        boolean domesticFlight = planeSpeed <= 150 && maxHours <= 2.0;
        while(true){
            airport1 = airportRepository.getRandomAirport();
            if(domesticFlight){
                airport2 = airportRepository.getRandomAirportByCountry(airport1.getCountry());
            }else{
                airport2 = airportRepository.getRandomAirportByContinent(airport1.getContinent());
            }
            double flightDistanceInMiles = GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2);
            if(flightDistanceInMiles / planeSpeed > maxHours){
                continue;
            }
            break;
        }
        return List.of(airport1, airport2);
    }
}
