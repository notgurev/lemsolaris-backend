package lemsolaris.model.reports;

import javax.persistence.*;

@Entity
@Table(name = "tour_report")
public class TourReport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "successful")
    private boolean successful;

    @Column(name = "profit")
    private int profit;
}
