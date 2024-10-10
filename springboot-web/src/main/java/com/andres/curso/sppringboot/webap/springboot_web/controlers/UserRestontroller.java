package com.andres.curso.sppringboot.webap.springboot_web.controlers;

import java.util.HashMap;
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

public Map<String,Object> MapDetails(){
        
    User user = new User("Andres", "Cid");
    Map<String,Object> body = new HashMap<>();
    body.put("title","Hola Mundo soy SpringBoot");
    body.put("user",user);
    body.put("lastname", "Cid");
    return body;

}

}
