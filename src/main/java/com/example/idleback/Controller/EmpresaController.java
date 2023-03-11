package com.example.idleback.Controller;

import com.example.idleback.Dto.EmpresaDTO;

import com.example.idleback.Dto.converter.EmpresaDTOConverter;
import com.example.idleback.Error.EmpresaNotFoundException;

import com.example.idleback.Model.Empresa;


import com.example.idleback.Repositorios.EmpresaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaRepositorio empresaRepositorio;

    private final EmpresaDTOConverter empresaDTOConverter;


    /**
     * Obtenemos todas las empresas
     *
     * @return lista de empresas
     */
    @GetMapping("/empresas")
    public ResponseEntity<List<?>> getAllCompanies(){
        List<Empresa> companies = empresaRepositorio.findAll();
        if(companies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<EmpresaDTO> dtoList =
                    companies.stream().map(empresaDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }
    /**
     * Obtenemos una empresa en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra la empresa
     */
    @GetMapping("empresa/{id}")
    public Empresa getCompanyById(@PathVariable Long id){

        return empresaRepositorio.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException(id));
    }
}
