package lemsolaris.repositories;

import lemsolaris.model.reports.AnomalyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<AnomalyReport, Long> {
     AnomalyReport getAnomalyReportById(int id);
}
