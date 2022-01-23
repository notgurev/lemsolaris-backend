package lemsolaris.repositories;

import lemsolaris.model.flight.FlightResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static lemsolaris.model.flight.FlightResource.FlightResourceId;

@Repository
public interface FlightResourceRepository extends JpaRepository<FlightResource, FlightResourceId> {
    List<FlightResource> findAllByFlightId(long flightId);

    List<FlightResource> deleteAllByFlightId(long flightId);
}
