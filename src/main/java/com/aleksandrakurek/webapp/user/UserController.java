package com.aleksandrakurek.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public String login(@RequestParam @NotBlank(message = "Nazwa użytkownika nie może być pusta") String username,
                        @RequestParam @NotBlank(message = "Hasło nie może być puste") String password) {
        boolean success = userService.loginUser(username, password);
        if (success) {
            return "Logowanie pomyślne";
        } else {
            return "Błędna nazwa użytkownika lub hasło";
        }
    }
    @PostMapping
    public String addUser (User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }



}













