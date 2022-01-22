package lemsolaris.repositories;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.services.internal.AnomalyService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnomalyRepository extends JpaRepository<Anomaly, Integer> {

}
