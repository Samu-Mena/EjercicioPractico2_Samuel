/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.service.impl;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Rol;
import EjercicioPractico2_SamuelMena.repository.RolRepository;
import EjercicioPractico2_SamuelMena.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}

