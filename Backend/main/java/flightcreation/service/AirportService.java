package flightcreation.service;

import flightcreation.model.entity.Airport;
import flightcreation.repository.AirportRepository;
import flightcreation.utils.GenerateFlightUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AirportService {

    @Autowired
    private final AirportRepository airportRepository;

    public Airport findRandomAirport(){
        return airportRepository.getRandomAirport();
    }

    public Airport findAirportById(String id){
        return airportRepository.findById(id).orElse(null);
    }

    /*
    maxFlightHours is String so that the method can check if flight time is "any"
    if plane speed is < 150 + max hours < 2, flight is domestic
     */
    public List<Airport> findAirportsWithinMaxHours(String maxFlightHours, int planeSpeed){
        if(maxFlightHours.equals("any")){
            return List.of(airportRepository.getRandomAirport(), airportRepository.getRandomAirport());
        }

        Airport airport1, airport2;
        double maxHours = Double.parseDouble(maxFlightHours);
        boolean domesticFlight = planeSpeed <= 150 && maxHours <= 2.0;

        while(true){
            airport1 = airportRepository.getRandomAirport();

            if(domesticFlight){
                airport2 = airportRepository.getRandomAirportByCountry(
                        airport1.getCountry());
            }else{
                airport2 = airportRepository.getRandomAirportByContinent(
                        airport1.getContinent());
            }

            double flightDistanceInMiles = GenerateFlightUtils.calculateFlightDistanceInMiles(
                    airport1, airport2);

            if((flightDistanceInMiles / planeSpeed) < maxHours){
                break;
            }
        }
        return List.of(airport1, airport2);
    }

    public void saveNewAirport(Airport airport){
        airportRepository.save(airport);
    }

    public Long findDatabaseRowCount(){
        return airportRepository.count();
    }
}
