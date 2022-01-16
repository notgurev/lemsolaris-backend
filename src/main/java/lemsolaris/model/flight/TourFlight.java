package lemsolaris.model.flight;

import lemsolaris.model.reports.TourReport;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tour_flight")
@Getter
@Setter
public class TourFlight extends Flight {
    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "report")
    @OneToOne
    private TourReport report;
}
