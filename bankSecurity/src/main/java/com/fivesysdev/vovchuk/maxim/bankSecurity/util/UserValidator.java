package com.fivesysdev.vovchuk.maxim.bankSecurity.util;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.User;
import com.fivesysdev.vovchuk.maxim.bankSecurity.services.UsersService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UsersService usersService;

    public UserValidator(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            usersService.loadUserByUsername(user.getEmail());
        } catch (UsernameNotFoundException e) {
            return;
        }
        errors.rejectValue("email", "", "Человек с такой почтой уже существует");
    }
}
