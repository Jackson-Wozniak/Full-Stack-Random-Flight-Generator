package MSFSFlightGenerator.controller;

import MSFSFlightGenerator.model.entity.Landmark;
import MSFSFlightGenerator.service.LandmarkService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://127.0.0.1:5500"})
@RequestMapping(value = "/api/v1/landmarks")
@AllArgsConstructor
public class LandmarkController {

    @Autowired
    private final LandmarkService landmarkService;

    //This is the only endpoint needed as frontend page displays a list of all landmarks
    @GetMapping(value = "/all")
    public List<Landmark> getAllLandmarks(){
        return landmarkService.findLandmarks();
    }

}
