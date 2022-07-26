package flightcreation.service;

import flightcreation.model.entity.Plane;
import flightcreation.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaneService {

    @Autowired
    private final PlaneRepository planeRepository;

    public List<Plane> findAllPlanes(){
        return planeRepository.findAll();
    }

    public Plane findRandomPlane(){
        return planeRepository.getRandomPlane();
    }

    public Plane findRandomPlaneByType(String type){
        if(type.equals("any")){
            return planeRepository.getRandomPlane();
        }
        return planeRepository.getRandomPlaneByType(type);
    }

    public void saveAllPlanes(Collection<Plane> planes){
        planeRepository.saveAll(planes);
    }

    public Long findDatabaseRowCount(){
        return planeRepository.count();
    }
}
