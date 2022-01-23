package lemsolaris.model.flight;

import lemsolaris.model.other.Ship;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Flight {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
}
