package com.fivesysdev.vovchuk.maxim.bankSecurity.repositories;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
