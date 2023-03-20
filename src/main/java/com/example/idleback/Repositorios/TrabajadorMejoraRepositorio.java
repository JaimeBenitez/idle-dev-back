package com.example.idleback.Repositorios;



import com.example.idleback.Model.Trabajador_mejora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorMejoraRepositorio extends JpaRepository<Trabajador_mejora,Long> {

    List<Trabajador_mejora> findAllByMejora_Id(Long id);

    List<Trabajador_mejora> findAllByTrabajador_Id(Long id);
}
