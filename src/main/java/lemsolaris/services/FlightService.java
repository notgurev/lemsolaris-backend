package lemsolaris.services;

import lemsolaris.model.flight.Flight;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.repositories.AnomalyReportRepository;
import lemsolaris.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FlightService {
    final FlightRepository<Flight> flightRepository;
    final AnomalyReportRepository anomalyReportRepository;


    @Autowired
    public FlightService(FlightRepository<Flight> flightRepository, AnomalyReportRepository anomalyReportRepository) {
        this.flightRepository = flightRepository;
        this.anomalyReportRepository = anomalyReportRepository;
    }


    public Collection<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Optional<AnomalyReport> getExplorationReport(long id) {
        return anomalyReportRepository.findById(id);
    }

    public void cancelFlightById(int id) {
        //todo - отмена вылета
    }
}
