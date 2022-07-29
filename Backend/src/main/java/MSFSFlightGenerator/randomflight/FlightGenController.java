package MSFSFlightGenerator.randomflight;

import MSFSFlightGenerator.randomflight.airport.Airport;
import MSFSFlightGenerator.randomflight.plane.Plane;
import MSFSFlightGenerator.randomflight.airport.AirportService;
import MSFSFlightGenerator.randomflight.plane.PlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
@RequestMapping(value = "/random")
public class FlightGenController {

    private final PlaneService planeService;
    private final AirportService airportService;

    public FlightGenController(PlaneService planeService, AirportService airportService){
        this.planeService = planeService;
        this.airportService = airportService;
    }

    @GetMapping(value = "/new-flight")
    public Flight sendRandomFlight(){
        return new Flight(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
    }
    
    @GetMapping(value = "custom-flight")
    public Flight sendRandomFlightWithParameters(@RequestBody FlightParameters flightParameters){
        Plane plane = planeService.findRandomPlaneByType(flightParameters.getPlaneType());
        List<Airport> airports = airportService.getAirportsWithMaxHours(
                flightParameters.getMaxFlightHours(),
                plane.getSpeedInKnots());

        return new Flight(airports.get(0), airports.get(1), plane);
    }
}
