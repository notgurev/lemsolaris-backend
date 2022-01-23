package lemsolaris.repositories;

import lemsolaris.model.anomaly.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly, Long> {
    Collection<Anomaly> getAnomaliesByStatusAndHazardLevel(String status, String hazard);
    Collection<Anomaly> getAnomaliesByStatus(String status);
}
