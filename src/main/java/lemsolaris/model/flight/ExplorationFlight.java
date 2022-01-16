package lemsolaris.model.flight;

import lemsolaris.model.reports.AnomalyReport;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exploration_flight")
@Getter
@Setter
public class ExplorationFlight extends Flight {
    @Column(name = "report_id")
    @OneToOne
    private AnomalyReport report;
}
