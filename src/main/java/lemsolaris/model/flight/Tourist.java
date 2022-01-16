package lemsolaris.model.flight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tourist")
public class Tourist {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;
}
