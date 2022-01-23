package lemsolaris.repositories;

import lemsolaris.model.other.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinates, Long> {
}
