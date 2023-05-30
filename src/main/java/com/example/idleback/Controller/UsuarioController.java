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
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioRepositorio usuarioRepositorio;

    private final UsuarioDTOConverter usuarioDTOConverter;

    private final PartidaRepositorio partidaRepositorio;


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
        Usuario user = usuarioRepositorio.findByNombre(nombre);
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
     * Creamos un nuevo usuario
     *
     * @param nuevo
     * @return usuario insertado
     */
    @PostMapping("/usuario")
    public ResponseEntity<?> newUser(@RequestBody CrearUsuarioDTO nuevo){
        Usuario nUsuario = new Usuario();
        Partida partida = null;
        //Para poder meter el repositorio completo necesitamos buscarlo usando la id que le pasamos en el DTO
        //Para poder considerar un equipo como nulo tenemos que comprobar antes de hacer el findById
        if(nuevo.getPartidaId() != null){
            partida = partidaRepositorio.findById(nuevo.getPartidaId()).orElse(null);
        }
        nUsuario.setPartida(partida);
        nUsuario.setNombre(nuevo.getNombre());
        nUsuario.setEmail(nuevo.getEmail());
        nUsuario.setContrasenia(nuevo.getContrasenia());
        nUsuario.setAvatar(nuevo.getAvatar());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepositorio.save(nUsuario));
    }

    /**
     * Actualizamos un usuario
     *
     * @param nuevo
     * @param id
     * @return usuario actualizado, 404 si no se encuentra el usuario
     */
    @PutMapping("/usuario/{id}")
    public Usuario updateUser(@RequestBody ModUsuarioDTO nuevo, @PathVariable Long id) {

        return usuarioRepositorio.findById(id).map(u -> {
            u.setNombre(nuevo.getNombre());
            u.setEmail(nuevo.getEmail());
            u.setContrasenia(nuevo.getContrasenia());
            u.setAvatar(nuevo.getAvatar());
            return usuarioRepositorio.save(u);
        }).orElseThrow(() -> new UsuarioIdNotFoundException(id));
    }

    //No esta contemplada la posibilidad de borrar usuarios
}
