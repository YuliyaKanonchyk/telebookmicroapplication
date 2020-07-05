package by.micro.telebookuser.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsUserByLogin(String login);

    Optional<User> findUserByLogin(String login);

    Optional<User> findUserById(Long id);

    Optional<List<User>> findUsersByFirstName(String firstName);

    Optional<List<User>> findUsersByLastName(String lastName);

}
