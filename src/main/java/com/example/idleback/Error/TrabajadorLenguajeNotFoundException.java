package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrabajadorLenguajeNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 41111413373260211L;

    public TrabajadorLenguajeNotFoundException(Long id){ super("No se puede encontrar la relación entre lenguaje y trabajador con la ID: " + id);}


}
