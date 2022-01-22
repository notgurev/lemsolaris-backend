package lemsolaris.model.other;

import lemsolaris.model.enums.ResourceType;
import lemsolaris.model.flight.FlightResources;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "resources_in_stock")
public class ResourcesInStock {
    private int id;
    private ResourceType type;
    private int quantity;
    private Integer marketPrice;
    private Collection<FlightResources> flightResourcesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "market_price", nullable = true)
    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourcesInStock that = (ResourcesInStock) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (marketPrice != null ? !marketPrice.equals(that.marketPrice) : that.marketPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "resourcesInStockByResourceId")
    public Collection<FlightResources> getFlightResourcesById() {
        return flightResourcesById;
    }

    public void setFlightResourcesById(Collection<FlightResources> flightResourcesById) {
        this.flightResourcesById = flightResourcesById;
    }
}
