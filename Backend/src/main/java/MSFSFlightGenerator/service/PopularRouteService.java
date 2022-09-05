package MSFSFlightGenerator.service;

import MSFSFlightGenerator.exception.PopularRouteNotFoundException;
import MSFSFlightGenerator.model.entity.PopularRoute;
import MSFSFlightGenerator.repository.PopularRouteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PopularRouteService {

    @Autowired
    private final PopularRouteRepository routeRepository;

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
