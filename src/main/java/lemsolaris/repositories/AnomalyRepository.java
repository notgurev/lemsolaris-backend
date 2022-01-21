package lemsolaris.repositories;

import lemsolaris.model.anomaly.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalyRepository extends JpaRepository<Long, Anomaly> {

}
