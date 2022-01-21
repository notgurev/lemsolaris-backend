package lemsolaris.model.logs;

import lemsolaris.model.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employment")
@Getter
@Setter
public class Employment {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Column(name = "assigned_status")
    private String assignedStatus;

    @Column(name = "date")
    private LocalDateTime date;
}
