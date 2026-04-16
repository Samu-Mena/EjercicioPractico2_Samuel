/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico2_SamuelMena.controllers;

import EjercicioPractico2_SamuelMena.domain.Evento;
import EjercicioPractico2_SamuelMena.service.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("eventos", eventoService.listarEventos());
        return "eventos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("evento", new Evento());
        return "eventos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Evento evento) {
        eventoService.guardar(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoService.obtenerPorId(id));
        return "eventos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        eventoService.eliminar(id);
        return "redirect:/eventos";
    }
}