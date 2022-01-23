package lemsolaris.repositories;

import lemsolaris.model.other.StockResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockResourceRepository extends JpaRepository<StockResource, Long> {
}
