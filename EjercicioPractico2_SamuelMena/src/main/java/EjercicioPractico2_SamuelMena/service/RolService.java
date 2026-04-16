/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.service;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Rol;
import java.util.List;

public interface RolService {

    List<Rol> listarRoles();

    Rol guardar(Rol rol);

    Rol obtenerPorId(Long id);

    void eliminar(Long id);
}