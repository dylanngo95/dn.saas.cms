package dn.sass.cms.user.controller;

import dn.sass.cms.user.service.UserService;
import dn.sass.cms.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userService.getByUserId(userId);
    }

    @GetMapping("/users/random")
    public User randomUser() {
        return userService.saveRandom();
    }
}
