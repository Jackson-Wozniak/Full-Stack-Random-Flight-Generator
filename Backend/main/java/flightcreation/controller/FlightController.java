package flightcreation.controller;

import flightcreation.exception.FlightGeneratorException;
import flightcreation.model.entity.Airport;
import flightcreation.model.entity.Plane;
import flightcreation.model.request.FlightRequest;
import flightcreation.model.response.FlightResponse;
import flightcreation.service.AirportService;
import flightcreation.service.PlaneService;
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
        if(!flightRequest.isAValidPlaneType()){
            throw new FlightGeneratorException("Plane Type Does Not Exist");
        }
        Plane plane = planeService.findRandomPlaneByType(flightRequest.getPlaneType());
        List<Airport> airports = airportService.findAirportsWithinMaxHours(
                flightRequest,
                plane.getSpeedInKnots());
        //this constructor automatically calculates flight time/distance
        return new FlightResponse(airports.get(0), airports.get(1), plane);
    }
}
