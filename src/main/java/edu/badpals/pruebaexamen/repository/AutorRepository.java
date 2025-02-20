package edu.badpals.pruebaexamen.repository;

import edu.badpals.pruebaexamen.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
