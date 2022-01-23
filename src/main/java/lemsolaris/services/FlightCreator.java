package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.TourFlight;
import lemsolaris.model.other.Coordinates;
import lemsolaris.model.other.Ship;
import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.repositories.FlightRepository;
import lemsolaris.repositories.ShipRepository;
import lemsolaris.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightCreator {
    private final FlightRepository<ExplorationFlight> explorationFlights;
    private final FlightRepository<TourFlight> touristFlights;
    private final ShipRepository ships;
    private final AnomalyRepository anomalies;

    // Services
    private final DistanceCalculator distanceCalculator;
    private final AnomalyService anomalyService;
    private final ShipService shipService;

    @Autowired
    public FlightCreator(FlightRepository<ExplorationFlight> explorationFlights,
                         FlightRepository<TourFlight> touristFlights,
                         ShipRepository ships,
                         AnomalyRepository anomalies,
                         DistanceCalculator distanceCalculator,
                         AnomalyService anomalyService,
                         ShipService shipService) {
        this.explorationFlights = explorationFlights;
        this.touristFlights = touristFlights;
        this.ships = ships;
        this.anomalies = anomalies;
        this.distanceCalculator = distanceCalculator;
        this.anomalyService = anomalyService;
        this.shipService = shipService;
    }

    public long createExplorationToAnomaly(long id) {
        Anomaly anomaly = anomalyService.findAnomalyById(id);

        Coordinates c = anomaly.getCoordinates();
        int distance = distanceCalculator.calculate(c.getX(), c.getY());

        Ship ship = shipService.findSuitableShip("Exploration", distance);
        ExplorationFlight explorationFlight = new ExplorationFlight(
                ship,
                anomaly,
                distanceCalculator.calculateEndTime(Utility.tomorrow(), distance)
        );
        explorationFlights.save(explorationFlight);
        // todo add employees
        return explorationFlight.getId();
    }

    public long createTourFlightToAnomaly(long id) {
        return 0;
    }
}
