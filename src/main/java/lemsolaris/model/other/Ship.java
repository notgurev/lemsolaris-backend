package lemsolaris.model.other;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ship")
@Data
@NoArgsConstructor
public class Ship {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ship_seq")
    private Long id;

    @Column(name = "type")
    private String shipType;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "durability")
    private int durability;

    @Column(name = "crew_capacity")
    private int crewCapacity;

    public Ship(String shipType, int fuelCapacity, int durability, int crewCapacity) {
        this.shipType = shipType;
        this.fuelCapacity = fuelCapacity;
        this.durability = durability;
        this.crewCapacity = crewCapacity;
    }
}
