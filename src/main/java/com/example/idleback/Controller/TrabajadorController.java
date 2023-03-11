package com.example.idleback.Controller;

import com.example.idleback.Repositorios.TrabajadorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TrabajadorController {

    private final TrabajadorRepositorio trabajadorRepositorio;
}
