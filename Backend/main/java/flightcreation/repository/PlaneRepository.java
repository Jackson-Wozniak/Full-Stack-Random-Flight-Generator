package flightcreation.repository;

import flightcreation.model.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaneRepository extends JpaRepository<Plane, String> {

    //Get one random plane in database
    @Query(value = "SELECT * FROM plane ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Plane getRandomPlane();

    @Query(value = "SELECT * FROM plane WHERE type = :planeType ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Plane getRandomPlaneByType(@Param("planeType")String type);
}
