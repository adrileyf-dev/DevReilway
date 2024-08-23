package dev.app.devreilway.Repository;

import dev.app.devreilway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
  boolean existsByAccountNumber(String accountNumber);
}
