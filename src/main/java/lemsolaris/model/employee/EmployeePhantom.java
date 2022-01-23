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

    @Column(name = "lifetime")
    private LocalDateTime lifetime;

    public EmployeePhantom(String fullName, int age, String profession, Employee humanHost, LocalDateTime lifetime) {
        super(fullName, "Phantom", "Hired", 0, age, profession);
        this.humanHost = humanHost;
        this.lifetime = lifetime;
    }
}
