package com.example.idleback.Repositorios;


import com.example.idleback.Model.Lenguaje_partida;
import com.example.idleback.Model.Trabajador_mejora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LenguajePartidaRepositorio extends JpaRepository<Lenguaje_partida,Long> {

    List<Lenguaje_partida> findAllByPartida_Id(Long id);
}
