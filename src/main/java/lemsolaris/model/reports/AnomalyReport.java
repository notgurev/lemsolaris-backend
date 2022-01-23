package lemsolaris.model.reports;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.anomaly.AnomalyType;
import lemsolaris.model.anomaly.HazardLevel;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.flight.Flight;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "anomaly_report")
@Data
public class AnomalyReport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anomaly_report_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "employee_id")
    private Employee author;

    @Column(name = "success")
    private boolean successful;

    @Column(name = "anomaly_type")
    private AnomalyType anomalyType;

    @Column(name = "anomaly_hazard_level")
    private HazardLevel anomalyHazardLevel;

    @Column(name = "anomaly_flight_radius")
    private int anomalyFlightRadius;

    @ManyToOne
    @JoinColumn(name = "anomaly_id", referencedColumnName = "id")
    private Anomaly anomaly;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    public AnomalyReport(Employee author, boolean successful, AnomalyType anomalyType,
                         HazardLevel anomalyHazardLevel, int anomalyFlightRadius,
                         Anomaly anomaly, Flight flight) {
        this.author = author;
        this.successful = successful;
        this.anomalyType = anomalyType;
        this.anomalyHazardLevel = anomalyHazardLevel;
        this.anomalyFlightRadius = anomalyFlightRadius;
        this.anomaly = anomaly;
        this.flight = flight;
    }
}
