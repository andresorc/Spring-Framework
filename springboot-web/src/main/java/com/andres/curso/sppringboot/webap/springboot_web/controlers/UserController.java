package com.andres.curso.sppringboot.webap.springboot_web.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andres.curso.sppringboot.webap.springboot_web.models.User;




@Controller
public class UserController {
    
    @GetMapping("/details")
    
    public String details(Model model){
        User user = new User("Andres", "Cid");
        model.addAttribute("title","Hola Mundo soy SpringBoot");
        model.addAttribute("user", user);
        return "details";
    }

}
