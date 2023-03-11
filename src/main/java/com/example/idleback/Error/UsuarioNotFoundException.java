package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {

    private static final  long serialVersionUID = 43876691117760211L;

    public UsuarioNotFoundException (Long id){
        super("No se puede encontrar el usuario con la ID: " + id);
    }


}
