package lemsolaris.repositories;

import lemsolaris.model.anomaly.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AnomalyRepository extends JpaRepository<Anomaly, Integer> {
    @Query(value = "SELECT * FROM anomaly WHERE status_of_anomaly='Explored'", nativeQuery = true)
    Collection<Anomaly> findAllByStatusOfAnomaly();
}
