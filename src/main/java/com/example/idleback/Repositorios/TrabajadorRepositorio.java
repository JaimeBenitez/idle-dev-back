package com.example.idleback.Repositorios;


import com.example.idleback.Model.Partida;
import com.example.idleback.Model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorRepositorio extends JpaRepository<Trabajador,Long> {

    List<Trabajador> findByPartida(Partida partida);
}
