package MSFSFlightGenerator.service;

import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveNewPlane(Plane plane){
        planeRepository.save(plane);
    }

    public Long findDatabaseRowCount(){
        return planeRepository.count();
    }
}
