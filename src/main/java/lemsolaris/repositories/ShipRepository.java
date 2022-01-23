package lemsolaris.repositories;

import lemsolaris.model.other.Ship;
import lemsolaris.model.other.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    @Query("select s from Ship s where s.shipType = :shipType and s.fuelCapacity > :fuelCapacity")
    List<Ship> findAllByShipTypeAndFuelCapacityGreaterThan(ShipType shipType, int fuelCapacity);
}
