package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.trabajador_lenguaje.Trabajador_lenguajeDTO;
import com.example.idleback.Dto.trabajador_mejora.Trabajador_mejoraDTO;
import com.example.idleback.Model.Trabajador_lenguaje;
import com.example.idleback.Model.Trabajador_mejora;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Trabajador_mejoraDTOConverter {

    private final ModelMapper modelMapper;

    public Trabajador_mejoraDTO convertToDTO(Trabajador_mejora trabajador_mejora){
            return modelMapper.map(trabajador_mejora, Trabajador_mejoraDTO.class);
    }
}
