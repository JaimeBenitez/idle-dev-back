package com.example.idleback.Dto.converter;

import com.example.idleback.Dto.LenguajeDTO;
import com.example.idleback.Dto.UsuarioDTO;
import com.example.idleback.Model.Lenguaje;
import com.example.idleback.Model.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LenguajeDTOConverter {

    private final ModelMapper modelMapper;

    public LenguajeDTO convertToDTO(Lenguaje lenguaje){
            return modelMapper.map(lenguaje, LenguajeDTO.class);
    }
}
