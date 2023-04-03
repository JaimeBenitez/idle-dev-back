package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNameNotFoundException extends RuntimeException {

    private static final  long serialVersionUID = 43876691117760211L;

    public UsuarioNameNotFoundException(String nombre){
        super("No se puede encontrar el usuario con el nombre: " + nombre);
    }


}
