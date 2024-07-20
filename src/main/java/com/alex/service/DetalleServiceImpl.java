package com.alex.service;

import com.alex.entity.Detalle;
import com.alex.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;

@Service
public class DetalleServiceImpl implements DetalleService {


    @Autowired
    private DetalleRepository repository;


    @Override
    public void insert(Detalle detalle) {
        repository.save(detalle);
    }

    @Override
    public void update(Detalle detalle) {
        repository.save(detalle);
    }

    @Override
    public void delete(Integer detalleId) {
        repository.deleteById(detalleId);
    }

    @Override
    @Transactional(readOnly=true)
    public Detalle findById(Integer detalleId) {
        return repository.findById(detalleId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Detalle> findAll() {
        return repository.findAll();
    }


}