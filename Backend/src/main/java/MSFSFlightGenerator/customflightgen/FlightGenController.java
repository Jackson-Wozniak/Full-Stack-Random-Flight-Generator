package MSFSFlightGenerator.customflightgen;

import MSFSFlightGenerator.customflightgen.airport.AirportService;
import MSFSFlightGenerator.customflightgen.plane.PlaneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/custom-flights")
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
        Flight flight = new Flight(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
        flight.setFlightDistance();
        flight.setFlightTime();
        return flight;
    }

    //Changed from @modelattribute to @requestbody for Postman tests

}
