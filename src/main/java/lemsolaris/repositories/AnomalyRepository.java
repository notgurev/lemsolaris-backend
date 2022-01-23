package lemsolaris.repositories;

import lemsolaris.model.anomaly.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AnomalyRepository extends JpaRepository<Anomaly, Integer> {

    Collection<Anomaly> getAnomaliesByStatusOfAnomalyAndAnomalyHazardLevel(String status, String hazard_level);
}
