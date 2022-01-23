package lemsolaris.repositories;

import lemsolaris.model.other.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findAllByShipTypeAndFuelCapacityGreaterThanOrderByCrewCapacity(String shipType, int fuelCapacity);
}
