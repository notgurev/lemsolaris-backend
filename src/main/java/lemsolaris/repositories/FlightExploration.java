package lemsolaris.repositories;

import lemsolaris.model.flight.ExplorationFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightExploration extends JpaRepository<ExplorationFlight, Integer> {
    ExplorationFlight findById(Long id);
}
