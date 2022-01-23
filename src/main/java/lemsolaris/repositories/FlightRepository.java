package lemsolaris.repositories;

import lemsolaris.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository<T extends Flight> extends JpaRepository<T, Long> {
    @Query("select f from Flight f where f.timeEnd <= current_timestamp ")
    List<T> findFinished();

    @Query("select f from Flight f where f.timeStart >= current_timestamp ")
    List<T> findStarted();
}

