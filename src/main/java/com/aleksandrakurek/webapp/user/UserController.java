package com.aleksandrakurek.webapp.user;

import com.aleksandrakurek.webapp.RegistrationDto;
import org.atmosphere.config.service.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    @PostMapping
    public String registerUser(@ModelAttribute @Valid RegistrationDto registrationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.registerNewUser(registrationDto);
        return "redirect:/login";
    }

}
    /*

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String username, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView("/register");

     User user = new User();
        user.setUsername(username);
        user.setPassword(password);


     User registrationSuccess = userService.registerNewUser(username,password);
        if (registrationSuccess != null) {
            modelAndView.setViewName("redirect:/login");


        } else {
            modelAndView.setViewName("register"); // powrót do formularza rejestracji
            modelAndView.addObject("error", "Nie udało się zarjestrować użytkownika");
        }
        return modelAndView;

    } */













