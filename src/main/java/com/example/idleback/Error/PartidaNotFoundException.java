package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PartidaNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 43889096568860211L;

    public PartidaNotFoundException(Long id){ super("No se puede encontrar la partida con la ID: " + id);}


}
