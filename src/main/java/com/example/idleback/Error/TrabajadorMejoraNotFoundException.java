package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrabajadorMejoraNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 41111413666660211L;

    public TrabajadorMejoraNotFoundException(Long id){ super("No se puede encontrar la relación entre mejora y trabajador con la ID: " + id);}


}
