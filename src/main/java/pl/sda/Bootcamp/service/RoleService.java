package pl.sda.Bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.Bootcamp.model.Role;
import pl.sda.Bootcamp.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }

}
