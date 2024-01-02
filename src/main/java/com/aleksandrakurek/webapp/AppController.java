package com.aleksandrakurek.webapp;

import com.aleksandrakurek.webapp.report.Report;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AppController {

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
    public String viewRegisterPage() {
        return "register";
    }
    @GetMapping("/register/login")
    public String viewAfterRegister() {
        return "login";
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
