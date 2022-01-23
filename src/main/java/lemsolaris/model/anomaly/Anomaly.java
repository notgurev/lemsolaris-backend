package lemsolaris.model.anomaly;

import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.model.other.Coordinates;
import lemsolaris.model.flight.FlightAnomalyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "anomaly")
@Getter
@Setter
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "status_of_anomaly", nullable = false)
    private String statusOfAnomaly;
    @Column(name = "type_of_anomaly", nullable = true)
    private String typeOfAnomaly;
    @Column(name = "anomaly_hazard_level", nullable = true)
    private String anomalyHazardLevel;
    @Column(name = "flight_radius", nullable = false)
    private int flightRadius;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coords_id", nullable = false)
    private Coordinates coordinatesByCoordsId;
    @OneToMany(mappedBy = "anomalyId")
    private Collection<FlightAnomalyOrder> flightAnomalyOrdersById;
    @OneToMany(mappedBy = "id")
    private Collection<AnomalyReport> anomalyReportsById;

}
