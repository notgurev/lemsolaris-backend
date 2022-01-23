package lemsolaris.services.generators;

import lemsolaris.model.reports.TourReport;
import lemsolaris.repositories.TourReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    final
    TourReportRepository reportRepository;

    public TourService(TourReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public TourReport getTourReportById(int id){
        return reportRepository.findTourReportById((long) id);
    }
}
