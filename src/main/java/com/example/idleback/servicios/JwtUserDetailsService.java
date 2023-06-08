package com.example.idleback.servicios;

import java.util.ArrayList;

import com.example.idleback.Dto.usuario.CrearUsuarioDTO;
import com.example.idleback.Model.Partida;
import com.example.idleback.Model.Usuario;
import com.example.idleback.Repositorios.PartidaRepositorio;
import com.example.idleback.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PartidaRepositorio partidaRepositorio;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepositorio.findByNombre(username).orElse(null);

        if (user != null) {
            return new User(user.getNombre(), user.getContrasenia(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public Usuario save(CrearUsuarioDTO user) {
        Usuario nUsuario = new Usuario();
        Partida nPartida = new Partida();
        //Guardamos la partida nueva y la preparamos para pasarla al usuario
        nPartida = partidaRepositorio.save(nPartida);
        nUsuario.setPartida(nPartida);
        nUsuario.setNombre(user.getNombre());
        nUsuario.setEmail(user.getEmail());
        nUsuario.setContrasenia(bcryptEncoder.encode(user.getContrasenia()));
        return usuarioRepositorio.save(nUsuario);
    }
}
