package com.example.idleback.Controller;

import com.example.idleback.Dto.usuario.CrearUsuarioDTO;
import com.example.idleback.Dto.usuario.UsuarioDTO;
import com.example.idleback.Dto.converter.UsuarioDTOConverter;
import com.example.idleback.Error.UsuarioNotFoundException;
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
     * Obtenemos un usuario en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra el usuario
     */
    @GetMapping("usuario/{id}")
    public Usuario getUserById(@PathVariable Long id){

        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
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
    public Usuario updateUser(@RequestBody CrearUsuarioDTO nuevo, @PathVariable Long id) {
        Partida partida= null;
        if(nuevo.getPartidaId() != null){
            partida = partidaRepositorio.findById(nuevo.getPartidaId()).orElse(null);
        }
        //Para que lo admita la lambda la variable debe ser final, asi que todas las comprobaciones las debemos hacer en
        //otra variable
        final Partida nPartida = partida;

        return usuarioRepositorio.findById(id).map(u -> {
            u.setPartida(nPartida);
            u.setNombre(nuevo.getNombre());
            u.setEmail(nuevo.getEmail());
            u.setContrasenia(nuevo.getContrasenia());
            u.setAvatar(nuevo.getAvatar());
            return usuarioRepositorio.save(u);
        }).orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    //No esta contemplada la posibilidad de borrar usuarios
}
