package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.Flight;
import lemsolaris.model.flight.TourFlight;
import lemsolaris.model.other.Coordinates;
import lemsolaris.model.other.Ship;
import lemsolaris.model.other.ShipType;
import lemsolaris.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lemsolaris.services.DistanceCalculator.calculateDistance;

@Service
public class FlightCreator {
    // Repositories
    private final FlightRepository<Flight> flights;

    // Services
    private final AnomalyService anomalyService;
    private final ShipService shipService;

    @Autowired
    public FlightCreator(FlightRepository<Flight> flights, AnomalyService anomalyService, ShipService shipService) {
        this.flights = flights;
        this.anomalyService = anomalyService;
        this.shipService = shipService;
    }

    public long createExplorationToAnomaly(long id) {
        Anomaly anomaly = anomalyService.findAnomalyById(id);

        Coordinates c = anomaly.getCoordinates();
        int distance = calculateDistance(c.getX(), c.getY());

        Ship ship = shipService.findSuitableShip(ShipType.Exploration, distance);
        Flight f = new ExplorationFlight(ship, anomaly);
        flights.save(f);

        // todo add employees

        return f.getId();
    }

    public long createTourFlightToAnomaly(long id, int ticketPrice) {
        Anomaly anomaly = anomalyService.findAnomalyById(id);

        Coordinates c = anomaly.getCoordinates();
        int distance = calculateDistance(c.getX(), c.getY());

        Ship ship = shipService.findSuitableShip(ShipType.Tourist, distance);

        Flight f = new TourFlight(ship, anomaly, ticketPrice);
        flights.save(f);

        // todo add employees and tourists

        return f.getId();
    }
}
