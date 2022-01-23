package lemsolaris.model.reports;

import lemsolaris.model.flight.Flight;
import lemsolaris.model.flight.TourFlight;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tour_report")
@Data
@NoArgsConstructor
public class TourReport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_report_seq")
    private Long id;

    @Column(name = "successful")
    private boolean successful;

    @Column(name = "profit")
    private int profit;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private TourFlight flight;

    public TourReport(boolean successful, int profit, TourFlight flight) {
        this.successful = successful;
        this.profit = profit;
        this.flight = flight;
    }
}
