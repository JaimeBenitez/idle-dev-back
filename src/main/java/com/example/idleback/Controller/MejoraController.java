package com.example.idleback.Controller;

import com.example.idleback.Repositorios.MejoraRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MejoraController {

    private final MejoraRepositorio mejoraRepositorio;



}
