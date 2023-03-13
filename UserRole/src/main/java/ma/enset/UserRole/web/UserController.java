package ma.enset.UserRole.web;

import ma.enset.UserRole.entities.User;
import ma.enset.UserRole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user=userService.findUserByUserName(username);
        return user;

    }
}
