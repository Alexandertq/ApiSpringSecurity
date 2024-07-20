package com.alex.service;

import com.alex.entity.Detalle;

import java.util.Collection;

public interface DetalleService {

    public abstract void insert(Detalle detalle);
    public abstract void update(Detalle detalle);
    public abstract void delete(Integer detalleId);
    public abstract Detalle findById(Integer detalleId);
    public abstract Collection<Detalle> findAll();


}
