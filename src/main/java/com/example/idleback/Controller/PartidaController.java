package com.example.idleback.Controller;

import com.example.idleback.Dto.converter.PartidaDTOConverter;
import com.example.idleback.Dto.partida.ModPartidaDTO;
import com.example.idleback.Dto.partida.PartidaDTO;
import com.example.idleback.Error.PartidaNotFoundException;
import com.example.idleback.Model.*;
import com.example.idleback.Repositorios.PartidaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PartidaController {

    private final PartidaRepositorio partidaRepositorio;

    private final PartidaDTOConverter partidaDTOConverter;


    /**
     * Obtenemos la clasificacion de las partidas segun su dinero
     *
     *
     * @return la lista de partidas
     */
    @GetMapping("/clasificacion")
    public ResponseEntity<List<?>> getLeaderBoard(){
        List<Partida> partidas = partidaRepositorio.findByOrderByDineroDesc();

        if(partidas.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            List<PartidaDTO> dtoList =
                    partidas.stream().map(partidaDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }

    }

    /**
     * Obtenemos una empresa en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra la empresa
     */
    @GetMapping("partida/{id}")
    public Partida getAccountById(@PathVariable Long id){

        return partidaRepositorio.findById(id)
                .orElseThrow(() -> new PartidaNotFoundException(id));
    }

    /**
     * Creamos una nueva partida
     *
     * @return partida insertada
     */
    @PostMapping("/partida")
    public ResponseEntity<?> newAccount(){
        Partida nPartida = new Partida();
        //En el caso de las partidas, cuando se crea una nueva se inicializa con todos los valores por defecto
        return ResponseEntity.status(HttpStatus.CREATED).body(partidaRepositorio.save(nPartida));
    }

    /**
     * Actualizamos una partida
     *
     * @param nuevo
     * @param id
     * @return partida actualizada, 404 si no se encuentra la partida
     */
    @PutMapping("/partida/{id}")
    public Partida updateUser(@RequestBody ModPartidaDTO nuevo, @PathVariable Long id) {

        return partidaRepositorio.findById(id).map(a -> {
            a.setDinero(nuevo.getDinero());
            return partidaRepositorio.save(a);
        }).orElseThrow(() -> new PartidaNotFoundException(id));
    }



}
