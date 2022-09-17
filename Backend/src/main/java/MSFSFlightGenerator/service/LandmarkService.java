package MSFSFlightGenerator.service;

import MSFSFlightGenerator.model.entity.Landmark;
import MSFSFlightGenerator.repository.LandmarkRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LandmarkService {

    @Autowired
    private final LandmarkRepository landmarkRepository;

    public void saveLandmark(Landmark landmark){
        landmarkRepository.save(landmark);
    }

    public List<Landmark> getLandmarks(){
        return landmarkRepository.findAll();
    }

    public Long getDatabaseRowCount(){
        return landmarkRepository.count();
    }
}
