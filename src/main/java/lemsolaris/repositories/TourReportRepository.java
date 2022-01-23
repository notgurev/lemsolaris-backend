package lemsolaris.repositories;

import lemsolaris.model.reports.TourReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourReportRepository extends JpaRepository<TourReport, Long> {
}
