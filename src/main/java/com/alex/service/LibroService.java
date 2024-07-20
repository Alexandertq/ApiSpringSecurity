package com.alex.service;

import com.alex.entity.Libro;

import java.util.Collection;

public interface LibroService {

    public abstract void insert(Libro libro);
    public abstract void update(Libro libro);
    public abstract void delete(Integer libroId);
    public abstract Libro findById(Integer libroId);
    public abstract Collection<Libro> findAll();
}
