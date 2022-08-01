package MSFSFlightGenerator.popularflights.utils;

import MSFSFlightGenerator.popularflights.route.Route;
import MSFSFlightGenerator.popularflights.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class SaveRouteToDatabase {

    private RouteService routeService;

    @Autowired
    public SaveRouteToDatabase(RouteService routeService){
        this.routeService = routeService;
    }

    public void saveRouteFromCsv() throws IOException {
        File file = new File("Text-files/routes.csv");
        Files.lines(file.toPath()).forEach(route -> {
            String[] data = route.split(",");
            routeService.saveRouteToDb(new Route(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3],
                    data[4]));
        });
    }


}
