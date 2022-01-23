package lemsolaris.model.reports;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tour_report")
@Data
public class TourReport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tour_report_seq")
    private Long id;

    @Column(name = "successful")
    private boolean successful;

    @Column(name = "profit")
    private int profit;
}
