package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.trabajador.TrabajadorDTO;
import com.example.idleback.Model.Trabajador;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrabajadorDTOConverter {

    private final ModelMapper modelMapper;

    public TrabajadorDTO convertToDTO(Trabajador trabajador){
            return modelMapper.map(trabajador, TrabajadorDTO.class);
    }
}
