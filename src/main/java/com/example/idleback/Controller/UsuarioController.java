package com.example.idleback.Controller;

import com.example.idleback.Dto.usuario.CrearUsuarioDTO;
import com.example.idleback.Dto.usuario.ModUsuarioDTO;
import com.example.idleback.Dto.usuario.UsuarioDTO;
import com.example.idleback.Dto.converter.UsuarioDTOConverter;
import com.example.idleback.Error.UsuarioIdNotFoundException;
import com.example.idleback.Error.UsuarioNameNotFoundException;
import com.example.idleback.Model.Partida;
import com.example.idleback.Model.Usuario;
import com.example.idleback.Repositorios.PartidaRepositorio;
import com.example.idleback.Repositorios.UsuarioRepositorio;
import com.example.idleback.Upload.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioRepositorio usuarioRepositorio;

    private final UsuarioDTOConverter usuarioDTOConverter;

    private final PartidaRepositorio partidaRepositorio;

    private final StorageService storageService;

    private PasswordEncoder bcryptEncoder;


    /**
     * Obtenemos todos los usuarios
     *
     * @return lista de usuarios
     */
    @GetMapping("/usuarios")
    public ResponseEntity<List<?>> getAllUsers(){
        List<Usuario> players = usuarioRepositorio.findAll();
        if(players.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<UsuarioDTO> dtoList =
                    players.stream().map(usuarioDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }
    /**
     * Obtenemos un usuario en base a su nombre
     *
     * @param nombre
     * @return Error 404 si no encuentra el usuario
     */
    @GetMapping("usuario/{nombre}")
    public UsuarioDTO getUserById(@PathVariable String nombre){
        Usuario user = usuarioRepositorio.findByNombre(nombre).orElse(null);
        if(user == null){
            throw new UsuarioNameNotFoundException(nombre);
        }
        else{
            //Para poder mostrar la id de partida que luego usaremos para sacar todos los datos, es necesario que
            //en este endpoint saque el DTO en lugar del usuario individual
            UsuarioDTO DTOUser = new UsuarioDTO();
            DTOUser.setId(user.getId());
            DTOUser.setPartidaId(user.getPartida().getId());
            DTOUser.setNombre(user.getNombre());
            DTOUser.setEmail(user.getEmail());
            DTOUser.setContrasenia(user.getContrasenia());
            DTOUser.setAvatar(user.getAvatar());

            return DTOUser;
        }
    }



    /**
     * Actualizamos un usuario
     *
     * @param nuevo
     * @param id
     * @return usuario actualizado, 404 si no se encuentra el usuario
     */
    @PutMapping(value="/usuario/{id}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Usuario updateUser( @RequestPart("nuevo") ModUsuarioDTO nuevo, @RequestPart(name="file", required = false) MultipartFile file, @PathVariable Long id) {
        Usuario user = usuarioRepositorio.findById(id).orElseThrow(() -> new UsuarioIdNotFoundException(id));
        String urlAvatar = null;
        user.setEmail(nuevo.getEmail());

        if(file != null) {

            String avatar = storageService.store(file);
            //Local
            //urlAvatar = MvcUriComponentsBuilder.fromMethodName(FicherosController.class, "serveFile", avatar, null)
            //       .build().toUriString();
            //Production
            urlAvatar = MvcUriComponentsBuilder.fromMethodName(FicherosController.class, "serveFile", avatar, null)
                    .scheme("https").build().toUriString();
            user.setAvatar(urlAvatar);
        }
        if(nuevo.getContrasenia() != ""){
            user.setContrasenia(bcryptEncoder.encode(nuevo.getContrasenia()));
        }

        return usuarioRepositorio.save(user);

    }

    //No esta contemplada la posibilidad de borrar usuarios
}
