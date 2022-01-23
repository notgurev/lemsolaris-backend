package lemsolaris.services;

import lemsolaris.model.employee.Employee;
import lemsolaris.model.employee.EmployeeStatus;
import lemsolaris.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository<Employee> employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository<Employee> employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Collection<Employee> getCandidates() {
        return employeeRepository.findEmployeesByStatus(EmployeeStatus.Candidate);
    }

    public Collection<Employee> getHired() {
        return employeeRepository.findEmployeesByStatus(EmployeeStatus.Hired);
    }

    public void fireEmployee(long id) {
        Optional<Employee> opt = employeeRepository.findById(id);

        if (!opt.isPresent()) {
            throw new RuntimeException("No employee with id = " + id);
        }

        Employee employee = opt.get();

        employee.setStatus(EmployeeStatus.Fired);

        // todo kill phantom, remove from flights, mark flights as reqChanges, pay severance
    }

    public void hireEmployee(long id) {
        Optional<Employee> opt = employeeRepository.findById(id);

        if (!opt.isPresent()) {
            throw new RuntimeException("No employee with id = " + id);
        }

        Employee employee = opt.get();

        if (employee.getStatus() != EmployeeStatus.Candidate) {
            throw new RuntimeException("This employee is not a candidate for hire");
        }

        employee.setStatus(EmployeeStatus.Hired);
        employeeRepository.save(employee);
    }
}
