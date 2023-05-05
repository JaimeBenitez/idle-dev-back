package com.example.idleback.Controller;

import com.example.idleback.Dto.mejora.LogoMejoraDTO;
import com.example.idleback.Dto.mejora.MejoraDTO;
import com.example.idleback.Dto.converter.MejoraDTOConverter;
import com.example.idleback.Error.MejoraNotFoundException;
import com.example.idleback.Model.Mejora;
import com.example.idleback.Repositorios.MejoraRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class MejoraController {

    private final MejoraRepositorio mejoraRepositorio;

    private final MejoraDTOConverter mejoraDTOConverter;


    /**
     * Obtenemos todas las mejoras
     *
     * @return lista de mejoras
     */
    @GetMapping("/mejoras")
    public ResponseEntity<List<?>> getAllUpgrades(){
        List<Mejora> improvements = mejoraRepositorio.findAll();
        if(improvements.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<MejoraDTO> dtoList =
                    improvements.stream().map(mejoraDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtenemos una mejora en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra la mejora
     */
    @GetMapping("mejora/{id}")
    public Mejora getUpgradeById(@PathVariable Long id){

        return mejoraRepositorio.findById(id)
                .orElseThrow(() -> new MejoraNotFoundException(id));
    }
    /**
     * Funcion unica y exclusivamente para meter los logos
     * @param id
     * return mejora actualizada o 404 si no se encuentra
     */
    @PutMapping("mejora/{id}")
    public Mejora putUpgradeLogo(@RequestBody LogoMejoraDTO logo , @PathVariable Long id){
        return mejoraRepositorio.findById(id).map(u -> {
            //Lo haremos de manera que lo unico que le pasamos es el nombre del logo
            u.setLogo("http://localhost:8080/upgrades/" + logo.getLogo() + ".svg");
            return mejoraRepositorio.save(u);
        }).orElseThrow(()-> new MejoraNotFoundException(id));
    }
}
