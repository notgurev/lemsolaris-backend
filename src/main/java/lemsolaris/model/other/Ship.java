package lemsolaris.model.other;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ship")
@Getter
@Setter
public class Ship {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ship_type")
    private String shipType;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "durability")
    private int durability;

    @Column(name = "crew_capacity")
    private int crewCapacity;
}
