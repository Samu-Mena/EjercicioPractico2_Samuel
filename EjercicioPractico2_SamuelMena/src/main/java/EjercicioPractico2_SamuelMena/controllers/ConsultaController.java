/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_SamuelMena.controllers;

import EjercicioPractico2_SamuelMena.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String vistaConsultas() {
        return "consultas";
    }

    @PostMapping("/estado")
    public String buscarPorEstado(@RequestParam Boolean activo, Model model) {
        model.addAttribute("resultados", eventoService.buscarPorEstado(activo));
        return "consultas";
    }

    @PostMapping("/fechas")
    public String buscarPorFechas(@RequestParam String inicio,
                                 @RequestParam String fin,
                                 Model model) {

        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);

        model.addAttribute("resultados",
                eventoService.buscarPorFechas(fechaInicio, fechaFin));

        return "consultas";
    }

    @PostMapping("/nombre")
    public String buscarPorNombre(@RequestParam String nombre, Model model) {
        model.addAttribute("resultados", eventoService.buscarPorNombre(nombre));
        return "consultas";
    }

    @PostMapping("/activos")
    public String contarActivos(Model model) {
        model.addAttribute("total", eventoService.contarActivos());
        return "consultas";
    }
}
