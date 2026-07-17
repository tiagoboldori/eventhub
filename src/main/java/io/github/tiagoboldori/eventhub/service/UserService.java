package io.github.tiagoboldori.eventhub.service;

import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }
}