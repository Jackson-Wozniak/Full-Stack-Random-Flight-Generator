package MSFSFlightGenerator.data;

import MSFSFlightGenerator.service.AirportService;
import MSFSFlightGenerator.service.LandmarkService;
import MSFSFlightGenerator.service.PlaneService;
import MSFSFlightGenerator.service.PopularRouteService;
import MSFSFlightGenerator.utils.CsvToDatabaseUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SaveDataOnStartup {

    private final Logger logger = LoggerFactory.getLogger(SaveDataOnStartup.class);

    @Autowired
    private final AirportService airportService;
    @Autowired
    private final PlaneService planeService;
    @Autowired
    private final LandmarkService landmarkService;
    @Autowired
    private final PopularRouteService popularRouteService;

    private static final File airportFile = new File("Text-files/airports.csv");
    private static final File planeFile = new File("Text-files/planes.csv");
    private static final File landmarkFile = new File("Text-files/landmarks.csv");
    private static final File routeFile = new File("Text-files/routes.csv");

    @PostConstruct
    public void testDatabaseSizeOnStartup(){
        if(airportService.getDatabaseRowCount() < 9000){
            System.out.println("Saving Airports");
            try{
                CsvToDatabaseUtils.saveAirportsFromCsv(airportFile, this.airportService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(planeService.getDatabaseRowCount() < 30){
            System.out.println("Saving Planes");
            try{
                CsvToDatabaseUtils.savePlanesFromCsv(planeFile, this.planeService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(landmarkService.getDatabaseRowCount() < 5){
            System.out.println("Saving Landmarks");
            try{
                CsvToDatabaseUtils.saveLandmarkToDb(landmarkFile, this.landmarkService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(popularRouteService.getDatabaseRowCount() < 10){
            System.out.println("Saving Routes");
            try{
                CsvToDatabaseUtils.saveRouteFromCsv(routeFile, this.popularRouteService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        logger.info("Airport DB Row Count: " + airportRowCount());
        logger.info("Plane DB Row Count: " + planeRowCount());
        logger.info("Landmark DB Row Count: " + landmarkRowCount());
        logger.info("Route DB Row Count: " + routeRowCount());
    }

    //these methods are used mainly for testing
    private Long airportRowCount(){
        return airportService.getDatabaseRowCount();
    }

    private Long planeRowCount(){
        return planeService.getDatabaseRowCount();
    }

    private Long landmarkRowCount(){
        return landmarkService.getDatabaseRowCount();
    }

    private Long routeRowCount(){
        return popularRouteService.getDatabaseRowCount();
    }
}
