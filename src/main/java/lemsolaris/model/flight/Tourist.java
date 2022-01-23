package lemsolaris.model.flight;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tourist")
@NoArgsConstructor
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

    public Tourist(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
