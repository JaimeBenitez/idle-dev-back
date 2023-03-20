package com.example.idleback.Controller;

import com.example.idleback.Dto.converter.Trabajador_lenguajeDTOConverter;
import com.example.idleback.Dto.converter.Trabajador_mejoraDTOConverter;
import com.example.idleback.Dto.trabajador_lenguaje.CrearTrabajador_lenguajeDTO;
import com.example.idleback.Dto.trabajador_lenguaje.Trabajador_lenguajeDTO;
import com.example.idleback.Dto.trabajador_mejora.CrearTrabajador_mejoraDTO;
import com.example.idleback.Dto.trabajador_mejora.Trabajador_mejoraDTO;
import com.example.idleback.Enum.Nivel;
import com.example.idleback.Error.*;
import com.example.idleback.Model.*;
import com.example.idleback.Repositorios.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TrabajadorMejoraController {

    private final TrabajadorMejoraRepositorio trabajadorMejoraRepositorio;

    private final MejoraRepositorio mejoraRepositorio;

    private final TrabajadorRepositorio trabajadorRepositorio;

    private final Trabajador_mejoraDTOConverter trabajadorMejoraDTOConverter;


    /**
     * Obtenemos una lista de todas las mejoras con un trabajador concreto
     *
     * @param id
     * @return Error 404 si no encuentra el trabajador
     */
    @GetMapping("trabajador/{id}/mejoras")
    public ResponseEntity<List<?>> getUpgradesByWorker(@PathVariable Long id){
        List<Trabajador_mejora> mejorasPorTrabajador = trabajadorMejoraRepositorio.findAllByTrabajador_Id(id);

        if(mejorasPorTrabajador.isEmpty()){
            throw new TrabajadorNotFoundException(id);
        }else {
            List<Trabajador_mejoraDTO> dtoList =
                    mejorasPorTrabajador.stream().map(trabajadorMejoraDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtenemos una lista de todos los trabajadores con una mejora  concreta
     *
     * @param id
     * @return Error 404 si no encuentra la mejora
     */
    @GetMapping("mejora/{id}/trabajadores")
    public ResponseEntity<List<?>> getWorkersByUpgrade(@PathVariable Long id){
        List<Trabajador_mejora> trabajadoresPorMejora = trabajadorMejoraRepositorio.findAllByMejora_Id(id);

        if(trabajadoresPorMejora.isEmpty()){
            throw new MejoraNotFoundException(id);
        }else {
            List<Trabajador_mejoraDTO> dtoList =
                    trabajadoresPorMejora.stream().map(trabajadorMejoraDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }
    /**
     * Creamos una nueva relacion trabajador-mejora
     *
     * @param nuevo
     * @return relacion insertada
     */
    @PostMapping("/trabajador-mejora")
    public ResponseEntity<?> newWorkerUpgrade(@RequestBody CrearTrabajador_mejoraDTO nuevo){
        Trabajador_mejora nTrabajador_mejora = new Trabajador_mejora();
        Trabajador trabajador = trabajadorRepositorio.findById(nuevo.getId_trabajador()).orElse(null);
        Mejora mejora = mejoraRepositorio.findById(nuevo.getId_mejora()).orElse(null);
        nTrabajador_mejora.setTrabajador(trabajador);
        nTrabajador_mejora.setMejora(mejora);


        return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorMejoraRepositorio.save(nTrabajador_mejora));
    }

    /**
     * Actualizamos una relacion trabajador-mejora
     *
     * @param nuevo
     * @param id
     * @return relacion actualizada, 404 si no se encuentra la relacion
     */
    @PutMapping("/trabajador-mejora/{id}")
    public Trabajador_mejora updateWorkerUpgrade(@RequestBody CrearTrabajador_mejoraDTO nuevo, @PathVariable Long id) {
        final Trabajador trabajador = trabajadorRepositorio.findById(nuevo.getId_trabajador()).orElse(null);
        final Mejora mejora = mejoraRepositorio.findById(nuevo.getId_mejora()).orElse(null);

        return trabajadorMejoraRepositorio.findById(id).map(wu -> {
            wu.setTrabajador(trabajador);
            wu.setMejora(mejora);
            return trabajadorMejoraRepositorio.save(wu);
        }).orElseThrow(() -> new TrabajadorMejoraNotFoundException(id));
    }


}
