package com.alex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="detalles")
public class Detalle implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer detalleId;

    @Column
    private String resumen;

    @Column
    private String peso;

    @Column
    private String dimensiones;

    @JsonIgnore
    @OneToOne(mappedBy="detalle")
    private Libro libro;

    public Detalle() {
    }

    public Detalle(Integer detalleId, String resumen, String peso, String dimensiones) {
        this.detalleId = detalleId;
        this.resumen = resumen;
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    public Integer getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Libro getLibro() { return libro; }

    public void setLibro(Libro libro) { this.libro = libro; }
}
