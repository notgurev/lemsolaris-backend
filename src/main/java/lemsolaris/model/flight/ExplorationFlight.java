package lemsolaris.model.flight;

import lemsolaris.model.reports.AnomalyReport;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "exploration_flight")
@Getter
@Setter
public class ExplorationFlight extends Flight {
    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private AnomalyReport report;
}
