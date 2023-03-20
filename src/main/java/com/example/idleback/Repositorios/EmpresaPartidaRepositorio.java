package com.example.idleback.Repositorios;


import com.example.idleback.Model.Empresa_partida;
import com.example.idleback.Model.Lenguaje_partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaPartidaRepositorio extends JpaRepository<Empresa_partida,Long> {

    List<Empresa_partida> findAllByPartida_Id(Long id);
}
