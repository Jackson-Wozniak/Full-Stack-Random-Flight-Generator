package MSFSFlightGenerator.savetodatabase;

import MSFSFlightGenerator.model.entity.PopularRoute;
import MSFSFlightGenerator.service.PopularRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class SavePopularRouteFromCsv {

    private final PopularRouteService popularRouteService;

    @Autowired
    public SavePopularRouteFromCsv(PopularRouteService popularRouteService){
        this.popularRouteService = popularRouteService;
    }

    public void saveRouteFromCsv() throws IOException {
        File file = new File("Text-files/routes.csv");
        Files.lines(file.toPath()).forEach(route -> {
            String[] data = route.split(",");
            popularRouteService.saveRouteToDb(new PopularRoute(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3],
                    data[4]));
        });
    }


}
