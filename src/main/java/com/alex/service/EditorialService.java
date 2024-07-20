package com.alex.service;

import com.alex.entity.Editorial;

import java.util.Collection;

public interface EditorialService {
    public abstract void insert(Editorial editorial);
    public abstract void update(Editorial editorial);
    public abstract void delete(Integer editorialId);
    public abstract Editorial findById(Integer editorialId);
    public abstract Collection<Editorial> findAll();
}
