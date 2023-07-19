package dn.sass.cms.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = new User("dylan" + random, "admin@123");
        userRepository.save(user);
        return user;
    }

    public Optional<User> getByUserId(int id) {
        return userRepository.findById(id);
    }
}
