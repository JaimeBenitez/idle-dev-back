package com.example.idleback.Controller;


import com.example.idleback.Dto.trabajador.CrearTrabajadorDTO;
import com.example.idleback.Dto.trabajador.ModTrabajadorDTO;
import com.example.idleback.Dto.trabajador.TrabajadorDTO;
import com.example.idleback.Dto.converter.TrabajadorDTOConverter;
import com.example.idleback.Error.TrabajadorNotFoundException;
import com.example.idleback.Model.*;
import com.example.idleback.Repositorios.EmpresaPartidaRepositorio;
import com.example.idleback.Repositorios.PartidaRepositorio;
import com.example.idleback.Repositorios.TrabajadorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TrabajadorController {

    private final TrabajadorRepositorio trabajadorRepositorio;

    private final TrabajadorDTOConverter trabajadorDTOConverter;

    private final PartidaRepositorio partidaRepositorio;

    private final EmpresaPartidaRepositorio empresaPartidaRepositorio;


    /**
     * Obtenemos todos los trabajadores
     *
     * @return lista de trabajadores
     */
    @GetMapping("/trabajadores")
    public ResponseEntity<List<?>> getAllWorkers(){
        List<Trabajador> workers = trabajadorRepositorio.findAll();
        if(workers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<TrabajadorDTO> dtoList =
                    workers.stream().map(trabajadorDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    /**
     * Obtenemos un trabajador en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra el trabajador
     */
    @GetMapping("trabajador/{id}")
    public Trabajador getWorkerById(@PathVariable Long id){

        return trabajadorRepositorio.findById(id)
                .orElseThrow(() -> new TrabajadorNotFoundException(id));
    }

    /**
     * Creamos un nuevo trabajador
     *
     * @param nuevo
     * @return trabajador insertado
     */
    @PostMapping("/trabajador")
    public ResponseEntity<?> newWorker(@RequestBody CrearTrabajadorDTO nuevo){
        Trabajador nTrabajador = new Trabajador();
        Partida partida = partidaRepositorio.findById(nuevo.getPartidaId()).orElse(null);
        nTrabajador.setPartida(partida);
        nTrabajador.setNombre(nuevo.getNombre());
        nTrabajador.setGeneracion_pa(nuevo.getGeneracion_pa());

        return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorRepositorio.save(nTrabajador));
    }

    /**
     * Actualizamos un trabajador
     *
     * @param nuevo
     * @param id
     * @return trabajador actualizado, 404 si no se encuentra el usuario
     */
    @PutMapping("/trabajador/{id}")
    public Trabajador updateWorker(@RequestBody ModTrabajadorDTO nuevo, @PathVariable Long id) {
        final Empresa_partida nEmpresa = empresaPartidaRepositorio.findById(nuevo.getEmpresaId()).orElse(null);

        return trabajadorRepositorio.findById(id).map(w -> {
            w.setNombre(nuevo.getNombre());
            w.setEmpresa(nEmpresa);
            w.setGeneracion_pa(nuevo.getGeneracion_pa());
            return trabajadorRepositorio.save(w);
        }).orElseThrow(() -> new TrabajadorNotFoundException(id));
    }
}
