package com.andres.curso.sppringboot.webap.springboot_web.controlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.sppringboot.webap.springboot_web.models.User;
import com.andres.curso.sppringboot.webap.springboot_web.models.dto.UserDto; 




@RestController
@RequestMapping("/api")
public class UserRestontroller {
    
    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Andres", "Cid");
        userDto.setUser(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setTitle("Hola Mundo soy SpringBoot");

        /*Map<String,Object> body = new HashMap<>();
        body.put("title","");
        body.put("user",user);
        body.put("lastname", "Cid");*/
        return userDto;

    }
    
    @GetMapping("/list")
   
    public List<User> list(){
        User user1 = new User("Andres","Cid");
        User user2 = new User("Santiago","Hernandez");
        User user3 = new User("Mireia","Sopena");

        List<User> users = new ArrayList<>();
        User[] userArray = {user1, user2, user3};
        for (User user : userArray) {
            users.add(user);
        }
        return users;
    }

    @GetMapping("/map")
    public Map<String,Object> MapDetails(){
            
        User user = new User("Andres", "Cid");
        Map<String,Object> body = new HashMap<>();
        body.put("title","Hola Mundo soy SpringBoot");
        body.put("user",user);
        body.put("lastname", "Cid");
        return body;

    }

}
