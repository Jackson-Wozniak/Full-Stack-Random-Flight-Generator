package MSFSFlightGenerator.customflightgen;

import MSFSFlightGenerator.customflightgen.plane.PlaneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/custom-flights")
public class FlightGenController {

    private final PlaneService planeService;

    public FlightGenController(PlaneService planeService){
        this.planeService = planeService;
    }


    @PostMapping(value = "/generate")
    public String getFlightRequest(@RequestBody String toParse){
        System.out.println(toParse);
        return "received";
    }

    @GetMapping(value = "/generate")
    public Flight sendRandomFlight(){
        return new Flight();
    }

    //Changed from @modelattribute to @requestbody for Postman tests

}
