/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico2_SamuelMena.controllers;

import EjercicioPractico2_SamuelMena.domain.Rol;
import EjercicioPractico2_SamuelMena.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("roles", rolService.listarRoles());
        return "roles/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Rol rol) {
        rolService.guardar(rol);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.obtenerPorId(id));
        return "roles/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
        return "redirect:/roles";
    }
}