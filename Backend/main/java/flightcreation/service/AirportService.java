package flightcreation.service;

import flightcreation.model.entity.Airport;
import flightcreation.model.request.FlightRequest;
import flightcreation.repository.AirportRepository;
import flightcreation.utils.GenerateFlightUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    To find a random flight, this method finds one random airport, and loops through each
    airport to find whether the flight time is valid
     */
    public List<Airport> findAirportsWithinMaxHours(FlightRequest flightRequest, int planeSpeed){
        ArrayList<Airport> airports = new ArrayList<>(airportRepository.findAll());
        if(flightRequest.getMaxFlightHours().equals("any")){
            Collections.shuffle(airports);
            return List.of(airports.get(0), airports.get(1));
        }
        double maxHours = Double.parseDouble(flightRequest.getMaxFlightHours());
        //boolean value used to test whether flight time is within the requested range
        boolean validFlight;
        Airport airport1, airport2;
        do{
            Collections.shuffle(airports);
            /*
            gets final item in list so that it already loops through every other
            airport before landing back on itself, so more comparisons are made
             */
            airport1 = airports.get(airports.size() - 1);
            Airport finalAirport = airport1;
            airport2 = airports.stream()
                    .filter(airport -> {
                        double flightDistance = GenerateFlightUtils.calculateFlightDistanceInMiles(
                                finalAirport, airport);
                        return maxHours > GenerateFlightUtils.calculateFlightHours(
                                planeSpeed, flightDistance);
                    })
                    .findFirst().orElse(airport1);
            /*
            if no airport within the range is found in stream, airport2 is assigned the value of
            airport1. This boolean value makes sure that is not the case
             */
            validFlight = !airport1.equals(airport2);
        }while(!validFlight);

        return List.of(airport1, airport2);
    }

    public void saveAllAirports(Collection<Airport> airports){
        airportRepository.saveAll(airports);
    }

    public Long findDatabaseRowCount(){
        return airportRepository.count();
    }
}
