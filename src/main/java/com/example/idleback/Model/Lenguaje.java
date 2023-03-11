package com.example.idleback.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private Long beneficio_base;

    private Float ratio_incremento;

    private Long dinero_desbloqueo;

    private String mensaje;

    private String logo;

    @JsonManagedReference
    @OneToMany(mappedBy = "lenguaje")
    private List<Lenguaje_partida> partidas = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "lenguaje")
    private List<Lenguaje_partida> mejoras = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "lenguaje")
    private List<Trabajador_lenguaje> trabajadores = new ArrayList<>();
}
