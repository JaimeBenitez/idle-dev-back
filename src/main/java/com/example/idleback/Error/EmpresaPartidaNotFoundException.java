package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpresaPartidaNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 41117563373260255L;

    public EmpresaPartidaNotFoundException(Long id){ super("No se puede encontrar la relación entre empresa y partida con la ID: " + id);}


}
