/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.service;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Evento;
import java.time.LocalDate;
import java.util.List;

public interface EventoService {

    List<Evento> listarEventos();

    Evento guardar(Evento evento);

    Evento obtenerPorId(Long id);

    void eliminar(Long id);

    // consultas
    List<Evento> buscarPorEstado(Boolean activo);

    List<Evento> buscarPorFechas(LocalDate inicio, LocalDate fin);

    List<Evento> buscarPorNombre(String nombre);

    Long contarActivos();
}
