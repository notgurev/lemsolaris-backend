package lemsolaris.services;

import lemsolaris.model.other.Coordinates;
import lemsolaris.model.other.Ship;
import lemsolaris.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static lemsolaris.util.Utility.randomIntInRange;

@Service
public class ShipService {
    private final ShipRepository ships;

    @Autowired
    public ShipService(ShipRepository ships) {
        this.ships = ships;
    }

    public Ship findSuitableShip(String type, int distance) {
        List<Ship> explorationShips = ships.findAllByShipTypeAndFuelCapacityGreaterThanOrderByCrewCapacity(
                type, distance
        );

        if (explorationShips.size() == 0) {
            throw new RuntimeException("No ships with enough fuel capacity for distance = " + distance);
        }

        return explorationShips.get(randomIntInRange(0, explorationShips.size()));
    }
}
