package com.andres.curso.sppringboot.webap.springboot_web.controlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.sppringboot.webap.springboot_web.models.User;
import com.andres.curso.sppringboot.webap.springboot_web.models.dto.ParamDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    //Inyección de valores
    @Value("${config.code}")
    private Integer code;
    
    @Value("#{${config.valuesmap}}")
    private Map<String,Object> valuesMap;
    
    @Autowired 
    private Environment environment;
    
    @GetMapping("/baz/{message}/{code}")
    public ParamDto baz(@PathVariable() String message, @PathVariable() int code ){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        paramDto.setCode(code);
        return paramDto;
    }
    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVar(@PathVariable String product, @PathVariable String id){
        Map<String, Object> json = new HashMap<>();
        json.put("product",product);
        json.put("id",id);
        return json;

    }
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.username}") String username){
        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("valuesmap",valuesMap);
        json.put("code2", (environment.getProperty("config.code2",Long.class)));
        return json;
    }
    



}
