package edu.badpals.pruebaexamen.controller;

import edu.badpals.pruebaexamen.dto.AutorDTO;
import edu.badpals.pruebaexamen.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public String listaAutores(Model model) {
        List<AutorDTO> autores = autorService.findAll();
        model.addAttribute("autores", autores);

        return "autores";
    }

    @GetMapping("/autores/nuevo")
    public String formularioNuevoAutor() {
        return "autor-form";
    }

    @PostMapping("/autores/nuevo")
    public String guardarNuevoAutor(@RequestParam String nombre,
                                    @RequestParam String apellidos,
                                    @RequestParam String nacionalidad,
                                    @RequestParam int edad) {

        autorService.nuevoAutor(nombre, apellidos, nacionalidad, edad);
        return "redirect:/libros/nuevo";
    }
}
