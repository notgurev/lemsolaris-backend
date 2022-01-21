package lemsolaris.model.flight;

import lemsolaris.model.reports.TourReport;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tour_flight")
@Getter
@Setter
public class TourFlight extends Flight {
    @Column(name = "ticket_price")
    private int ticketPrice;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @OneToOne
    @JoinColumn(name = "report", referencedColumnName = "id")
    private TourReport report;
}
