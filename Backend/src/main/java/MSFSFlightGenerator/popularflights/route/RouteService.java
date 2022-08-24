package MSFSFlightGenerator.popularflights.route;

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
