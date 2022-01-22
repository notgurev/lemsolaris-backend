package lemsolaris.model.flight;

import lemsolaris.model.enums.FlightStatus;
import lemsolaris.model.enums.FlightType;
import lemsolaris.model.other.Ship;
import lemsolaris.model.reports.AnomalyReport;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "flight")
public class Flight {
    private int id;
    private FlightType type;
    private int shipId;
    private FlightStatus flightStatus;
    private int seatsTaken;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private Collection<AnomalyReport> anomalyReportsById;
    private Ship shipByShipId;
    private Collection<FlightAnomalyOrder> flightAnomalyOrdersById;
    private Collection<FlightResources> flightResourcesById;
    private Collection<TourFlight> tourFlightsById;

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
    public FlightType getType() {
        return type;
    }

    public void setType(FlightType type) {
        this.type = type;
    }

    @Basic
    @Column(name = "ship_id", nullable = false)
    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    @Basic
    @Column(name = "flight_status", nullable = false)
    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    @Basic
    @Column(name = "seats_taken", nullable = false)
    public int getSeatsTaken() {
        return seatsTaken;
    }

    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken = seatsTaken;
    }

    @Basic
    @Column(name = "time_start", nullable = false)
    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end", nullable = false)
    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight that = (Flight) o;

        if (id != that.id) return false;
        if (shipId != that.shipId) return false;
        if (seatsTaken != that.seatsTaken) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (flightStatus != null ? !flightStatus.equals(that.flightStatus) : that.flightStatus != null) return false;
        if (timeStart != null ? !timeStart.equals(that.timeStart) : that.timeStart != null) return false;
        if (timeEnd != null ? !timeEnd.equals(that.timeEnd) : that.timeEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + shipId;
        result = 31 * result + (flightStatus != null ? flightStatus.hashCode() : 0);
        result = 31 * result + seatsTaken;
        result = 31 * result + (timeStart != null ? timeStart.hashCode() : 0);
        result = 31 * result + (timeEnd != null ? timeEnd.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "flightByFlightId")
    public Collection<AnomalyReport> getAnomalyReportsById() {
        return anomalyReportsById;
    }

    public void setAnomalyReportsById(Collection<AnomalyReport> anomalyReportsById) {
        this.anomalyReportsById = anomalyReportsById;
    }

    @ManyToOne
    @JoinColumn(name = "ship_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Ship getShipByShipId() {
        return shipByShipId;
    }

    public void setShipByShipId(Ship shipByShipId) {
        this.shipByShipId = shipByShipId;
    }

    @OneToMany(mappedBy = "flightByFlightId")
    public Collection<FlightAnomalyOrder> getFlightAnomalyOrdersById() {
        return flightAnomalyOrdersById;
    }

    public void setFlightAnomalyOrdersById(Collection<FlightAnomalyOrder> flightAnomalyOrdersById) {
        this.flightAnomalyOrdersById = flightAnomalyOrdersById;
    }

    @OneToMany(mappedBy = "flightByFlightId")
    public Collection<FlightResources> getFlightResourcesById() {
        return flightResourcesById;
    }

    public void setFlightResourcesById(Collection<FlightResources> flightResourcesById) {
        this.flightResourcesById = flightResourcesById;
    }

    @OneToMany(mappedBy = "flightByFlightId")
    public Collection<TourFlight> getTourFlightsById() {
        return tourFlightsById;
    }

    public void setTourFlightsById(Collection<TourFlight> tourFlightsById) {
        this.tourFlightsById = tourFlightsById;
    }
}
