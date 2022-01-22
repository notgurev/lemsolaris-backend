package lemsolaris.model.assotiationTables.anomalyOrder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FlightAnomalyOrderEntityPK implements Serializable {
    private int flightId;
    private int anomalyId;

    @Column(name = "flight_id", nullable = false)
    @Id
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Column(name = "anomaly_id", nullable = false)
    @Id
    public int getAnomalyId() {
        return anomalyId;
    }

    public void setAnomalyId(int anomalyId) {
        this.anomalyId = anomalyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightAnomalyOrderEntityPK that = (FlightAnomalyOrderEntityPK) o;

        if (flightId != that.flightId) return false;
        if (anomalyId != that.anomalyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + anomalyId;
        return result;
    }
}
