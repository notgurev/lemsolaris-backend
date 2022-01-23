package lemsolaris.services;

import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.Flight;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.repositories.AnomalyReportRepository;
import lemsolaris.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FlightService {
    final FlightRepository<Flight> flightRepository;
    final
    AnomalyReportRepository anomalyReportRepository;


    @Autowired
    public FlightService(FlightRepository<Flight> flightRepository, AnomalyReportRepository anomalyReportRepository) {
        this.flightRepository = flightRepository;
        this.anomalyReportRepository = anomalyReportRepository;
    }


    public Collection<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public AnomalyReport getExplorationReport(long id) {
        return anomalyReportRepository.findById(id).get();
    }

}
