package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.other.Ship;
import lemsolaris.model.reports.TourReport;
import lemsolaris.util.Utility;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tour_flight")
@Data
@NoArgsConstructor
public class TourFlight extends Flight {
    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @OneToOne
    @JoinColumn(name = "report", referencedColumnName = "id")
    private TourReport report;

    /**
     * Create planned tourist flight
     */
    public TourFlight(Ship ship, int ticketPrice, Anomaly target, LocalDateTime timeEnd) {
        super("Sightseeing", ship, "Planned", 0, Utility.tomorrow(), timeEnd, target);
        this.ticketPrice = ticketPrice;
        this.numberOfSeats = ship.getCrewCapacity();
        this.report = null;
    }
}
