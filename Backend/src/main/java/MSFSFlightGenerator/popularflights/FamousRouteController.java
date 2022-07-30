package MSFSFlightGenerator.popularflights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping("routes")
public class FamousRouteController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private SaveRouteToDatabase saveRouteToDatabase;

    @RequestMapping(value = "/find-All")
    public List<Route> returnAllRoutes(){
        return routeService.getAllRoutes();
    }
}
