package MSFSFlightGenerator.popularflights.route;

import MSFSFlightGenerator.popularflights.CustomRouteException;
import MSFSFlightGenerator.popularflights.route.Route;
import MSFSFlightGenerator.popularflights.route.RouteRepository;
import MSFSFlightGenerator.randomflight.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

    public Route findRouteById(int id) throws CustomRouteException {
        return routeRepository.findById(id)
                .orElseThrow(() -> new CustomRouteException("cannot find route"));
    }

    public void saveRouteToDb(Route route){
        routeRepository.save(route);
    }
}
