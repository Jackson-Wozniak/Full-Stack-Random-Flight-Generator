package MSFSFlightGenerator.controller;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.model.request.FlightRequest;
import MSFSFlightGenerator.model.response.FlightResponse;
import MSFSFlightGenerator.service.AirportService;
import MSFSFlightGenerator.service.PlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://127.0.0.1:5500"})
@RequestMapping(value = "/random")
public class FlightController {

    private final PlaneService planeService;
    private final AirportService airportService;

    public FlightController(PlaneService planeService, AirportService airportService){
        this.planeService = planeService;
        this.airportService = airportService;
    }

    /*
    returns flight with no parameters, totally random
     */
    @GetMapping(value = "/new-flight")
    public FlightResponse sendRandomFlight(){
        return new FlightResponse(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
    }

    /*
    returns flight parameters including the maximum flight time and plane type
     */
    @PostMapping(value = "custom-flight")
    public FlightResponse sendRandomFlightWithParameters(@RequestBody FlightRequest flightRequest){
        Plane plane = planeService.findRandomPlaneByType(flightRequest.getPlaneType());
        List<Airport> airports = airportService.getAirportsWithMaxHours(
                flightRequest.getMaxFlightHours(),
                plane.getSpeedInKnots());

        return new FlightResponse(airports.get(0), airports.get(1), plane);
    }
}
