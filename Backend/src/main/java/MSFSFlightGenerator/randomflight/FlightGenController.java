package MSFSFlightGenerator.randomflight;

import MSFSFlightGenerator.randomflight.airport.Airport;
import MSFSFlightGenerator.randomflight.plane.Plane;
import MSFSFlightGenerator.randomflight.airport.AirportService;
import MSFSFlightGenerator.randomflight.plane.PlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
@RequestMapping(value = "/custom-flight")
public class FlightGenController {

    private final PlaneService planeService;
    private final AirportService airportService;

    public FlightGenController(PlaneService planeService, AirportService airportService){
        this.planeService = planeService;
        this.airportService = airportService;
    }

    @GetMapping(value = "/generate")
    public Flight sendRandomFlight(){
        //create flight by getting 2 random airports
        //if user chooses random plane, get random plane (or choose standard/pro editions)
        //other features include user choosing flight time and continent
        //for choosing flight time, calculate random flight, if it is over the limit, create new one
        return new Flight(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
    }

    @GetMapping(value = "test")
    public Flight getFlightWithTime(){
        Plane plane = planeService.findRandomPlane();
        List<Airport> airports = airportService.getAirportsWithMaxHours(2.0, plane.getSpeedInKnots());
        return new Flight(airports.get(0), airports.get(1), plane);
    }
    
    @GetMapping(value = "custom-generate")
    public Plane sendRandomFlightWithParameters(){
        //parse @RequestBody to see what parameters are chosen
        //1.Flight timer under 2 hours, 2-5 hours, no limit
        //2.Plane type
        return planeService.findRandomPlaneByType("airliner");
    }

    //Changed from @ModelAttribute to @RequestBody for Postman tests

}
