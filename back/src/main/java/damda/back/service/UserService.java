package damda.back.service;

import damda.back.entity.Users;
import damda.back.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(Users user) {
        userRepository.save(user);
    }

    public Optional<Users> get(String id) {
        return Optional.ofNullable(userRepository.get(id));
    }

    public void update(Users user) {
        userRepository.update(user);
    }

    public void delete(String id) {
        userRepository.delete(id);
    }
}
