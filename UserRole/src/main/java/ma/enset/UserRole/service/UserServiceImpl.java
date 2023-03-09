package ma.enset.UserRole.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.UserRole.entities.Role;
import ma.enset.UserRole.entities.User;
import ma.enset.UserRole.repositories.RoleRepository;
import ma.enset.UserRole.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return null;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String rolename) {

    }
}
