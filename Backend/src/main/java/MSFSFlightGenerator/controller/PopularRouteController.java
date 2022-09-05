package MSFSFlightGenerator.controller;

import MSFSFlightGenerator.model.entity.PopularRoute;
import MSFSFlightGenerator.savetodatabase.SavePopularRouteFromCsv;
import MSFSFlightGenerator.service.PopularRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://127.0.0.1:5500"})
@RequestMapping("routes")
public class PopularRouteController {

    @Autowired
    private PopularRouteService popularRouteService;
    @Autowired
    private SavePopularRouteFromCsv savePopularRouteFromCsv;

    @RequestMapping(value = "/find-All")
    public List<PopularRoute> returnAllRoutes(){
        return popularRouteService.getAllRoutes();
    }

    @RequestMapping(value = "/ranking={ranking}")
    public PopularRoute returnRouteByRanking(@PathVariable int ranking){
        return popularRouteService.findRouteById(ranking);
    }
}
