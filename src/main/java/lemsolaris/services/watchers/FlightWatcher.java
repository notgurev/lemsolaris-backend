package lemsolaris.services.watchers;

import lemsolaris.model.flight.Flight;
import lemsolaris.model.flight.FlightStatus;
import lemsolaris.repositories.FlightRepository;
import lemsolaris.services.FlightFinisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightWatcher {
    // Repositories
    private final FlightRepository<Flight> flights;

    // Services
    private final FlightFinisherService flightFinisherService;

    @Autowired
    public FlightWatcher(FlightRepository<Flight> flights, FlightFinisherService flightFinisherService) {
        this.flights = flights;
        this.flightFinisherService = flightFinisherService;
    }

    @Scheduled(fixedDelay = 1000 * 60)
    @Transactional
    void watchFlights() {
        // Start flights
        flights.findStarted().forEach(flight -> flight.setStatus(FlightStatus.Ongoing));

        // End flights
        flights.findFinished().forEach(flightFinisherService::finishFlight);
    }
}
