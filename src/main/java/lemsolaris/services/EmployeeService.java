package lemsolaris.services;

import com.github.javafaker.Faker;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.employee.EmployeePhantom;
import lemsolaris.model.employee.EmployeeStatus;
import lemsolaris.model.employee.EmployeeType;
import lemsolaris.repositories.EmployeeRepository;
import lemsolaris.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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


        ArrayList<Employee> employeeArrayList = (ArrayList<Employee>) employeeRepository.findEmployeesByStatus(EmployeeStatus.Dead).stream().collect(Collectors.toList());

        if(employeeArrayList.isEmpty()){
            throw new RuntimeException("No dead peoples");
        }

        int random_int = randomIntInRange(1, employeeArrayList.size());


        employeePhantom.setFullName(employeeArrayList.get(random_int).getFullName());
        employeePhantom.setAge(employeeArrayList.get(random_int).getAge());
        employeePhantom.setProfession(employeeArrayList.get(random_int).getProfession());
        employeePhantom.setType(EmployeeType.Phantom);
        employeePhantom.setStatus(EmployeeStatus.Hired);
        employeePhantom.setId(employeeArrayList.get(random_int).getId());
        employeePhantom.setSalary(0);


        Employee employee = opt.get();
        //тут нужно чтобы только у одного чела мог быть фантом.
        //и по времени убивать его
        employeePhantom.setHumanHost(employee);
        employeePhantom.setLifetimeStart(TimeUtil.now());
        employeePhantom.setLifetimeStart(TimeUtil.now().plusDays(randomIntInRange(1, 10)));

        employeeRepository.save(employeePhantom);
    }
}
