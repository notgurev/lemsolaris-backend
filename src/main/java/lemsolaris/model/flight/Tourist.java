package lemsolaris.model.flight;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tourist")
public class Tourist {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tourist_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;
}
