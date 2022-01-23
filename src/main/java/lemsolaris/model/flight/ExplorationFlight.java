package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.employee.Profession;
import lemsolaris.model.other.Ship;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.util.TimeUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    public Employee getScientistFromCrew() {
        return super.getCrew().stream()
                .filter(employee -> employee.getProfession() == Profession.Scientist)
                .findFirst().orElseThrow(() -> {
                    throw new RuntimeException("Failed to find scientist in crew");
                });
    }
}
