package com.example.idleback.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lenguaje_partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_lenguaje")
    private Lenguaje lenguaje;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_partida")
    private Partida partida;

    private Boolean desbloqueado;

    private Long cantidad;
    
    private Float coste_actual;

}
