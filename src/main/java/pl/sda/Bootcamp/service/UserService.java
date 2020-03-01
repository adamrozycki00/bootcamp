package pl.sda.Bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.Bootcamp.model.User;
import pl.sda.Bootcamp.repository.RoleRepository;
import pl.sda.Bootcamp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAllStudents() {
        return userRepository.findAllByRole(roleRepository.findByRoleName("user"));
    }

    public List<User> findAllTrainers() {
        return userRepository.findAllByRole(roleRepository.findByRoleName("trainer"));
    }

    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
