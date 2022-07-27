package MSFSFlightGenerator.randomflight.service;

import MSFSFlightGenerator.randomflight.entity.Plane;
import MSFSFlightGenerator.randomflight.exception.CustomException;
import MSFSFlightGenerator.randomflight.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }

    public Plane findPlaneById(String name){
        return planeRepository.findById(name)
                .orElseThrow(() -> new CustomException("cannot find plane"));
    }

    public List<Plane> findAllPlanes(){
        return planeRepository.findAll();
    }

    public void saveNewPlane(Plane plane){
        planeRepository.save(plane);
    }

    public Plane findRandomPlane(){
        return planeRepository.getRandomPlane();
    }

    public Plane findRandomPlaneByType(String type){
        return planeRepository.getRandomPlaneByType(type);
    }




}
