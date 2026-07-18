package io.github.tiagoboldori.eventhub.service;

import io.github.tiagoboldori.eventhub.dto.request.RegisterUserRequest;
import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.repository.UserRepository;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterUserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    public boolean emailAlreadyExists(String email){
        return userRepository.existsByEmail(email);
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Usuário não encontrado"));
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }
}