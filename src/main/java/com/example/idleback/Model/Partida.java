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
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float dinero = 0f;

    @OneToOne( mappedBy = "partida")
    private Usuario usuario;

    @JsonManagedReference
    @OneToMany(mappedBy = "partida")
    private List<Lenguaje_partida> lenguajes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "partida")
    private List<Trabajador> trabajadores = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "partida")
    private List<Empresa_partida> empresas = new ArrayList<>();

}
