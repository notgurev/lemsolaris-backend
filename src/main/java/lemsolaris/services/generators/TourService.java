package lemsolaris.services.generators;

import lemsolaris.model.reports.TourReport;
import lemsolaris.repositories.TourReportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourService {
    final
    TourReportRepository reportRepository;

    public TourService(TourReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Optional<TourReport> getTourReportById(int id){
        return reportRepository.findById((long) id);
    }
}
