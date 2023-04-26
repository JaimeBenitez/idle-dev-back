package com.example.idleback.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Trabajador implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa_partida empresa;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_partida")
    private Partida partida;

    private String nombre;

    private Float generacion_pa;

    private Character sexo;

    private String imagen;

    @JsonManagedReference
    @OneToMany(mappedBy = "trabajador")
    private List<Trabajador_mejora> mejoras;

    @JsonManagedReference
    @OneToMany(mappedBy = "trabajador")
    private List<Trabajador_lenguaje> lenguajes = new ArrayList<>();

}
