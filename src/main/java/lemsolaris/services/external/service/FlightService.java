package lemsolaris.services.external.service;

import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.Flight;
import lemsolaris.repositories.FlightExploration;
import lemsolaris.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FlightService {
    final FlightRepository<Flight> flightRepository;
    final FlightExploration flightExploration;

    public FlightService(FlightRepository<Flight> flightRepository, FlightExploration flightExploration) {
        this.flightRepository = flightRepository;
        this.flightExploration = flightExploration;
    }


    public Collection<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public ExplorationFlight getReport(int id) {
        return flightExploration.findById(id).get();
    }
}
