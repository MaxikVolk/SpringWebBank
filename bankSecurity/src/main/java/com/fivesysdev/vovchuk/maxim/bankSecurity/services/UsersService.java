package com.fivesysdev.vovchuk.maxim.bankSecurity.services;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.User;
import com.fivesysdev.vovchuk.maxim.bankSecurity.repositories.UsersRepository;
import com.fivesysdev.vovchuk.maxim.bankSecurity.security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findUserByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new MyUserDetails(user.get());
    }

}

