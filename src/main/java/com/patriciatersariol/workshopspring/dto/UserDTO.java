package com.patriciatersariol.workshopspring.dto;

import com.patriciatersariol.workshopspring.domain.User;

import javax.servlet.http.PushBuilder;
import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;

    public UserDTO(){

    }

    public UserDTO(User obj){
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
