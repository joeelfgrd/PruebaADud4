package edu.badpals.pruebaexamen.service;

import edu.badpals.pruebaexamen.dto.LibroDto;
import edu.badpals.pruebaexamen.model.Autor;
import edu.badpals.pruebaexamen.model.Libro;
import edu.badpals.pruebaexamen.repository.LibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public LibroDto convertToDTO(Libro libro) {
        return modelMapper.map(libro, LibroDto.class);
    }

    @Transactional
    public List<LibroDto> findAll() {
        List<Libro> libros = libroRepository.findAll();
        List<LibroDto> librosDto = new ArrayList<>();
        for (Libro libro : libros) {
            librosDto.add(convertToDTO(libro));
        }
        return librosDto;
    }

    @Transactional
    public Libro crearLibroConAutor(String titulo, String genero, int paginas, Autor autor) {
        Libro libro = new Libro(titulo, genero, paginas);
        autor.addLibro(libro); // Asignamos al autor y actualizamos la colección
        // Guardamos el libro (gracias a la relación bidireccional y, si hay cascada,
        // se podría guardar automáticamente, pero la forma más segura es guardar el libro)
        return libroRepository.save(libro);
    }




    @Transactional
    public Libro findById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }







}
