package com.example.idleback.Dto.lenguaje;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LenguajeDTO {

    private Long id;

    private String nombre;

    private Float beneficio_base;

    private Float ratio_incremento;

    private Float dinero_desbloqueo;

    private String mensaje;

    private String logo;

}
