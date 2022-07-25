package MSFSFlightGenerator.customflightgen.plane;

import MSFSFlightGenerator.customflightgen.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

//    public void saveNewPlane(Plane plane){
//        planeRepository.save(plane);
//    }

    public Plane findRandomPlane(){
        return planeRepository.getRandomPlane();
    }

    public void savePlanesFromCsv() throws IOException {
        File file = new File("Text-files/planes.csv");
        Files.lines(file.toPath())
                .forEach(a -> {
                    a = a.replace("\"", "");
                    String[] array = a.split(",");
                    planeRepository.save(new Plane(
                            array[0],
                            array[4],
                            Integer.parseInt(array[1]),
                            Integer.parseInt(array[2]),
                            array[3]));
                });
    }
}
