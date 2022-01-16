package lemsolaris.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_human")
@Getter
@Setter
public class EmployeeHuman extends Employee {
    @Id
    @Column(name = "employee_id")
    private Long id;

    @JoinTable
    @ManyToMany
    private List<Employee> contacts;

    @Column(name = "current_MHI")
    private int currentMHI;

    @Column(name = "base_MHI")
    private int baseMHI;

    @Column(name = "mental_resistance")
    private int mentalResistance;
}
