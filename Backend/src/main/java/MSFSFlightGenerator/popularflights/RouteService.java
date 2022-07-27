package MSFSFlightGenerator.popularflights;

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

    public void saveRouteToDb(Route route){
        routeRepository.save(route);
    }
}
