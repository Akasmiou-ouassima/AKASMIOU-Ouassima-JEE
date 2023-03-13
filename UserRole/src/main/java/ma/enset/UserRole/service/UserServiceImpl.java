package ma.enset.UserRole.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.UserRole.entities.Role;
import ma.enset.UserRole.entities.User;
import ma.enset.UserRole.repositories.RoleRepository;
import ma.enset.UserRole.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    //@Autowired
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

        return (User) userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName)
    {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
            User user=findUserByUserName(username);
            Role role=findRoleByRoleName(rolename);
            if (user.getRoles()!=null){
                user.getRoles().add(role);
                role.getUsers().add(user);
            }

            //userRepository.save(user);

    }

    @Override
    public User authenticate(String userName, String password) {
       User user= (User) userRepository.findByUserName(userName);
       if (user==null) throw new RuntimeException("Bad credentials");
       if(user.getPassword().equals(password)){
           return  user;
       }
        throw new RuntimeException("Bad credentials");
    }

}
