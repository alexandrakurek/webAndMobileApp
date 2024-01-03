package com.aleksandrakurek.webapp.user;

import com.aleksandrakurek.webapp.report.Report;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    private final UserRepository userRepository;
    @Autowired
    public AppController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String viewAfterLogin() {
        return "home";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user",new User());
        return "register";
    }
    @GetMapping("/createReport")
    public String viewAfterCreateReport(Model model) {
        model.addAttribute("report", new Report());
        return "createReport";
    }
    @GetMapping("/reports_sent")
    public String viewAfterSendReport() {
        return "message.css";
    }

}
