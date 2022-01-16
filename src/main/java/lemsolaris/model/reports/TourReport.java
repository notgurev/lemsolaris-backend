package lemsolaris.model.reports;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tour_report")
public class TourReport {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "successful")
    private boolean successful;

    @Column(name = "profit")
    private int profit;
}
