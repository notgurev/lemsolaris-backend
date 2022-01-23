package lemsolaris.model.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_phantom")
@Getter
@Setter
public class EmployeePhantom extends Employee {
    @ManyToOne
    @JoinColumn(name = "human_host", referencedColumnName = "employee_id")
    private Employee humanHost;

    @Column(name = "lifetime")
    private LocalDateTime lifetime;
}
