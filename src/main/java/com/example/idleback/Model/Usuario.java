package com.example.idleback.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder @Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @OneToOne
    @JoinColumn(name = "id_partida", referencedColumnName = "id")
    private Partida partida;

    private String nombre;

    private String contrasenia;

    private String avatar;
}
