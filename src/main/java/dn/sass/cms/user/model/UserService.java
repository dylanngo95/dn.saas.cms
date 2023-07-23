package dn.sass.cms.user.model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User saveRandom() {
        int random = (int) (Math.random() * 100);
        User user = new User("dylan" + random, "admin@123", "admin@123");

        Role role = new Role();
        role.setName("ADMIN");

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);
        return user;
    }

    public Optional<User> getByUserId(int id) {
        return userRepository.findById(id);
    }
}
