package com.alex.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="generos")
public class Genero implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer generoId;

    @Column
    private String nombre;


    public Genero() {
    }

    public Genero(Integer generoId, String nombre) {
        this.generoId = generoId;
        this.nombre = nombre;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public String getNombre() {
        return nombre;
    }

}
