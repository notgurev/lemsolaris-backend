package lemsolaris.model.other;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "coordinates")
public class Coordinates {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;
}
