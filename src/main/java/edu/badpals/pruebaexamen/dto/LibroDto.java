package edu.badpals.pruebaexamen.dto;

import edu.badpals.pruebaexamen.model.Autor;


public class LibroDto {
    private String titulo;
    private Autor autor;
    private String genero;
    private int paginas;

    public LibroDto(String titulo,Autor autor, String genero, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    public LibroDto() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String toString() {
        return "LibroDto(titulo=" + this.getTitulo() + ", autor=" + this.getAutor() + ", genero=" + this.getGenero() + ", paginas=" + this.getPaginas() + ")";
    }



}


