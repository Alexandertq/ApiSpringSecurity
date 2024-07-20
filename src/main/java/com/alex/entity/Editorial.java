package com.alex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name="editoriales")
public class Editorial implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer editorialId;

    @Column
    private String nombre;

    @Column
    private String pais;

    @Column
    private String direccion;

    @Column (unique=true,nullable=false)
    private String correo;

    @Column (unique=true,nullable=false)
    private String telefono;

    @JsonIgnore
    @OneToMany(mappedBy="editorial")
    private Collection<Libro> itemsLibro=new ArrayList<>();

    public Editorial() {
    }

    public Editorial(Integer editorialId, String nombre, String pais, String direccion, String correo, String telefono) {
        this.editorialId = editorialId;
        this.nombre = nombre;
        this.pais = pais;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Libro> getItemsLibro() {
        return itemsLibro;
    }

    public void setItemsLibro(Collection<Libro> itemsLibro) {
        this.itemsLibro = itemsLibro;
    }
}