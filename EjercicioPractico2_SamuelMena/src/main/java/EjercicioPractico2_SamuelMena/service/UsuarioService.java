/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.service;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listarUsuarios();

    Usuario guardar(Usuario usuario);

    Usuario obtenerPorId(Long id);

    void eliminar(Long id);
}
