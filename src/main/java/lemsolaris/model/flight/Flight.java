package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
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
    private String type;

    @ManyToOne
    @JoinColumn(name = "ship_id", referencedColumnName = "id")
    private Ship ship;

    @Column(name = "flight_status")
    private String status;

    @Column(name = "seats_taken")
    private int seatsTaken;

    @Column(name = "time_start")
    private LocalDateTime timeStart;

    @Column(name = "time_end")
    private LocalDateTime timeEnd;

    @Column(name = "target_anomaly")
    @ManyToOne
    private Anomaly targetAnomaly;

    @ManyToMany
    @JoinTable(
            name = "flight_resources",
            joinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id", nullable = false)}
    )
    private Collection<StockResource> resources = new ArrayList<>();

    public Flight(String type, Ship ship, String status, int seatsTaken,
                  LocalDateTime timeStart, LocalDateTime timeEnd) {
        this.type = type;
        this.ship = ship;
        this.status = status;
        this.seatsTaken = seatsTaken;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }
}
