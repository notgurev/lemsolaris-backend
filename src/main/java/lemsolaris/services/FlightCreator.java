package lemsolaris.services;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.TourFlight;
import lemsolaris.model.other.Ship;
import lemsolaris.repositories.AnomalyRepository;
import lemsolaris.repositories.FlightRepository;
import lemsolaris.repositories.ShipRepository;
import lemsolaris.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightCreator {
    private final FlightRepository<ExplorationFlight> explorationFlights;
    private final FlightRepository<TourFlight> touristFlights;
    private final ShipRepository ships;
    private final AnomalyRepository anomalies;
    private final DistanceCalculator distanceCalculator;

    @Autowired
    public FlightCreator(FlightRepository<ExplorationFlight> explorationFlights,
                         FlightRepository<TourFlight> touristFlights,
                         ShipRepository ships,
                         AnomalyRepository anomalies,
                         DistanceCalculator distanceCalculator) {
        this.explorationFlights = explorationFlights;
        this.touristFlights = touristFlights;
        this.ships = ships;
        this.anomalies = anomalies;
        this.distanceCalculator = distanceCalculator;
    }

    public long createExplorationToAnomaly(long id) {
        Optional<Anomaly> byId = anomalies.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Anomaly not found by id");
        }
        Anomaly anomaly = byId.get();

        long distance = (int) distanceCalculator.calculate(
                anomaly.getCoordinates().getX(),
                anomaly.getCoordinates().getY()
        );
        List<Ship> explorationShips = ships.findAllByShipTypeAndFuelCapacityGreaterThan(
                "Exploration", (int) distance);

        if (explorationShips.size() == 0) {
            throw new RuntimeException("No ships with enough fuel capacity for distance = " + distance);
        }

        Ship ship = explorationShips.get(Utility.randomIntInRange(0, explorationShips.size()));
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
