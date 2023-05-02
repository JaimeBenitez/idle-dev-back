package com.example.idleback.Controller;

import com.example.idleback.Dto.lenguaje.LenguajeDTO;
import com.example.idleback.Dto.converter.LenguajeDTOConverter;
import com.example.idleback.Dto.lenguaje.LogoLenguajeDTO;
import com.example.idleback.Error.LenguajeNotFoundException;
import com.example.idleback.Model.Lenguaje;
import com.example.idleback.Model.Mejora;
import com.example.idleback.Repositorios.LenguajeRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class LenguajeController {

    private final LenguajeRepositorio lenguajeRepositorio;

    private final LenguajeDTOConverter lenguajeDTOConverter;



    /**
     * Obtenemos todos los lenguajes
     *
     * @return lista de lenguajes
     */
    @GetMapping("/lenguajes")
    public ResponseEntity<List<?>> getAllLanguages(){
        List<Lenguaje> players = lenguajeRepositorio.findAll();
        if(players.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<LenguajeDTO> dtoList =
                    players.stream().map(lenguajeDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }
    /**
     * Obtenemos un lenguaje en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra el lenguaje
     */
    @GetMapping("lenguaje/{id}")
    public Lenguaje getLanguageById(@PathVariable Long id){

        return lenguajeRepositorio.findById(id)
                .orElseThrow(() -> new LenguajeNotFoundException(id));
    }

    /**
     * Obtenemos las mejoras de un lenguaje usando su ID
     *
     * @param id
     * @return Error 404 si no encuentra el lenguaje
     */
    @GetMapping("/lenguaje/{id}/mejoras")
    public List<Mejora> getLanguageUpgrades(@PathVariable Long id){
        Lenguaje lenguaje = lenguajeRepositorio.findById(id).orElseThrow(() -> new LenguajeNotFoundException(id));
        return lenguaje.getMejoras();
    }
    /**
     * Funcion unica y exclusivamente para meter los logos
     * @param id
     * return lenguaje actualizado o 404 si no se encuentra
     */
    @PutMapping("lenguaje/{id}")
    public Lenguaje putLanguageLogo(@RequestBody LogoLenguajeDTO logo , @PathVariable Long id){
            return lenguajeRepositorio.findById(id).map(l -> {
                l.setLogo("http://localhost:8080/languages/" + logo.getLogo() + ".svg");
                return lenguajeRepositorio.save(l);
            }).orElseThrow(()-> new LenguajeNotFoundException(id));
    }
}
