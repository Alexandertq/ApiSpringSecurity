package com.alex.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name="libros")
public class Libro implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer libroId;

    @Column
    private String titulo;

    @Column
    private String autor;

    @DateTimeFormat(pattern="yyyy-MM-dd",iso= DateTimeFormat.ISO.DATE)
    private LocalDate fpublicacion;

    @Column
    private Integer npaginas;

    @OneToOne
    @JoinColumn(name="detalle_id",unique=true,nullable=false)
    private Detalle detalle;

    @ManyToOne
    @JoinColumn(name="editorial_id", nullable=false)
    private Editorial editorial;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_genero",
            joinColumns = @JoinColumn(name = "libro_Id"),
            inverseJoinColumns = @JoinColumn(name = "genero_Id")
    )
    private Set<Genero> genero;

    public Libro() {
    }

    public Libro(Integer libroId, String titulo, String autor, LocalDate fpublicacion, Integer npaginas) {
        this.libroId = libroId;
        this.titulo = titulo;
        this.autor = autor;
        this.fpublicacion = fpublicacion;
        this.npaginas = npaginas;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
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

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Set<Genero> getGenero() {
        return genero;
    }

    public void setGenero(Set<Genero> genero) {
        this.genero = genero;
    }
}
