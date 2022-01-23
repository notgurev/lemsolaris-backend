package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.other.Ship;
import lemsolaris.model.other.StockResource;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static lemsolaris.services.DistanceCalculator.calculateEndTime;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Flight {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private FlightType type;

    @ManyToOne
    @JoinColumn(name = "ship_id", referencedColumnName = "id")
    private Ship ship;

    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @Column(name = "seats_taken")
    private int seatsTaken;

    @Column(name = "time_start")
    private LocalDateTime timeStart;

    @Column(name = "time_end")
    private LocalDateTime timeEnd;

    @ManyToOne
    private Anomaly targetAnomaly;

    @ManyToMany
    @JoinTable(
            name = "flight_resources",
            joinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id", nullable = false)}
    )
    private Collection<StockResource> resources = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "employee_flight",
            joinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)}
    )
    private Collection<Employee> crew = new ArrayList<>();

    public Flight(FlightType type, Ship ship, FlightStatus status, int seatsTaken,
                  LocalDateTime timeStart, Anomaly targetAnomaly) {
        this.type = type;
        this.ship = ship;
        this.status = status;
        this.seatsTaken = seatsTaken;
        this.timeStart = timeStart;
        this.timeEnd = calculateEndTime(this.timeStart, targetAnomaly.getCoordinates());
        this.targetAnomaly = targetAnomaly;
    }
}
