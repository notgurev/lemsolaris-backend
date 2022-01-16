package lemsolaris.model.other;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "coordinates")
public class Coordinates {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;
}
