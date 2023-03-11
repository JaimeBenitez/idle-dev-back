package com.example.idleback.Controller;

import com.example.idleback.Repositorios.EmpresaPartidaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmpresaPartidaController {

    private final EmpresaPartidaRepositorio empresaPartidaRepositorio;
}
