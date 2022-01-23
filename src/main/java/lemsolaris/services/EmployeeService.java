package lemsolaris.services;

import com.github.javafaker.Faker;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.employee.EmployeePhantom;
import lemsolaris.model.employee.EmployeeStatus;
import lemsolaris.repositories.EmployeeRepository;
import lemsolaris.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static lemsolaris.util.RandomUtil.randomIntInRange;

@Service
public class EmployeeService {
    private final EmployeeRepository<Employee> employeeRepository;
    private final EmployeeRepository<EmployeePhantom> employeePhantomEmployeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository<Employee> employeeRepository, EmployeeRepository<EmployeePhantom> employeePhantomEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.employeePhantomEmployeeRepository = employeePhantomEmployeeRepository;
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

    public void createPhantomById(long id) {
        Optional<Employee> opt = employeeRepository.findById(id);

        if (!opt.isPresent()) {
            throw new RuntimeException("No employee with id = " + id);
        }

        EmployeePhantom employeePhantom = new EmployeePhantom();

        //я хз, в human надо добавить список людей которых знает человек. и оттуда любого умершего данные в фантома переносить.

        Employee employee = opt.get();
        employeePhantom.setHumanHost(employee);
        employeePhantom.setLifetimeStart(TimeUtil.now());
        employeePhantom.setLifetimeStart(TimeUtil.now().plusDays(randomIntInRange(1, 10)));

    }
}
