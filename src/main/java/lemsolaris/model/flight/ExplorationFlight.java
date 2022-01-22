package lemsolaris.model.flight;

import lemsolaris.model.reports.AnomalyReport;

import javax.persistence.*;

@Entity
@Table(name = "exploration_flight")
public class ExplorationFlight {
    private int id;
    private Integer reportId;
    private AnomalyReport anomalyReportByReportId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "report_id", nullable = true)
    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExplorationFlight that = (ExplorationFlight) o;

        if (id != that.id) return false;
        if (reportId != null ? !reportId.equals(that.reportId) : that.reportId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reportId != null ? reportId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AnomalyReport getAnomalyReportByReportId() {
        return anomalyReportByReportId;
    }

    public void setAnomalyReportByReportId(AnomalyReport anomalyReportByReportId) {
        this.anomalyReportByReportId = anomalyReportByReportId;
    }
}
