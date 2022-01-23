package lemsolaris.repositories;

import lemsolaris.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

//@NoRepositoryBean
public interface FlightRepository<T extends Flight> extends JpaRepository<T, Long> {
}

