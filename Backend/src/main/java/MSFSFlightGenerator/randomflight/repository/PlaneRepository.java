package MSFSFlightGenerator.randomflight.repository;

import MSFSFlightGenerator.randomflight.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaneRepository extends JpaRepository<Plane, String> {

    //Get one random plane in database
    @Query(value = "SELECT * FROM plane ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Plane getRandomPlane();
}
