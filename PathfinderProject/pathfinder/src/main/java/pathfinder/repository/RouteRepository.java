package pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pathfinder.model.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
