package MSFSFlightGenerator.randomflight.repository;

import MSFSFlightGenerator.randomflight.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AirportRepository extends JpaRepository<Airport, String> {

    @Query(value = "SELECT * FROM airport ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Airport getRandomAirport();
}
