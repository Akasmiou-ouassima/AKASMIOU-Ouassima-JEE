package ma.enset.UserRole.service;

import ma.enset.UserRole.entities.Role;
import ma.enset.UserRole.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String rolename);

}
