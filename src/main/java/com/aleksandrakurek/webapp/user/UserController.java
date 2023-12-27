package com.aleksandrakurek.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping({"/user"})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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

    //Metoda wyświetla formularz rejestracji, dodając do modelu nowy obiekt User.
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    //Metoda obsługuje przesłane dane formularza rejestracji. Dane są automatycznie mapowane na obiekt User.

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean registrationSuccess = userService.registerNewUser(user);
        if (registrationSuccess) {
            userService.saveUser(user);
            return new ModelAndView("redirect:/login");
        } else {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("registrationError", "Nazwa użytkownika jest zajęta");
            return modelAndView;
        }


    }
}










