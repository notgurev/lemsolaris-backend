package lemsolaris.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    private String login;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
}
