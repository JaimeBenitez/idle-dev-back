package com.example.idleback.Model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String nombre;
    private String contrasenia;

    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }

    public JwtRequest(String nombre, String contrasenia) {
        this.setNombre(nombre);
        this.setContrasenia(contrasenia);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
