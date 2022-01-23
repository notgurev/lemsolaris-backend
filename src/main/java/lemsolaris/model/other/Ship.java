package lemsolaris.model.other;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ship")
@Getter
@Setter
public class Ship {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "type")
    private String shipType;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "durability")
    private int durability;

    @Column(name = "crew_capacity")
    private int crewCapacity;
}
