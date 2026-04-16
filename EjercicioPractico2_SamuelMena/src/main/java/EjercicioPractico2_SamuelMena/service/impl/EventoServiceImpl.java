/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.service.impl;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Evento;
import EjercicioPractico2_SamuelMena.repository.EventoRepository;
import EjercicioPractico2_SamuelMena.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento obtenerPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public List<Evento> buscarPorEstado(Boolean activo) {
        return eventoRepository.findByActivo(activo);
    }

    @Override
    public List<Evento> buscarPorFechas(LocalDate inicio, LocalDate fin) {
        return eventoRepository.findByFechaBetween(inicio, fin);
    }

    @Override
    public List<Evento> buscarPorNombre(String nombre) {
        return eventoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Long contarActivos() {
        return eventoRepository.countByActivoTrue();
    }
}
