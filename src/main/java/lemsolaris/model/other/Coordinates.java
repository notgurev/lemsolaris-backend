package lemsolaris.model.other;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
