package io.github.tiagoboldori.eventhub.repository;

import io.github.tiagoboldori.eventhub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}
