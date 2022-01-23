package lemsolaris.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "salary")
    private int salary;

    @Column(name = "age")
    private int age;

    @Column(name = "profession")
    private String profession;
}
