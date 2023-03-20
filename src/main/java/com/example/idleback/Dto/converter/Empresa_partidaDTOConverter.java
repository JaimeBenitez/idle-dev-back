package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.empresa_partida.Empresa_partidaDTO;
import com.example.idleback.Dto.trabajador_lenguaje.Trabajador_lenguajeDTO;
import com.example.idleback.Model.Empresa_partida;
import com.example.idleback.Model.Trabajador_lenguaje;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Empresa_partidaDTOConverter {

    private final ModelMapper modelMapper;

    public Empresa_partidaDTO convertToDTO(Empresa_partida empresa_partida){
            return modelMapper.map(empresa_partida, Empresa_partidaDTO.class);
    }
}
