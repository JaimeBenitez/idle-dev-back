package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.empresa.EmpresaDTO;
import com.example.idleback.Model.Empresa;
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
