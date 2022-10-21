package MSFSFlightGenerator.configuration;

import MSFSFlightGenerator.service.AirportService;
import MSFSFlightGenerator.service.LandmarkService;
import MSFSFlightGenerator.service.PlaneService;
import MSFSFlightGenerator.service.PopularRouteService;
import MSFSFlightGenerator.utils.CsvToDatabaseUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

@Configuration
@RequiredArgsConstructor
public class DataConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DataConfiguration.class);

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

    /*
        This method tests the row count of all database items on startup.
        If the row count doesn't match the csv file length, it saves the csv data to the DB
     */
    @PostConstruct
    public void findDatabaseSizeOnStartup(){
        if(airportService.findDatabaseRowCount() < 9000){
            logger.info("Saving Airports");
            try{
                CsvToDatabaseUtils.saveAirportsFromCsv(airportFile, this.airportService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(planeService.findDatabaseRowCount() < 30){
            logger.info("Saving Planes");
            try{
                CsvToDatabaseUtils.savePlanesFromCsv(planeFile, this.planeService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(landmarkService.findDatabaseRowCount() < 5){
            logger.info("Saving Landmarks");
            try{
                CsvToDatabaseUtils.saveLandmarkToDb(landmarkFile, this.landmarkService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(popularRouteService.findDatabaseRowCount() < 10){
            logger.info("Saving Routes");
            try{
                CsvToDatabaseUtils.saveRouteFromCsv(routeFile, this.popularRouteService);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        logger.info("Airport DB Row Count: " + getAirportRowCount());
        logger.info("Plane DB Row Count: " + getPlaneRowCount());
        logger.info("Landmark DB Row Count: " + getLandmarkRowCount());
        logger.info("Route DB Row Count: " + getRouteRowCount());
    }

    //these methods are used mainly for testing
    private Long getAirportRowCount(){
        return airportService.findDatabaseRowCount();
    }

    private Long getPlaneRowCount(){
        return planeService.findDatabaseRowCount();
    }

    private Long getLandmarkRowCount(){
        return landmarkService.findDatabaseRowCount();
    }

    private Long getRouteRowCount(){
        return popularRouteService.findDatabaseRowCount();
    }
}
