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

    /*
    returns flight with no parameters, totally random
     */
    @GetMapping(value = "/random")
    public FlightResponse sendRandomFlight(){
        return new FlightResponse(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
    }

    /*
    returns flight parameters including the maximum flight time and plane type
     */
    @PostMapping(value = "/custom")
    public FlightResponse sendRandomFlightWithParameters(@RequestBody FlightRequest flightRequest){
        Plane plane = planeService.findRandomPlaneByType(flightRequest.getPlaneType());
        List<Airport> airports = airportService.getAirportsWithMaxHours(
                flightRequest.getMaxFlightHours(),
                plane.getSpeedInKnots());

        return new FlightResponse(airports.get(0), airports.get(1), plane);
    }
}
