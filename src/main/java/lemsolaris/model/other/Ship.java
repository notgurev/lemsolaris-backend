package lemsolaris.model.other;

import lemsolaris.model.flight.Flight;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ship")
public class Ship {
    private int id;
    private String type;
    private int fuelCapacity;
    private int durability;
    private int crewCapacity;
    private Collection<Flight> flightsById;

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "fuel_capacity", nullable = false)
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Basic
    @Column(name = "durability", nullable = false)
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Basic
    @Column(name = "crew_capacity", nullable = false)
    public int getCrewCapacity() {
        return crewCapacity;
    }

    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship that = (Ship) o;

        if (id != that.id) return false;
        if (fuelCapacity != that.fuelCapacity) return false;
        if (durability != that.durability) return false;
        if (crewCapacity != that.crewCapacity) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + fuelCapacity;
        result = 31 * result + durability;
        result = 31 * result + crewCapacity;
        return result;
    }

    @OneToMany(mappedBy = "shipByShipId")
    public Collection<Flight> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(Collection<Flight> flightsById) {
        this.flightsById = flightsById;
    }
}
