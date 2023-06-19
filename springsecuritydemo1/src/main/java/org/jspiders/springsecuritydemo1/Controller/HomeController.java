package org.jspiders.springsecuritydemo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public  String getHomePage(){
        return "home";
    }

    @GetMapping("/requirements")
    public  String getRequirementPage(){
        return "requirement";
    }
    @GetMapping("/admin")
    public  String getAdmin(){
        return "admin";
    }

}
