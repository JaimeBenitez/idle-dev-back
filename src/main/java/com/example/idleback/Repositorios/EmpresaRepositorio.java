package com.example.idleback.Repositorios;

import com.example.idleback.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa,Long> {
}
