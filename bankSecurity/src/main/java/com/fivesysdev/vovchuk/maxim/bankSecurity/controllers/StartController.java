package com.fivesysdev.vovchuk.maxim.bankSecurity.controllers;

import com.fivesysdev.vovchuk.maxim.bankSecurity.models.User;
import com.fivesysdev.vovchuk.maxim.bankSecurity.services.RegistrationService;
import com.fivesysdev.vovchuk.maxim.bankSecurity.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/startMenu")
public class StartController {
    private final RegistrationService registrationService;
    private final UserValidator userValidator;

    @Autowired
    public StartController(RegistrationService registrationService, UserValidator userValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    @GetMapping()
    public String startPage() {
        return "startMenu/startMenu";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "startMenu/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "redirect:/accountMenu/accountMenu";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "startMenu/register";
    }

    @PostMapping("/register")
    public String registerPage(@ModelAttribute("user") @Valid User user,
                               BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/startMenu/register";
        }
        registrationService.save(user);
        return "redirect:/startMenu/login";
    }
}
