package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.trabajador_lenguaje.Trabajador_lenguajeDTO;
import com.example.idleback.Model.Trabajador_lenguaje;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Trabajador_lenguajeDTOConverter {

    private final ModelMapper modelMapper;

    public Trabajador_lenguajeDTO convertToDTO(Trabajador_lenguaje trabajador_lenguaje){
            return modelMapper.map(trabajador_lenguaje, Trabajador_lenguajeDTO.class);
    }
}
