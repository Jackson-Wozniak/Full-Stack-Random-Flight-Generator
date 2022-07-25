package MSFSFlightGenerator.customflightgen;

import MSFSFlightGenerator.customflightgen.airport.AirportService;
import MSFSFlightGenerator.customflightgen.plane.PlaneService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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


//    @PostMapping(value = "/generate")
//    public String getFlightRequest(@RequestBody String toParse){
//        System.out.println(toParse);
//        return "received";
//    }

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
    
    @GetMapping(value = "custom-generate")
    public void sendRandomFlightWithParameters(@RequestBody String parameters){
        //parse requestbody to see what parameters are chosen
        //1.)Flight timer under 2 hours, 2-5 hours, no limit
        //2.)Plane chosen
        //3.)Continent Departure
    }

    //Changed from @modelattribute to @requestbody for Postman tests

}
