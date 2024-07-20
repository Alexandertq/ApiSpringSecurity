package com.alex.mapper;

import com.alex.entity.Libro;

import java.time.LocalDate;

public class LibroMapper
{
    private Integer LibroId;
    private String titulo;
    private String autor;
    private LocalDate fpublicacion;
    private Integer npaginas;
    private Integer detalleId;
    private Integer editorialId;

    public LibroMapper() {
    }

    public LibroMapper(Libro libro) {
        this(libro.getLibroId(),libro.getTitulo(), libro.getAutor(),libro.getFpublicacion(),
                libro.getNpaginas(),libro.getDetalle().getDetalleId(),libro.getEditorial().getEditorialId());
    }

    public LibroMapper(Integer libroId, String titulo, String autor, LocalDate fpublicacion, Integer npaginas, Integer detalleId, Integer editorialId) {
        this.LibroId = libroId;
        this.titulo = titulo;
        this.autor = autor;
        this.fpublicacion = fpublicacion;
        this.npaginas = npaginas;
        this.detalleId = detalleId;
        this.editorialId = editorialId;
    }

    public Integer getLibroId() {
        return LibroId;
    }

    public void setLibroId(Integer libroId) {
        LibroId = libroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFpublicacion() {
        return fpublicacion;
    }

    public void setFpublicacion(LocalDate fpublicacion) {
        this.fpublicacion = fpublicacion;
    }

    public Integer getNpaginas() {
        return npaginas;
    }

    public void setNpaginas(Integer npaginas) {
        this.npaginas = npaginas;
    }

    public Integer getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }
}
