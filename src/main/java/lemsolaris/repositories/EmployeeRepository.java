package lemsolaris.repositories;

import lemsolaris.model.employee.Employee;
import lemsolaris.model.employee.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository<T extends Employee> extends JpaRepository<T, Long> {
//    @Query("select e from Employee e where e.status = 'Candidate'")
//    List<T> findCandidates();

    Collection<T> findEmployeesByStatus(EmployeeStatus status);
}
