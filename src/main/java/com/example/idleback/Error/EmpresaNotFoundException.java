package com.example.idleback.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpresaNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 43889093338860211L;

    public EmpresaNotFoundException(Long id){ super("No se puede encontrar la empresa con la ID: " + id);}


}
