package dn.sass.cms.user;

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

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userService.getByUserId(userId);
    }

    @GetMapping("/users/random")
    public User randomUser() {
        return userService.saveRandom();
    }
}
