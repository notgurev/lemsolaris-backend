package lemsolaris.model.logs;

import lemsolaris.model.employee.Employee;
import lemsolaris.model.other.StockResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    private Long id;

    @ManyToOne
    @Column(name = "employee_id")
    private Employee employee;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "type")
    private String type;

    @Column(name = "resource_id")
    @ManyToOne
    private StockResource resource;

    @Column(name = "amount")
    private int amount;
}
