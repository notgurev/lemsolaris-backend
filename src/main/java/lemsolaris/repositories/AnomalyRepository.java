package lemsolaris.repositories;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.anomaly.AnomalyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly, Long> {
    Collection<Anomaly> getAnomaliesByStatusAndHazardLevel(AnomalyStatus status, String hazardLevel);

    Collection<Anomaly> getAnomaliesByStatus(AnomalyStatus status);
}
