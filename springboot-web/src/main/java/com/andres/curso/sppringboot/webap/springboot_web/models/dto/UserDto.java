package com.andres.curso.sppringboot.webap.springboot_web.models.dto;

import com.andres.curso.sppringboot.webap.springboot_web.models.User;

public class UserDto {
    private String title;
    private String user;
    private String lastname;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
   
    
    

}
