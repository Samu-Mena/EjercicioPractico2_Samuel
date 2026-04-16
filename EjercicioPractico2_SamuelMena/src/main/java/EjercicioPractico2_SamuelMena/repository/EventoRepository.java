/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.repository;

/**
 *
 * @author samim
 */
import EjercicioPractico2_SamuelMena.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    // Buscar eventos activos o inactivos
    List<Evento> findByActivo(Boolean activo);

    // Buscar por rango de fechas
    List<Evento> findByFechaBetween(LocalDate inicio, LocalDate fin);

    // Buscar por nombre (like)
    List<Evento> findByNombreContainingIgnoreCase(String nombre);

    // Contar eventos activos
    Long countByActivoTrue();
}
