package MSFSFlightGenerator.service;

import MSFSFlightGenerator.exception.PopularRouteNotFoundException;
import MSFSFlightGenerator.model.entity.PopularRoute;
import MSFSFlightGenerator.repository.PopularRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularRouteService {

    private final PopularRouteRepository routeRepository;

    @Autowired
    public PopularRouteService(PopularRouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    public List<PopularRoute> getAllRoutes(){
        return routeRepository.findAll();
    }

    public PopularRoute findRouteById(int id){
        return routeRepository.findById(id)
                .orElseThrow(() -> new PopularRouteNotFoundException("cannot find route"));
    }

    public void saveRouteToDb(PopularRoute popularRoute){
        routeRepository.save(popularRoute);
    }
}
