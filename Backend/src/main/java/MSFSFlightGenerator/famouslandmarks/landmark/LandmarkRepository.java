package MSFSFlightGenerator.famouslandmarks.landmark;

import MSFSFlightGenerator.famouslandmarks.landmark.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkRepository extends JpaRepository<Landmark, String> {
}
