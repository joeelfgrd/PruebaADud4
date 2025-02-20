package edu.badpals.pruebaexamen.service;

import edu.badpals.pruebaexamen.dto.AutorDTO;
import edu.badpals.pruebaexamen.model.Autor;
import edu.badpals.pruebaexamen.model.Libro;
import edu.badpals.pruebaexamen.repository.AutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AutorDTO convertToDTO(Autor autor) {
        return modelMapper.map(autor, AutorDTO.class);
    }

    @Transactional
    public List<AutorDTO> findAll() {
        List<Autor> autores = autorRepository.findAll();
        List<AutorDTO> autoresDto = new ArrayList<>();
        for (Autor autor : autores) {
            autoresDto.add(convertToDTO(autor));
        }
        return autoresDto;
    }

    @Transactional
    public Autor nuevoAutor(String nombre, String apellidos, String nacionalidad, int edad) {
        Autor autor = new Autor(nombre, apellidos, nacionalidad, edad);
        return autorRepository.save(autor);
    }


    public Autor findById(Long idAutor) {
        return autorRepository.findById(idAutor).orElse(null);
    }
}
