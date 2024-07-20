package com.alex.service;

import com.alex.entity.Genero;

import java.util.Collection;

public interface GeneroService {

    public abstract void insert(Genero genero);
    public abstract void update(Genero genero);
    public abstract void delete(Integer generoId);
    public abstract Genero findById(Integer generoId);
    public abstract Collection<Genero> findAll();
}
