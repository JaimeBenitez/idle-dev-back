package com.example.idleback.Controller;

import com.example.idleback.Dto.mejora.MejoraDTO;
import com.example.idleback.Dto.converter.MejoraDTOConverter;
import com.example.idleback.Error.MejoraNotFoundException;
import com.example.idleback.Model.Mejora;
import com.example.idleback.Repositorios.MejoraRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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
}
