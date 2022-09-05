package MSFSFlightGenerator.repository;

import MSFSFlightGenerator.model.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkRepository extends JpaRepository<Landmark, String> {
}
