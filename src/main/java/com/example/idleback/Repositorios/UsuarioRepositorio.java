package com.example.idleback.Repositorios;


import com.example.idleback.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByNombre(String nombre);
}
