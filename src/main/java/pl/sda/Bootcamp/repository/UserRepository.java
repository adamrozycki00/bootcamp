package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
