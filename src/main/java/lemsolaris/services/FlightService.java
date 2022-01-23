package lemsolaris.services;

import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.Flight;
import lemsolaris.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FlightService {
    final FlightRepository<Flight> flightRepository;
    final FlightRepository<ExplorationFlight> explorationFlightRepository;

    @Autowired
    public FlightService(FlightRepository<Flight> flightRepository,
                         FlightRepository<ExplorationFlight> explorationFlightRepository) {
        this.flightRepository = flightRepository;
        this.explorationFlightRepository = explorationFlightRepository;
    }


    public Collection<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public ExplorationFlight getExplorationReport(long id) {
        return explorationFlightRepository.findById(id).get();
    }
}
