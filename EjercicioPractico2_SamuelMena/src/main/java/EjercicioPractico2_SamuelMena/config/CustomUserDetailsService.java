/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.config;

import EjercicioPractico2_SamuelMena.domain.Usuario;
import EjercicioPractico2_SamuelMena.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByEmail(email);

    if (usuario == null) {
        throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
    }

    if (usuario.getRol() == null || usuario.getRol().getNombre() == null) {
        throw new UsernameNotFoundException("El usuario " + email + " no tiene un rol asignado correctamente");
    }

    return new User(
            usuario.getEmail(),
            usuario.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority(usuario.getRol().getNombre()))
    );
}

}

