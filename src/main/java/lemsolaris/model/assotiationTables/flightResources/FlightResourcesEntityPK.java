package lemsolaris.model.assotiationTables.flightResources;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FlightResourcesEntityPK implements Serializable {
    private int resourceId;
    private int flightId;

    @Column(name = "resource_id", nullable = false)
    @Id
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Column(name = "flight_id", nullable = false)
    @Id
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightResourcesEntityPK that = (FlightResourcesEntityPK) o;

        if (resourceId != that.resourceId) return false;
        if (flightId != that.flightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId;
        result = 31 * result + flightId;
        return result;
    }
}
