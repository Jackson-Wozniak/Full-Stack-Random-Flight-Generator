package MSFSFlightGenerator.repository;

import MSFSFlightGenerator.model.entity.PopularRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopularRouteRepository extends JpaRepository<PopularRoute, Integer> {
}
