package lemsolaris.model.anomaly;

import lemsolaris.model.enums.AnomalyHazardLevel;
import lemsolaris.model.enums.AnomalyStatus;
import lemsolaris.model.enums.AnomalyType;
import lemsolaris.model.reports.AnomalyReport;
import lemsolaris.model.other.Coordinates;
import lemsolaris.model.flight.FlightAnomalyOrder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "anomaly")
public class Anomaly {
    private int id;
    @Enumerated(EnumType.STRING)
    private AnomalyStatus statusOfAnomaly;
    @Enumerated(EnumType.STRING)
    private AnomalyType typeOfAnomaly;
    @Enumerated(EnumType.STRING)
    private AnomalyHazardLevel anomalyHazardLevel;
    private int flightRadius;
    private Integer coordsId;
    private Coordinates coordinatesByCoordsId;
    private Collection<AnomalyReport> anomalyReportsById;
    private Collection<FlightAnomalyOrder> flightAnomalyOrdersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status_of_anomaly", nullable = false)
    public AnomalyStatus getStatusOfAnomaly() {
        return statusOfAnomaly;
    }

    public void setStatusOfAnomaly(AnomalyStatus statusOfAnomaly) {
        this.statusOfAnomaly = statusOfAnomaly;
    }

    @Basic
    @Column(name = "type_of_anomaly", nullable = true)
    public AnomalyType getTypeOfAnomaly() {
        return typeOfAnomaly;
    }

    public void setTypeOfAnomaly(AnomalyType typeOfAnomaly) {
        this.typeOfAnomaly = typeOfAnomaly;
    }

    @Basic
    @Column(name = "anomaly_hazard_level", nullable = true)
    public AnomalyHazardLevel getAnomalyHazardLevel() {
        return anomalyHazardLevel;
    }

    public void setAnomalyHazardLevel(AnomalyHazardLevel anomalyHazardLevel) {
        this.anomalyHazardLevel = anomalyHazardLevel;
    }

    @Basic
    @Column(name = "flight_radius", nullable = false)
    public int getFlightRadius() {
        return flightRadius;
    }

    public void setFlightRadius(int flightRadius) {
        this.flightRadius = flightRadius;
    }

    @Basic
    @Column(name = "coords_id", nullable = true)
    public Integer getCoordsId() {
        return coordsId;
    }

    public void setCoordsId(Integer coordsId) {
        this.coordsId = coordsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anomaly that = (Anomaly) o;

        if (id != that.id) return false;
        if (flightRadius != that.flightRadius) return false;
        if (statusOfAnomaly != null ? !statusOfAnomaly.equals(that.statusOfAnomaly) : that.statusOfAnomaly != null)
            return false;
        if (typeOfAnomaly != null ? !typeOfAnomaly.equals(that.typeOfAnomaly) : that.typeOfAnomaly != null)
            return false;
        if (anomalyHazardLevel != null ? !anomalyHazardLevel.equals(that.anomalyHazardLevel) : that.anomalyHazardLevel != null)
            return false;
        if (coordsId != null ? !coordsId.equals(that.coordsId) : that.coordsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusOfAnomaly != null ? statusOfAnomaly.hashCode() : 0);
        result = 31 * result + (typeOfAnomaly != null ? typeOfAnomaly.hashCode() : 0);
        result = 31 * result + (anomalyHazardLevel != null ? anomalyHazardLevel.hashCode() : 0);
        result = 31 * result + flightRadius;
        result = 31 * result + (coordsId != null ? coordsId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "coords_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Coordinates getCoordinatesByCoordsId() {
        return coordinatesByCoordsId;
    }

    public void setCoordinatesByCoordsId(Coordinates coordinatesByCoordsId) {
        this.coordinatesByCoordsId = coordinatesByCoordsId;
    }

    @OneToMany(mappedBy = "anomalyByAnomalyId")
    public Collection<AnomalyReport> getAnomalyReportsById() {
        return anomalyReportsById;
    }

    public void setAnomalyReportsById(Collection<AnomalyReport> anomalyReportsById) {
        this.anomalyReportsById = anomalyReportsById;
    }

    @OneToMany(mappedBy = "anomalyByAnomalyId")
    public Collection<FlightAnomalyOrder> getFlightAnomalyOrdersById() {
        return flightAnomalyOrdersById;
    }

    public void setFlightAnomalyOrdersById(Collection<FlightAnomalyOrder> flightAnomalyOrdersById) {
        this.flightAnomalyOrdersById = flightAnomalyOrdersById;
    }
}
