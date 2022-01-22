package lemsolaris.model.flight;

import javax.persistence.*;

@Entity
@Table(name = "tour_flight")
public class TourFlight {
    private int id;
    private Integer flightId;
    private int ticketPrice;
    private int numberOfSeats;
    private Integer report;
    private Flight flightByFlightId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "flight_id", nullable = true)
    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "ticket_price", nullable = false)
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Basic
    @Column(name = "number_of_seats", nullable = false)
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Basic
    @Column(name = "report", nullable = true)
    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourFlight that = (TourFlight) o;

        if (id != that.id) return false;
        if (ticketPrice != that.ticketPrice) return false;
        if (numberOfSeats != that.numberOfSeats) return false;
        if (flightId != null ? !flightId.equals(that.flightId) : that.flightId != null) return false;
        if (report != null ? !report.equals(that.report) : that.report != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (flightId != null ? flightId.hashCode() : 0);
        result = 31 * result + ticketPrice;
        result = 31 * result + numberOfSeats;
        result = 31 * result + (report != null ? report.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Flight getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(Flight flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }
}
