package lemsolaris.model.reports;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.flight.Flight;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "anomaly_report")
@Data
public class AnomalyReport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="anomaly_report_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "employee_id")
    private Employee author;

    @Column(name = "success")
    private boolean successful;

    @Column(name = "anomaly_type")
    private String anomalyType;

    @Column(name = "anomaly_hazard_level")
    private String anomalyHazardLevel;

    @Column(name = "anomaly_flight_radius")
    private int anomalyFlightRadius;

    @ManyToOne
    @JoinColumn(name = "anomaly_id", referencedColumnName = "id")
    private Anomaly anomaly;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;
}
