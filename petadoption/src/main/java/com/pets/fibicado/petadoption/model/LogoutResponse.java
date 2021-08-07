package com.pets.fibicado.petadoption.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogoutResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String message;

    public LogoutResponse(String message) {
        this.message = message;
    }


}
