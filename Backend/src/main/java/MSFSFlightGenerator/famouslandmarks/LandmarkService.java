package MSFSFlightGenerator.famouslandmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;

    @Autowired
    public LandmarkService(LandmarkRepository landmarkRepository){
        this.landmarkRepository = landmarkRepository;
    }

    public void saveLandmark(Landmark landmark){
        landmarkRepository.save(landmark);
    }

    public List<Landmark> getLandmarks(){
        return landmarkRepository.findAll();
    }
}
