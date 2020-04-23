package com.evack.els.model;

import org.springframework.stereotype.Component;



@Component
public class User {
   
    private Integer id;

    private String username;
    
    private String password;
    
    private Integer userlevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setName(String name) {
        this.username = name == null ? null : name.trim();
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public Integer getUserLevel() {
    	return userlevel;
    }
    
    public void setUserLevel(Integer userlevel) {
    	this.userlevel = userlevel;
    }
}