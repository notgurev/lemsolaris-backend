package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.flight.ExplorationFlight;
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
    // Services
    private final AnomalyService anomalyService;

    @Autowired
    public ReportService(AnomalyReportRepository anomalyReportRepository, TourReportRepository tourReportRepository, AnomalyService anomalyService) {
        this.anomalyReportRepository = anomalyReportRepository;
        this.tourReportRepository = tourReportRepository;
        this.anomalyService = anomalyService;
    }

    public AnomalyReport getAnomalyReport(long flightId) { // flightId == reportId for that flight
        return anomalyReportRepository.getById(flightId);
    }

    public TourReport getTourReport(long flightId) { // flightId == reportId for that flight
        return tourReportRepository.getById(flightId);
    }

    public void createAnomalyReport(ExplorationFlight flight) {
        Employee scientist = flight.getScientistFromCrew();
        Anomaly a = anomalyService.exploreAnomaly(flight.getTargetAnomaly());
        AnomalyReport anomalyReport = new AnomalyReport(
                scientist, true, a.getType(), a.getHazardLevel(), a.getFlightRadius(), a, flight
        );
        anomalyReportRepository.save(anomalyReport);
    }

    public void createTourReport(TourFlight flight) {
        TourReport tourReport = new TourReport();
        tourReport.setSuccessful(true);
        tourReport.setFlight(flight);
        // TODO: это костыль: пилот + врач + ученый = 3
        tourReport.setProfit((flight.getSeatsTaken() - 3) * flight.getTicketPrice());
    }
}
