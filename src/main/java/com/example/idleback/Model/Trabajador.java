package com.example.idleback.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Trabajador implements Serializable {

    private static final Long serialVersionUID = 1L;

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

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Mejora mejoras;

    private Long generacion_pa;

    @JsonManagedReference
    @OneToMany(mappedBy = "trabajador")
    private List<Trabajador_lenguaje> lenguajes = new ArrayList<>();

}
