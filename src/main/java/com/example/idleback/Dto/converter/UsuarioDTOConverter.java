package com.example.idleback.Dto.converter;

import com.example.idleback.Model.Usuario;
import com.example.idleback.Dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioDTOConverter {

    private final ModelMapper modelMapper;

    public UsuarioDTO convertToDTO(Usuario usuario){
            return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
