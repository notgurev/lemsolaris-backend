package lemsolaris.model.employee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_human")
@Data
public class EmployeeHuman extends Employee {
    @Column(name = "current_MHI")
    private int currentMHI;

    @Column(name = "base_MHI")
    private int baseMHI;

    @Column(name = "mental_resistance")
    private int mentalResistance;
}
