package com.example.idleback.Controller;

import com.example.idleback.Repositorios.EmpresaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaRepositorio empresaController;
}
