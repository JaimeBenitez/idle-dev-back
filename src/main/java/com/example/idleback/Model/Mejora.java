package com.example.idleback.Model;

import com.example.idleback.Enum.Nivel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Mejora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_lenguaje")
    private Lenguaje lenguaje;

    private String nombre;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name="nivel_desbloqueo")
    private Nivel  nivel_desbloqueo;

    private Boolean mejora_generacion;

    private Boolean descuento_compra;

    private Boolean extra_pa;

    private String logo;

    @JsonManagedReference
    @OneToMany(mappedBy = "mejora")
    private List<Trabajador_mejora> trabajadores;

}
