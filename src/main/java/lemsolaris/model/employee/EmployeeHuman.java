package lemsolaris.model.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_human")
@Data
@NoArgsConstructor
public class EmployeeHuman extends Employee {
    @Column(name = "current_MHI")
    private int currentMHI;

    @Column(name = "base_MHI")
    private int baseMHI;

    @Column(name = "mental_resistance")
    private int mentalResistance;

    public EmployeeHuman(String fullName, EmployeeStatus status, int salary, int age,
                         Profession profession, int baseMHI, int mentalResistance) {
        super(fullName, EmployeeType.Human, status, salary, age, profession);
        this.currentMHI = baseMHI;
        this.baseMHI = baseMHI;
        this.mentalResistance = mentalResistance;
    }
}
