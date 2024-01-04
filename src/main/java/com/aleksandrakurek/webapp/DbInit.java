package com.aleksandrakurek.webapp;
import com.aleksandrakurek.webapp.user.User;
import com.aleksandrakurek.webapp.user.UserController;
import com.aleksandrakurek.webapp.user.UserRepository;
import com.aleksandrakurek.webapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
@Configuration
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserController userController;

    @Autowired
    public DbInit(UserRepository userRepository, UserService userService, UserController userController) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        // Tworzenie przykładowego użytkownika i zapis do bazy danych
      //  userService.saveUser(new User("user", "12145875"));



    }
}
