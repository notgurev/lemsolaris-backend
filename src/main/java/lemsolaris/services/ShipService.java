package lemsolaris.services;

import lemsolaris.model.other.Ship;
import lemsolaris.model.other.ShipType;
import lemsolaris.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static lemsolaris.util.RandomNumbers.randomIntInRange;

@Service
public class ShipService {
    private final ShipRepository ships;

    @Autowired
    public ShipService(ShipRepository ships) {
        this.ships = ships;
    }

    public Ship findSuitableShip(ShipType type, int distance) {
        List<Ship> explorationShips = ships.findAllByShipTypeAndFuelCapacityGreaterThan(
                type, distance
        );

        if (explorationShips.size() == 0) {
            throw new RuntimeException(
                    "No ships with enough fuel capacity for distance = " + distance +
                            " with type " + type
            );
        }

        return explorationShips.get(randomIntInRange(0, explorationShips.size()));
    }
}
