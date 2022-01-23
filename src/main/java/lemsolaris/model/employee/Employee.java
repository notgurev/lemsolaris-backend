package lemsolaris.model.employee;

import lemsolaris.model.flight.Flight;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @Column(name = "salary")
    private int salary;

    @Column(name = "age")
    private int age;

    @Column(name = "profession")
    @Enumerated(EnumType.STRING)
    private Profession profession;

    @ManyToMany
    @JoinTable(
            name = "employee_flight",
            inverseJoinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)},
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)}
    )
    private Collection<Flight> flights = new ArrayList<>();

    public Employee(String fullName, EmployeeType type, EmployeeStatus status,
                    int salary, int age, Profession profession) {
        this.fullName = fullName;
        this.type = type;
        this.status = status;
        this.salary = salary;
        this.age = age;
        this.profession = profession;
    }
}
