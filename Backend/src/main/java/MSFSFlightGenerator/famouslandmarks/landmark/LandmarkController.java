package MSFSFlightGenerator.famouslandmarks.landmark;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
@RequestMapping(value = "landmarks")
public class LandmarkController {

    private final LandmarkService landmarkService;

    public LandmarkController(LandmarkService landmarkService){
        this.landmarkService = landmarkService;
    }

    @GetMapping(value = "/get-all")
    public List<Landmark> returnAllLandmarks(){
        return landmarkService.getLandmarks();
    }

    @GetMapping(value = "/get-random")
    public Landmark returnRandomLandmark(){
        return new Landmark();
    }
}
