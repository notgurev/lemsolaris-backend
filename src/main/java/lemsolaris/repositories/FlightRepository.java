package lemsolaris.repositories;

import lemsolaris.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository<T extends Flight> extends JpaRepository<T, Long> {
}

