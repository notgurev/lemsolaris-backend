package lemsolaris.model.logs;

import lemsolaris.model.employee.Employee;
import lemsolaris.model.other.StockResource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    private StockResource resource;

    @Column(name = "amount")
    private int amount;
}
