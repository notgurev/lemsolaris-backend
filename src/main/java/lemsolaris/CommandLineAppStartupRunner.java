package lemsolaris;

import lemsolaris.model.flight.TourFlight;
import lemsolaris.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner {
    final FlightRepository<TourFlight> tourFlightRepository;

    public CommandLineAppStartupRunner(@Autowired FlightRepository<TourFlight> tourFlightRepository) {
        this.tourFlightRepository = tourFlightRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        TourFlight tourFlight = new TourFlight(100, 20, null);
        TourFlight t2 = new TourFlight(200, 30, null);
        tourFlightRepository.save(tourFlight);
        tourFlightRepository.save(t2);
    }
}

