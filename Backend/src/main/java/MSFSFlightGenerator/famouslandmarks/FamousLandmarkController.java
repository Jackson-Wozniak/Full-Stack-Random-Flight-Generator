package MSFSFlightGenerator.famouslandmarks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "landmarks")
public class FamousLandmarkController {

    @GetMapping(value = "/get-all")
    public List<Landmark> returnAllLandmarks(){
        return List.of(new Landmark());
    }

    @GetMapping(value = "/get-random")
    public Landmark returnRandomLandmark(){
        return new Landmark();
    }
}
