package com.example.idleback.Dto.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CrearUsuarioDTO {

    private Long partidaId;

    private String nombre;

    private String email;

    private String contrasenia;

    private String avatar;
}
