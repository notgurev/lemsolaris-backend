package lemsolaris.repositories;

import lemsolaris.model.reports.AnomalyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalyReportRepository extends JpaRepository<AnomalyReport, Long> {
}
