package lemsolaris.model.flight;

import lemsolaris.model.reports.TourReport;
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

    public TourFlight(int ticketPrice, int numberOfSeats, TourReport report) {
        this.ticketPrice = ticketPrice;
        this.numberOfSeats = numberOfSeats;
        this.report = report;
    }
}
