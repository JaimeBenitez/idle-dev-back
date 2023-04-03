package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioIdNotFoundException extends RuntimeException {

    private static final  long serialVersionUID = 43876691128860211L;

    public UsuarioIdNotFoundException(Long id){
        super("No se puede encontrar el usuario con el id: " + id);
    }


}
