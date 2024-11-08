package com.andres.curso.sppringboot.webap.springboot_web.controlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;



import com.andres.curso.sppringboot.webap.springboot_web.models.User;




@Controller
public class UserController {
    
    @GetMapping("/details")
    
    public String details(Model model){
        User user = new User("Andres", "Cid","ey@gmail.com");
        //user.setEmail("hola@gmail.com");
        model.addAttribute("title","Hola Mundo soy SpringBoot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){

        model.addAttribute("title","Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
        List<User> users = Arrays.asList(new User("Andres","Cid","andresin@gmail.com"),
        new User("Santiago","Hernandez", null),
        new User("Mireia","Sopena","msop@hotmail.com"));
        return users;
    }

}
