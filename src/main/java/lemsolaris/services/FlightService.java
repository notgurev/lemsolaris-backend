package lemsolaris.services;

import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.Flight;
import lemsolaris.model.flight.FlightStatus;
import lemsolaris.model.flight.FlightType;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.model.reports.TourReport;
import lemsolaris.repositories.AnomalyReportRepository;
import lemsolaris.repositories.FlightRepository;
import lemsolaris.repositories.TourReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FlightService {
    // Services
    private final AnomalyService anomalyService;
    private final ReportService reportService;

    // Repositories
    private final FlightRepository<Flight> flightRepository;
    private final AnomalyReportRepository anomalyReportRepository;
    private final TourReportRepository tourReportRepository;


    @Autowired
    public FlightService(AnomalyService anomalyService,
                         ReportService reportService,
                         FlightRepository<Flight> flightRepository,
                         AnomalyReportRepository anomalyReportRepository,
                         TourReportRepository tourReportRepository) {
        this.anomalyService = anomalyService;
        this.reportService = reportService;
        this.flightRepository = flightRepository;
        this.anomalyReportRepository = anomalyReportRepository;
        this.tourReportRepository = tourReportRepository;
    }


    public Collection<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Optional<AnomalyReport> getExplorationReport(long id) {
        return anomalyReportRepository.findById(id);
    }

    public void cancelFlightById(int id) {
        Flight f = findFlightById(id);
        if (f.getStatus() != FlightStatus.Planned) {
            throw new RuntimeException("Can only cancel planned flights");
        }
        f.setStatus(FlightStatus.Cancelled);
        // todo free employees, return resources
        flightRepository.save(f);
    }
    public void startFlight(long flightId) {
        Flight f = findFlightById(flightId);
        if (f.getStatus() != FlightStatus.Planned) {
            throw new RuntimeException("Can only start planned flights");
        }
        f.setStatus(FlightStatus.Ongoing);
    }

    private Flight findFlightById(long id) {
        Optional<Flight> opt = flightRepository.findById(id);
        if (!opt.isPresent()) throw new RuntimeException("No flight with id = " + id);
        return opt.get();
    }
}
