package com.example.idleback.Controller;

import com.example.idleback.Dto.converter.Lenguaje_partidaDTOConverter;
import com.example.idleback.Dto.converter.Trabajador_lenguajeDTOConverter;
import com.example.idleback.Dto.lenguaje_partida.Lenguaje_partidaDTO;
import com.example.idleback.Dto.trabajador_lenguaje.CrearTrabajador_lenguajeDTO;
import com.example.idleback.Dto.trabajador_lenguaje.Trabajador_lenguajeDTO;
import com.example.idleback.Dto.usuario.CrearUsuarioDTO;
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
public class TrabajadorLenguajeController {

    private final TrabajadorLenguajeRepositorio trabajadorLenguajeRepositorio;

    private final LenguajeRepositorio lenguajeRepositorio;

    private final TrabajadorRepositorio trabajadorRepositorio;

    private final Trabajador_lenguajeDTOConverter trabajadorLenguajeDTOConverter;


    /**
     * Obtenemos una lista de todos los lenguajes con un trabajador concreto
     *
     * @param id
     * @return Error 404 si no encuentra el trabajador
     */
    @GetMapping("trabajador/{id}/lenguajes")
    public ResponseEntity<List<?>> getLanguagesByWorker(@PathVariable Long id){
        List<Trabajador_lenguaje> trabajadoresPorLenguaje = trabajadorLenguajeRepositorio.findAllByLenguaje_Id(id);

        if(trabajadoresPorLenguaje.isEmpty()){
            throw new LenguajeNotFoundException(id);
        }else {
            List<Trabajador_lenguajeDTO> dtoList =
                    trabajadoresPorLenguaje.stream().map(trabajadorLenguajeDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtenemos una lista de todos los trabajadores con un lenguaje concreto
     *
     * @param id
     * @return Error 404 si no encuentra el trabajador
     */
    @GetMapping("lenguaje/{id}/trabajadores")
    public ResponseEntity<List<?>> getWorkersByLanguage(@PathVariable Long id){
        List<Trabajador_lenguaje> lenguajesPorTrabajador = trabajadorLenguajeRepositorio.findAllByTrabajador_Id(id);

        if(lenguajesPorTrabajador.isEmpty()){
            throw new TrabajadorNotFoundException(id);
        }else {
            List<Trabajador_lenguajeDTO> dtoList =
                    lenguajesPorTrabajador.stream().map(trabajadorLenguajeDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }
    /**
     * Creamos una nueva relacion trabajador-lenguaje
     *
     * @param nuevo
     * @return relacion insertada
     */
    @PostMapping("/trabajador-lenguaje")
    public ResponseEntity<?> newWorkerLanguage(@RequestBody CrearTrabajador_lenguajeDTO nuevo){
        Trabajador_lenguaje nTrabajador_lenguaje = new Trabajador_lenguaje();
        Trabajador trabajador = trabajadorRepositorio.findById(nuevo.getId_trabajador()).orElse(null);
        Lenguaje lenguaje = lenguajeRepositorio.findById(nuevo.getId_lenguaje()).orElse(null);
        nTrabajador_lenguaje.setTrabajador(trabajador);
        nTrabajador_lenguaje.setLenguaje(lenguaje);
        nTrabajador_lenguaje.setNivel(Nivel.valueOf(nuevo.getNivel()));
        nTrabajador_lenguaje.setExperiencia_lenguaje(nuevo.getExperiencia_lenguaje());

        return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorLenguajeRepositorio.save(nTrabajador_lenguaje));
    }

    /**
     * Actualizamos una relacion trabajador-lenguaje
     *
     * @param nuevo
     * @param id
     * @return relacion actualizada, 404 si no se encuentra la relacion
     */
    @PutMapping("/trabajador-lenguaje/{id}")
    public Trabajador_lenguaje updateWorkerLanguage(@RequestBody CrearTrabajador_lenguajeDTO nuevo, @PathVariable Long id) {
        final Trabajador trabajador = trabajadorRepositorio.findById(nuevo.getId_trabajador()).orElse(null);
        final Lenguaje lenguaje = lenguajeRepositorio.findById(nuevo.getId_lenguaje()).orElse(null);

        return trabajadorLenguajeRepositorio.findById(id).map(wl -> {
            wl.setTrabajador(trabajador);
            wl.setLenguaje(lenguaje);
            wl.setNivel(Nivel.valueOf(nuevo.getNivel()));
            wl.setExperiencia_lenguaje(nuevo.getExperiencia_lenguaje());
            return trabajadorLenguajeRepositorio.save(wl);
        }).orElseThrow(() -> new TrabajadorLenguajeNotFoundException(id));
    }


}
