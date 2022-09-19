package MSFSFlightGenerator.controller;

import MSFSFlightGenerator.model.entity.PopularRoute;
import MSFSFlightGenerator.service.PopularRouteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://127.0.0.1:5500"})
@RequestMapping("/api/v1/routes")
@AllArgsConstructor
public class PopularRouteController {

    @Autowired
    private PopularRouteService popularRouteService;

    @RequestMapping(value = "/all")
    public List<PopularRoute> getAllRoutes(){
        return popularRouteService.findAllRoutes();
    }

    @RequestMapping(value = "/ranking/{ranking}")
    public PopularRoute getRouteByRanking(@PathVariable int ranking){
        return popularRouteService.findRouteById(ranking);
    }
}
