package lemsolaris.services;

import lemsolaris.model.flight.TourFlight;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.model.reports.TourReport;
import lemsolaris.repositories.AnomalyReportRepository;
import lemsolaris.repositories.TourReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final AnomalyReportRepository anomalyReportRepository;
    private final TourReportRepository tourReportRepository;

    @Autowired
    public ReportService(AnomalyReportRepository anomalyReportRepository, TourReportRepository tourReportRepository) {
        this.anomalyReportRepository = anomalyReportRepository;
        this.tourReportRepository = tourReportRepository;
    }

    public AnomalyReport getAnomalyReport(long flightId) { // flightId == reportId for that flight
        return anomalyReportRepository.getById(flightId);
    }

    public TourReport getTourReport(long flightId) { // flightId == reportId for that flight
        return tourReportRepository.getById(flightId);
    }

    public void createAnomalyReport(int anomalyId) {

    }

    public void createTourReport(TourFlight flight) {
        TourReport tourReport = new TourReport();
        tourReport.setSuccessful(true);
        tourReport.setFlight(flight);
        // TODO: это костыль: пилот + врач + ученый = 3
        tourReport.setProfit((flight.getSeatsTaken() - 3) * flight.getTicketPrice());
    }
}
