package edu.badpals.pruebaexamen.repository;

import edu.badpals.pruebaexamen.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
