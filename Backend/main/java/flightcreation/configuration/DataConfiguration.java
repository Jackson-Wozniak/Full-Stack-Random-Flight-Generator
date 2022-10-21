package flightcreation.configuration;

import flightcreation.service.AirportService;
import flightcreation.service.PlaneService;
import flightcreation.utils.CsvToDatabaseUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Date;

@Configuration
@RequiredArgsConstructor
public class DataConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DataConfiguration.class);

    @Autowired
    private final AirportService airportService;
    @Autowired
    private final PlaneService planeService;

    private static final File airportFile = new File("Data/airports.csv");
    private static final File planeFile = new File("Data/planes.csv");

    /*
        This method tests the row count of all database items on startup.
        If the row count doesn't match the csv file length, it saves the csv data to the DB
     */
    @PostConstruct
    public void findDatabaseSizeOnStartup(){
        if(airportService.findDatabaseRowCount() < 9000){
            logger.info("Saving Airports");
            try{
                airportService.saveAllAirports(CsvToDatabaseUtils.ConvertCsvToAirports(airportFile));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(planeService.findDatabaseRowCount() < 30){
            logger.info("Saving Planes");
            try{
                planeService.saveAllPlanes(CsvToDatabaseUtils.savePlanesFromCsv(planeFile));
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        logger.info("Airport DB Row Count: " + getAirportRowCount());
        logger.info("Plane DB Row Count: " + getPlaneRowCount());
    }

    //these methods are used mainly for testing
    private Long getAirportRowCount(){
        return airportService.findDatabaseRowCount();
    }

    private Long getPlaneRowCount(){
        return planeService.findDatabaseRowCount();
    }
}
