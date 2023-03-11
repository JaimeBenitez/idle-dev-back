package com.example.idleback.Controller;

import com.example.idleback.Repositorios.LenguajePartidaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LenguajePartidaController {

    private final LenguajePartidaRepositorio lenguajePartidaRepositorio;

}
