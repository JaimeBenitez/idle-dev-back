package com.example.idleback.Repositorios;


import com.example.idleback.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    Usuario findByNombre(String nombre);
}
