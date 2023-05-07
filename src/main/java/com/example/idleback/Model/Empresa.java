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
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Float multiplica_ganancia;

    private Long ranuras_base;

    private String requerimiento_valores;

    private String requerimiento_lenguajes;

    @JsonManagedReference
    @OneToMany(mappedBy = "empresa")
    private List<Empresa_partida> partidas = new ArrayList<>();


}
