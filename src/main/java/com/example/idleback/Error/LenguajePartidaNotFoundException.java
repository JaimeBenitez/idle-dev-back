package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LenguajePartidaNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 41111413373260255L;

    public LenguajePartidaNotFoundException(Long id){ super("No se puede encontrar la relación entre lenguaje y partida con la ID: " + id);}


}
