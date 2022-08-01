package MSFSFlightGenerator.famouslandmarks.utils;

import MSFSFlightGenerator.famouslandmarks.landmark.Landmark;
import MSFSFlightGenerator.famouslandmarks.landmark.LandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class SaveLandmarkFromCsv {

    private final LandmarkService landmarkService;

    @Autowired
    public SaveLandmarkFromCsv(LandmarkService landmarkService){
        this.landmarkService = landmarkService;
    }

    public void saveLandmarkToDb() throws IOException {
        File file = new File("Text-files/landmarks.csv");

        Files.lines(file.toPath()).forEach(a -> {
            String[] array = a.split("\\)\\(");
            landmarkService.saveLandmark(new Landmark(
                    array[0],
                    array[1],
                    array[2],
                    array[3],
                    array[4]));
        });
    }
}
