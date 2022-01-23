package lemsolaris.model.employee;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_phantom")
@Data
@NoArgsConstructor
public class EmployeePhantom extends Employee {
    @ManyToOne
    @JoinColumn(name = "human_host", referencedColumnName = "employee_id")
    private Employee humanHost;

    @Column(name = "lifetime_start")
    private LocalDateTime lifetimeStart;

    @Column(name = "lifetime_end")
    private LocalDateTime lifetimeEnd;

    public EmployeePhantom(String fullName, int age, Profession profession, Employee humanHost, LocalDateTime lifetimeStart, LocalDateTime lifetimeEnd) {
        super(fullName, EmployeeType.Phantom, EmployeeStatus.Hired, 0, age, profession);
        this.humanHost = humanHost;
        this.lifetimeStart = lifetimeStart;
        this.lifetimeEnd = lifetimeEnd;
    }
}
