package com.alex.service;

import com.alex.entity.Genero;
import com.alex.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;

@Service
public class GeneroServiceImpl implements GeneroService {


    @Autowired
    private GeneroRepository repository;

    @Override
    public void insert(Genero genero) {
        repository.save(genero);
    }

    @Override
    public void update(Genero genero) {
        repository.save(genero);
    }

    @Override
    public void delete(Integer generoId) {
        repository.deleteById(generoId);
    }

    @Override
    @Transactional(readOnly=true)
    public Genero findById(Integer generoId) {
        return repository.findById(generoId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Genero> findAll() {
        return repository.findAll();
    }

}
