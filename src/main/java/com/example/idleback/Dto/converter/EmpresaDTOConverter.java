package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.EmpresaDTO;
import com.example.idleback.Dto.MejoraDTO;
import com.example.idleback.Model.Empresa;
import com.example.idleback.Model.Mejora;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpresaDTOConverter {

    private final ModelMapper modelMapper;

    public EmpresaDTO convertToDTO(Empresa empresa){
            return modelMapper.map(empresa, EmpresaDTO.class);
    }
}
