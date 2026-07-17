package io.github.tiagoboldori.eventhub.config;

import io.github.tiagoboldori.eventhub.entity.User;
import io.github.tiagoboldori.eventhub.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*
@Component
public class DatabaseTestRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseTestRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        User user = new User();

        user.setName("Tiago");
        user.setEmail("tiago@email.com");
        user.setPassword("123456");

        userRepository.save(user);

        System.out.println("Usuário salvo!");

    }

}
*/
