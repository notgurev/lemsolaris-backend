package lemsolaris.repositories;

import lemsolaris.model.reports.TourReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourReportRepository extends JpaRepository<TourReport, Long> {
}
