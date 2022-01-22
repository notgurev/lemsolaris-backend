package lemsolaris.repositories;

import lemsolaris.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {
    public User findUserByLoginAndPassword(String login, String password);
}
