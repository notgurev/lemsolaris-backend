package lemsolaris;

import lemsolaris.model.flight.TourFlight;
import lemsolaris.model.other.Ship;
import lemsolaris.model.other.StockResource;
import lemsolaris.repositories.FlightRepository;
import lemsolaris.repositories.ShipRepository;
import lemsolaris.repositories.StockResourceRepository;
import lemsolaris.services.generators.AnomalyGenerator;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CommandLineAppStartupRunner {
    private final FlightRepository<TourFlight> tourFlightRepository;
    private final AnomalyGenerator anomalyGenerator;
    private final StockResourceRepository resourceRepository;
    private final ShipRepository shipRepository;

    @Autowired
    public CommandLineAppStartupRunner(FlightRepository<TourFlight> tourFlightRepository,
                                       AnomalyGenerator anomalyGenerator,
                                       StockResourceRepository resourceRepository,
                                       ShipRepository shipRepository) {
        this.tourFlightRepository = tourFlightRepository;
        this.anomalyGenerator = anomalyGenerator;
        this.resourceRepository = resourceRepository;
        this.shipRepository = shipRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void fillTables() {
        TourFlight tourFlight = new TourFlight(100, 20, null);
        TourFlight t2 = new TourFlight(200, 30, null);
        tourFlightRepository.save(tourFlight);
        tourFlightRepository.save(t2);
        System.out.println(anomalyGenerator.generateRandomAnomaly());

        // Anomalies
        for (int i = 0; i < 10; i++) {
            long id = anomalyGenerator.generateRandomAnomaly();
            anomalyGenerator.exploreAnomaly(id);
        }

        // Ships
        {
            val s1 = new Ship("Tourist", 500, 3, 6);
            val s2 = new Ship("Exploration", 700, 5, 3);
            shipRepository.save(s1);
            shipRepository.save(s2);
        }

        // Resources
        {
            val res = new StockResource("Money", 10000, 1);
            resourceRepository.save(res);
            resourceRepository.save(new StockResource("Fuel", 5000, 10));
            tourFlight.getResources().add(res);
        }
    }
}

