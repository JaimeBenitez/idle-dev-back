package com.example.idleback.Dto.trabajador;

import com.example.idleback.Enum.Nivel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TrabajadorDTO {

    private Long id;

    private String nombre;

    private String empresaNombre;

    private Long partidaId;

    private Float generacion_pa;

    private Character sexo;
}
