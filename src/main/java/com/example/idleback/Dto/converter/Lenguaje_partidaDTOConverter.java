package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.lenguaje_partida.Lenguaje_partidaDTO;
import com.example.idleback.Dto.trabajador_lenguaje.Trabajador_lenguajeDTO;
import com.example.idleback.Model.Lenguaje_partida;
import com.example.idleback.Model.Trabajador_lenguaje;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Lenguaje_partidaDTOConverter {

    private final ModelMapper modelMapper;

    public Lenguaje_partidaDTO convertToDTO(Lenguaje_partida lenguaje_partida){
            return modelMapper.map(lenguaje_partida, Lenguaje_partidaDTO.class);
    }
}
