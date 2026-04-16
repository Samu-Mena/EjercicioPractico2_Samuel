/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.service.impl;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Usuario;
import EjercicioPractico2_SamuelMena.repository.UsuarioRepository;
import EjercicioPractico2_SamuelMena.service.EmailService;
import EjercicioPractico2_SamuelMena.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {

        Usuario nuevo = usuarioRepository.save(usuario);

        // enviar correo
        emailService.enviarCorreo(
                usuario.getEmail(),
                "Bienvenido a la plataforma",
                "Hola " + usuario.getNombre() + ", tu cuenta fue creada correctamente."
        );

        return nuevo;
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Autowired
    private EmailService emailService;
}
