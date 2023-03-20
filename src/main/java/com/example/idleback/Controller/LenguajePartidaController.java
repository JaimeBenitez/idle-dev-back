package com.example.idleback.Controller;

import com.example.idleback.Dto.converter.Lenguaje_partidaDTOConverter;
import com.example.idleback.Dto.lenguaje_partida.CrearLenguaje_partidaDTO;
import com.example.idleback.Dto.lenguaje_partida.Lenguaje_partidaDTO;
import com.example.idleback.Dto.lenguaje_partida.ModLenguaje_partidaDTO;
import com.example.idleback.Error.LenguajePartidaNotFoundException;
import com.example.idleback.Error.PartidaNotFoundException;
import com.example.idleback.Model.*;
import com.example.idleback.Repositorios.LenguajePartidaRepositorio;
import com.example.idleback.Repositorios.LenguajeRepositorio;
import com.example.idleback.Repositorios.PartidaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class LenguajePartidaController {

    private final LenguajePartidaRepositorio lenguajePartidaRepositorio;

    private final LenguajeRepositorio lenguajeRepositorio;

    private final PartidaRepositorio partidaRepositorio;

    private final Lenguaje_partidaDTOConverter lenguajePartidaDTOConverter;


    /**
     * Obtenemos una lista de todos los lenguajes en la partida actual
     *
     * @param id
     * @return Error 404 si no encuentra la partida
     */
    @GetMapping("partida/{id}/lenguajes")
    public ResponseEntity<List<?>> getLanguagesByAccount(@PathVariable Long id){
        List<Lenguaje_partida> lenguajesPorPartida = lenguajePartidaRepositorio.findAllByPartida_Id(id);

        if(lenguajesPorPartida.isEmpty()){
            throw new PartidaNotFoundException(id);
        }else {
            List<Lenguaje_partidaDTO> dtoList =
                    lenguajesPorPartida.stream().map(lenguajePartidaDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }


    /**
     * Creamos una nueva relacion partida-lenguaje
     *
     * @param nuevo
     * @return relacion insertada
     */
    @PostMapping("/lenguaje-partida")
    public ResponseEntity<?> newLanguageAccount(@RequestBody CrearLenguaje_partidaDTO nuevo){
        Lenguaje_partida nLenguaje_partida = new Lenguaje_partida();
        Partida partida = partidaRepositorio.findById(nuevo.getPartidaId()).orElse(null);
        Lenguaje lenguaje = lenguajeRepositorio.findById(nuevo.getLenguajeId()).orElse(null);
        nLenguaje_partida.setPartida(partida);
        nLenguaje_partida.setLenguaje(lenguaje);

        //En este caso ante una nueva creación, que sera normalmente al comenzar una partida nueva
        //el valor de desbloqueado comenzara en false por defecto y el de cantidad en 0

        return ResponseEntity.status(HttpStatus.CREATED).body(lenguajePartidaRepositorio.save(nLenguaje_partida));
    }

    /**
     * Actualizamos una relacion partida-lenguaje
     *
     * @param nuevo
     * @param id
     * @return relacion actualizada, 404 si no se encuentra la relacion
     */
    @PutMapping("/lenguaje-partida/{id}")
    public Lenguaje_partida updateLanguageAccount(@RequestBody ModLenguaje_partidaDTO nuevo, @PathVariable Long id) {
        //En principio en esta relación una vez creada por primera vez ya no es necesario tocar mas las id
        return lenguajePartidaRepositorio.findById(id).map(la -> {
            la.setDesbloqueado(nuevo.getDesbloqueado());
            la.setCantidad(nuevo.getCantidad());
            return lenguajePartidaRepositorio.save(la);
        }).orElseThrow(() -> new LenguajePartidaNotFoundException(id));
    }
}
