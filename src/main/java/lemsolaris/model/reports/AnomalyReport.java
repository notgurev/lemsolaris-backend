package lemsolaris.model.reports;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.flight.Flight;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "anomaly_report")
@Getter
@Setter
public class AnomalyReport {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "author_id")
    @ManyToOne
    private Employee author;

    @Column(name = "success")
    private boolean successful;

    @Column(name = "anomaly_type")
    private String anomalyType;

    @Column(name = "anomaly_hazard_level")
    private String anomalyHazardLevel;

    @Column(name = "anomaly_flight_radius")
    private int anomalyFlightRadius;

    @Column(name = "anomaly_id")
    @ManyToOne
    private Anomaly anomaly;

    @Column(name = "flight_id")
    @ManyToOne
    private Flight flight;
}
