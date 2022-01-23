package lemsolaris.model.anomaly;

import lemsolaris.model.other.Coordinates;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "anomaly")
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="anomaly_seq")
    private Long id;

    @Column(name = "status_of_anomaly")
    @Enumerated(EnumType.STRING)
    private AnomalyStatus status;

    @Column(name = "type_of_anomaly")
    @Enumerated(EnumType.STRING)
    private AnomalyType type;

    @Column(name = "anomaly_hazard_level")
    @Enumerated(EnumType.STRING)
    private HazardLevel hazardLevel;

    @Column(name = "flight_radius")
    private int flightRadius;

    @OneToOne
    @JoinColumn(name = "coords_id", referencedColumnName = "id")
    private Coordinates coordinates;

    public Anomaly(AnomalyStatus status, AnomalyType type, HazardLevel hazardLevel, int flightRadius, Coordinates coordinates) {
        this.status = status;
        this.type = type;
        this.hazardLevel = hazardLevel;
        this.flightRadius = flightRadius;
        this.coordinates = coordinates;
    }
}
