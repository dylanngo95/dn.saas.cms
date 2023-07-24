package dn.sass.cms.user.service;

import dn.sass.cms.user.dto.UserDto;
import dn.sass.cms.user.model.Role;
import dn.sass.cms.user.model.User;
import dn.sass.cms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    /**
     * Save User
     * @param userDto UserDto
     */
    public void saveUser(UserDto userDto) {

        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword())
        );
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
