package lemsolaris.model.employee;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_phantom")
@Data
public class EmployeePhantom extends Employee {
    @ManyToOne
    @JoinColumn(name = "human_host", referencedColumnName = "employee_id")
    private Employee humanHost;

    @Column(name = "lifetime")
    private LocalDateTime lifetime;
}
