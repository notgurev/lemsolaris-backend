package lemsolaris.model.anomaly;

import lemsolaris.model.other.Coordinates;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "anomaly")
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "status_of_anomaly")
    private String status;

    @Column(name = "type_of_anomaly")
    private String type;

    @Column(name = "anomaly_hazard_level")
    private String hazardLevel;

    @Column(name = "flight_radius")
    private int flightRadius;

    @OneToOne
    @JoinColumn(name = "coords_id", referencedColumnName = "id")
    private Coordinates coordinates;
}
