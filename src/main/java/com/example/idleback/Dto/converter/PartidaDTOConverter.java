package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.partida.PartidaDTO;
import com.example.idleback.Dto.usuario.UsuarioDTO;
import com.example.idleback.Model.Partida;
import com.example.idleback.Model.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartidaDTOConverter {

    private final ModelMapper modelMapper;

    public PartidaDTO convertToDTO(Partida partida){
            return modelMapper.map(partida, PartidaDTO.class);
    }
}
