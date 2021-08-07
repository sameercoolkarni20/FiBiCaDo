package com.pets.fibicado.petadoption.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogoutRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150706L;

    private String username;
    private String jwtToken;

    public LogoutRequest(){

    }

    public LogoutRequest(String username, String jwtToken) {
        this.username = username;
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
