package lemsolaris.repositories;

import lemsolaris.model.flight.Flight;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FlightRepository<T extends Flight> extends JpaRepository<T, Long> {

}

