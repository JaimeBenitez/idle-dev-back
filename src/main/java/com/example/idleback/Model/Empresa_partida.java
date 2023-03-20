package com.example.idleback.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Empresa_partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_partida")
    private Partida partida;

    private Long nivel_actual = 0L;

    private Boolean desbloqueada = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "empresa")
    private List<Trabajador> trabajadores = new ArrayList<>();
}
