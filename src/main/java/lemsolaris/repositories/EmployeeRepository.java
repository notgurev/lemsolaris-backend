package lemsolaris.repositories;

import lemsolaris.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository<T extends Employee> extends JpaRepository<T, Long> {
}
