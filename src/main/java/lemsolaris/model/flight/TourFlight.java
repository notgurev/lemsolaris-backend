package lemsolaris.model.flight;

import lemsolaris.model.anomaly.Anomaly;
import lemsolaris.model.other.Ship;
import lemsolaris.model.reports.TourReport;
import lemsolaris.util.TimeUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    public TourFlight(Ship ship, Anomaly target, int ticketPrice) {
        super(FlightType.Tourist, ship, FlightStatus.Planned, 0, TimeUtil.tomorrow(), target);
        this.ticketPrice = ticketPrice;
        this.numberOfSeats = ship.getCrewCapacity();
        this.report = null;
    }
}
