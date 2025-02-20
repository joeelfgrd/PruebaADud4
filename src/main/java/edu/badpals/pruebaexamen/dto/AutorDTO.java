package edu.badpals.pruebaexamen.dto;

import java.util.ArrayList;
import java.util.List;

public class AutorDTO {
    private Long idAutor;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private int edad;
    private List<LibroDto> libros = new ArrayList<>();

    public AutorDTO(Long idAutor, String nombre, String apellidos, String nacionalidad, int edad, List<LibroDto> libros) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.libros = libros;
    }

    public AutorDTO(String nombre, String apellidos, String nacionalidad, int edad, List<LibroDto> libros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.libros = libros;
    }

    public AutorDTO() {
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<LibroDto> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroDto> libros) {
        this.libros = libros;
    }
}
