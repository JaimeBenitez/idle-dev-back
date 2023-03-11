package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MejoraNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 43876693338860211L;

    public MejoraNotFoundException(Long id){ super("No se puede encontrar la mejora con la ID: " + id);}


}
