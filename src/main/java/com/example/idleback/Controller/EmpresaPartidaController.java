package com.example.idleback.Controller;

import com.example.idleback.Dto.converter.Empresa_partidaDTOConverter;
import com.example.idleback.Dto.empresa_partida.CrearEmpresa_partidaDTO;
import com.example.idleback.Dto.empresa_partida.Empresa_partidaDTO;
import com.example.idleback.Dto.empresa_partida.ModEmpresa_partidaDTO;
import com.example.idleback.Error.EmpresaPartidaNotFoundException;
import com.example.idleback.Error.PartidaNotFoundException;
import com.example.idleback.Model.*;
import com.example.idleback.Repositorios.EmpresaPartidaRepositorio;
import com.example.idleback.Repositorios.EmpresaRepositorio;
import com.example.idleback.Repositorios.PartidaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class EmpresaPartidaController {

    private final EmpresaPartidaRepositorio empresaPartidaRepositorio;

    private final EmpresaRepositorio empresaRepositorio;

    private final PartidaRepositorio partidaRepositorio;

    private final Empresa_partidaDTOConverter empresaPartidaDTOConverter;


    /**
     * Obtenemos una lista de todas los empresas en la partida actual
     *
     * @param id
     * @return Error 404 si no encuentra la partida
     */
    @GetMapping("partida/{id}/empresas")
    public ResponseEntity<List<?>> getCompaniesByAccount(@PathVariable Long id){
        List<Empresa_partida> empresasPorPartida = empresaPartidaRepositorio.findAllByPartida_Id(id);

        if(empresasPorPartida.isEmpty()){
            throw new PartidaNotFoundException(id);
        }else {
            List<Empresa_partidaDTO> dtoList =
                    empresasPorPartida.stream().map(empresaPartidaDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }
    //Tenemos que hacer aqui este endpoint para poder sacar a los trabajadores de una partida concreta,
    //Por eso no se hace en empresa directamente
    /**
     * Obtenemos una lista de todos los trabajadores de una empresa en la partida actual
     *
     * @param id
     * @return Error 404 si no encuentra la relación
     */
    @GetMapping("empresa-partida/{id}/trabajadores")
    public List<Trabajador> getWorkersByCompanyInAccount(@PathVariable Long id){
        Empresa_partida empresa_partida = empresaPartidaRepositorio.findById(id).orElseThrow(() -> new EmpresaPartidaNotFoundException(id));
        return empresa_partida.getTrabajadores();
    }

    /**
     * Creamos una nueva relacion partida-empresa
     *
     * @param nuevo
     * @return relacion insertada
     */
    @PostMapping("/empresa-partida")
    public ResponseEntity<?> newCompanyAccount(@RequestBody CrearEmpresa_partidaDTO nuevo){
        Empresa_partida nEmpresa_partida = new Empresa_partida();
        Partida partida = partidaRepositorio.findById(nuevo.getPartidaId()).orElse(null);
        Empresa empresa = empresaRepositorio.findById(nuevo.getEmpresaId()).orElse(null);
        nEmpresa_partida.setPartida(partida);
        nEmpresa_partida.setEmpresa(empresa);

        //En este caso ante una nueva creación, que sera normalmente al comenzar una partida nueva
        //el valor de desbloqueada comenzara en false por defecto y el de nivel a 0

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaPartidaRepositorio.save(nEmpresa_partida));
    }

    /**
     * Actualizamos una relacion partida-empresa
     *
     * @param nuevo
     * @param id
     * @return relacion actualizada, 404 si no se encuentra la relacion
     */
    @PutMapping("/empresa-partida/{id}")
    public Empresa_partida updateCompanyAccount(@RequestBody ModEmpresa_partidaDTO nuevo, @PathVariable Long id) {
        //En principio en esta relación una vez creada por primera vez ya no es necesario tocar mas las id
        return empresaPartidaRepositorio.findById(id).map(ca -> {
            ca.setDesbloqueada(nuevo.getDesbloqueada());
            ca.setNivel_actual(nuevo.getNivel());
            return empresaPartidaRepositorio.save(ca);
        }).orElseThrow(() -> new EmpresaPartidaNotFoundException(id));
    }
}
