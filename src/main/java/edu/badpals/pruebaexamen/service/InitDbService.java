package edu.badpals.pruebaexamen.service;

import edu.badpals.pruebaexamen.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;

@Service
@Profile("dev")
public class InitDbService {

    private final AutorService autorService;
    private final LibroService libroService;

    public InitDbService(AutorService autorService, LibroService libroService) {
        this.autorService = autorService;
        this.libroService = libroService;
    }


    @PostConstruct
    public void initDatabase() {
        Autor autor1 = autorService.nuevoAutor("Stephen King", "Maine, 1947", "Escritor de terror y ficción", 75);
        Autor autor2 = autorService.nuevoAutor("J.K. Rowling", "Yate, 1965", "Escritora de fantasía", 57);

        libroService.crearLibroConAutor("It", "Terror", 1138, autor1);
        libroService.crearLibroConAutor("Harry Potter y la piedra filosofal", "Fantasía", 223, autor2);
    }

    }