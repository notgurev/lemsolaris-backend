package lemsolaris.model.reports;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.employee.Employee;
import lemsolaris.model.flight.ExplorationFlight;
import lemsolaris.model.flight.Flight;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "anomaly_report")
public class AnomalyReport {
    private int id;
    private int authorId;
    private boolean success;
    private String anomalyType;
    private String anomalyHazardLevel;
    private int anomalyFlightRadius;
    private Integer anomalyId;
    private Integer flightId;
    private Employee employeeByAuthorId;
    private Anomaly anomalyByAnomalyId;
    private Flight flightByFlightId;
    private Collection<ExplorationFlight> explorationFlightsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "author_id", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "success", nullable = false)
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Basic
    @Column(name = "anomaly_type", nullable = false)
    public String getAnomalyType() {
        return anomalyType;
    }

    public void setAnomalyType(String anomalyType) {
        this.anomalyType = anomalyType;
    }

    @Basic
    @Column(name = "anomaly_hazard_level", nullable = false)
    public String getAnomalyHazardLevel() {
        return anomalyHazardLevel;
    }

    public void setAnomalyHazardLevel(String anomalyHazardLevel) {
        this.anomalyHazardLevel = anomalyHazardLevel;
    }

    @Basic
    @Column(name = "anomaly_flight_radius", nullable = false)
    public int getAnomalyFlightRadius() {
        return anomalyFlightRadius;
    }

    public void setAnomalyFlightRadius(int anomalyFlightRadius) {
        this.anomalyFlightRadius = anomalyFlightRadius;
    }

    @Basic
    @Column(name = "anomaly_id", nullable = true)
    public Integer getAnomalyId() {
        return anomalyId;
    }

    public void setAnomalyId(Integer anomalyId) {
        this.anomalyId = anomalyId;
    }

    @Basic
    @Column(name = "flight_id", nullable = true)
    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnomalyReport that = (AnomalyReport) o;

        if (id != that.id) return false;
        if (authorId != that.authorId) return false;
        if (success != that.success) return false;
        if (anomalyFlightRadius != that.anomalyFlightRadius) return false;
        if (anomalyType != null ? !anomalyType.equals(that.anomalyType) : that.anomalyType != null) return false;
        if (anomalyHazardLevel != null ? !anomalyHazardLevel.equals(that.anomalyHazardLevel) : that.anomalyHazardLevel != null)
            return false;
        if (anomalyId != null ? !anomalyId.equals(that.anomalyId) : that.anomalyId != null) return false;
        if (flightId != null ? !flightId.equals(that.flightId) : that.flightId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authorId;
        result = 31 * result + (success ? 1 : 0);
        result = 31 * result + (anomalyType != null ? anomalyType.hashCode() : 0);
        result = 31 * result + (anomalyHazardLevel != null ? anomalyHazardLevel.hashCode() : 0);
        result = 31 * result + anomalyFlightRadius;
        result = 31 * result + (anomalyId != null ? anomalyId.hashCode() : 0);
        result = 31 * result + (flightId != null ? flightId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "employee_id", nullable = false, insertable = false, updatable = false)
    public Employee getEmployeeByAuthorId() {
        return employeeByAuthorId;
    }

    public void setEmployeeByAuthorId(Employee employeeByAuthorId) {
        this.employeeByAuthorId = employeeByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "anomaly_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Anomaly getAnomalyByAnomalyId() {
        return anomalyByAnomalyId;
    }

    public void setAnomalyByAnomalyId(Anomaly anomalyByAnomalyId) {
        this.anomalyByAnomalyId = anomalyByAnomalyId;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Flight getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(Flight flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }

    @OneToMany(mappedBy = "anomalyReportByReportId")
    public Collection<ExplorationFlight> getExplorationFlightsById() {
        return explorationFlightsById;
    }

    public void setExplorationFlightsById(Collection<ExplorationFlight> explorationFlightsById) {
        this.explorationFlightsById = explorationFlightsById;
    }
}
