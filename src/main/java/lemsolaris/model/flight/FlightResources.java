package lemsolaris.model.flight;

import lemsolaris.model.assotiationTables.flightResources.FlightResourcesEntityPK;
import lemsolaris.model.other.ResourcesInStock;

import javax.persistence.*;

@Entity
@Table(name = "flight_resources")
@IdClass(FlightResourcesEntityPK.class)
public class FlightResources {
    private int resourceId;
    private int flightId;
    private int quantity;
    private ResourcesInStock resourcesInStockByResourceId;
    private Flight flightByFlightId;

    @Id
    @Column(name = "resource_id", nullable = false)
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Id
    @Column(name = "flight_id", nullable = false)
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightResources that = (FlightResources) o;

        if (resourceId != that.resourceId) return false;
        if (flightId != that.flightId) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId;
        result = 31 * result + flightId;
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ResourcesInStock getResourcesInStockByResourceId() {
        return resourcesInStockByResourceId;
    }

    public void setResourcesInStockByResourceId(ResourcesInStock resourcesInStockByResourceId) {
        this.resourcesInStockByResourceId = resourcesInStockByResourceId;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Flight getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(Flight flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }
}
