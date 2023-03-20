package com.example.idleback.Dto.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {

    private Long id;

    private Long partidaId;

    private String nombre;

    private String contrasenia;

    private String avatar;

}
