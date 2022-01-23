package lemsolaris.model.employee;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employee")
@Data
@NoArgsConstructor
public  class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_seq")
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

    public Employee(String fullName, String type, String status, int salary, int age, String profession) {
        this.fullName = fullName;
        this.type = type;
        this.status = status;
        this.salary = salary;
        this.age = age;
        this.profession = profession;
    }
}
