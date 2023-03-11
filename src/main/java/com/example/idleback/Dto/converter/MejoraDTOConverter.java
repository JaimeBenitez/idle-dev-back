package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.LenguajeDTO;
import com.example.idleback.Dto.MejoraDTO;
import com.example.idleback.Model.Lenguaje;
import com.example.idleback.Model.Mejora;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MejoraDTOConverter {

    private final ModelMapper modelMapper;

    public MejoraDTO convertToDTO(Mejora mejora){
            return modelMapper.map(mejora, MejoraDTO.class);
    }
}
