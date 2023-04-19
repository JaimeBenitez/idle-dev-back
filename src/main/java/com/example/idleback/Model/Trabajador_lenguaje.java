package com.example.idleback.Model;

import com.example.idleback.Enum.Nivel;
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
public class Trabajador_lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_trabajador")
    private Trabajador trabajador;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_lenguaje")
    private Lenguaje lenguaje;

    @Enumerated(EnumType.STRING)
    @Column(name="nivel")
    private Nivel nivel;

    private Float experiencia_lenguaje = 0f;
}
