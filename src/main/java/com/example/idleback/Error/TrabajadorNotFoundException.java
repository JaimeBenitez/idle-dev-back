package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrabajadorNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 43881413338860211L;

    public TrabajadorNotFoundException(Long id){ super("No se puede encontrar el trabajador con la ID: " + id);}


}
