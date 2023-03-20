package com.example.idleback.Repositorios;


import com.example.idleback.Model.Trabajador_lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorLenguajeRepositorio extends JpaRepository<Trabajador_lenguaje,Long> {


    List<Trabajador_lenguaje> findAllByLenguaje_Id(Long id);

    List<Trabajador_lenguaje> findAllByTrabajador_Id(Long id);
}
