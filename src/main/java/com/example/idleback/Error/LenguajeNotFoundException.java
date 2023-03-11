package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LenguajeNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 43876693337760211L;

    public LenguajeNotFoundException(Long id){ super("No se puede encontrar el lenguaje con la ID: " + id);}

}
