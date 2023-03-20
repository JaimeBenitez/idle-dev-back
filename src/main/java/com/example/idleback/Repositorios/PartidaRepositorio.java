package com.example.idleback.Repositorios;


import com.example.idleback.Model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepositorio extends JpaRepository<Partida,Long> {

    List<Partida> findByOrderByDineroDesc();
}
