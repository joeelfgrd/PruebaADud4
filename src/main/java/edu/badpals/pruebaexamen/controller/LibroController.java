package edu.badpals.pruebaexamen.controller;

import edu.badpals.pruebaexamen.dto.AutorDTO;
import edu.badpals.pruebaexamen.dto.LibroDto;
import edu.badpals.pruebaexamen.model.Autor;
import edu.badpals.pruebaexamen.service.AutorService;
import edu.badpals.pruebaexamen.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @GetMapping("/libros")
    public String listaLibros(Model model) {
        List<LibroDto> libros = libroService.findAll();
        model.addAttribute("libros", libros);
        return "libros";
    }

    @GetMapping("/libros/nuevo")
    public String formularioNuevoLibro(Model model) {
        List<AutorDTO> autores = autorService.findAll(); // Trae la lista de autores
        System.out.println("Autores disponibles en el formulario: " + autores); // Debug
        model.addAttribute("autores", autores);
        return "libro-form"; // Asegúrate de que esta es la vista correcta
    }


    // POST: Guardar el nuevo libro
    @PostMapping("/libros/nuevo")
    public String guardarNuevoLibro(@RequestParam String titulo,
                                    @RequestParam String genero,
                                    @RequestParam int paginas,
                                    @RequestParam Long idAutor) {

        // Buscar el autor en la base de datos
        Autor autor = autorService.findById(idAutor);

        libroService.crearLibroConAutor(titulo, genero, paginas, autor);

        // Redirigir a la lista de libros
        return "redirect:/libros";
    }






}
