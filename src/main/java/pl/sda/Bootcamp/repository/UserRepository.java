package pl.sda.Bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.Bootcamp.model.Role;
import pl.sda.Bootcamp.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByRole(Role role);

}
