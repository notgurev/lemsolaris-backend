package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.other.Ship;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.util.TimeUtil;
import lemsolaris.util.Utility;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "exploration_flight")
@Data
@NoArgsConstructor
public class ExplorationFlight extends Flight {
    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private AnomalyReport report;

    public ExplorationFlight(Ship ship, Anomaly target) {
        super(FlightType.Exploration, ship, FlightStatus.Planned, 0, TimeUtil.tomorrow(), target);
    }
}
