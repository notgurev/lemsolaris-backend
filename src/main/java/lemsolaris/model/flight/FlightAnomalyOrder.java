package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.assotiationTables.anomalyOrder.FlightAnomalyOrderEntityPK;

import javax.persistence.*;

@Entity
@Table(name = "flight_anomaly_order")
@IdClass(FlightAnomalyOrderEntityPK.class)
public class FlightAnomalyOrder {
    private int flightId;
    private int anomalyId;
    private int anomalyOrder;
    private Flight flightByFlightId;
    private Anomaly anomalyByAnomalyId;

    @Id
    @Column(name = "flight_id", nullable = false)
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Id
    @Column(name = "anomaly_id", nullable = false)
    public int getAnomalyId() {
        return anomalyId;
    }

    public void setAnomalyId(int anomalyId) {
        this.anomalyId = anomalyId;
    }

    @Basic
    @Column(name = "anomaly_order", nullable = false)
    public int getAnomalyOrder() {
        return anomalyOrder;
    }

    public void setAnomalyOrder(int anomalyOrder) {
        this.anomalyOrder = anomalyOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightAnomalyOrder that = (FlightAnomalyOrder) o;

        if (flightId != that.flightId) return false;
        if (anomalyId != that.anomalyId) return false;
        if (anomalyOrder != that.anomalyOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + anomalyId;
        result = 31 * result + anomalyOrder;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Flight getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(Flight flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }

    @ManyToOne
    @JoinColumn(name = "anomaly_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Anomaly getAnomalyByAnomalyId() {
        return anomalyByAnomalyId;
    }

    public void setAnomalyByAnomalyId(Anomaly anomalyByAnomalyId) {
        this.anomalyByAnomalyId = anomalyByAnomalyId;
    }
}
