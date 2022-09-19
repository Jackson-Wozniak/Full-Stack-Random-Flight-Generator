package MSFSFlightGenerator.controller;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.model.request.FlightRequest;
import MSFSFlightGenerator.model.response.FlightResponse;
import MSFSFlightGenerator.service.AirportService;
import MSFSFlightGenerator.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://127.0.0.1:5500"})
@RequestMapping(value = "/api/v1/flight")
@AllArgsConstructor
public class FlightController {

    @Autowired
    private final PlaneService planeService;
    @Autowired
    private final AirportService airportService;

    @GetMapping(value = "/random")
    public FlightResponse createRandomFlight(){
        return new FlightResponse(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
    }
    
    //Flight Request parameter includes max time and type of plane included in flight
    @PostMapping(value = "/custom")
    public FlightResponse createFlightWithParameters(@RequestBody FlightRequest flightRequest){
        Plane plane = planeService.findRandomPlaneByType(flightRequest.getPlaneType());

        List<Airport> airports = airportService.findAirportsWithinMaxHours(
                flightRequest.getMaxFlightHours(),
                plane.getSpeedInKnots());

        //this constructor automatically calculates flight time/distance
        return new FlightResponse(airports.get(0), airports.get(1), plane);
    }
}
