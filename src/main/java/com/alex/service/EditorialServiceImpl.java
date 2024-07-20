package com.alex.service;

import com.alex.entity.Editorial;
import com.alex.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialRepository repository;

    @Override
    public void insert(Editorial editorial) {
        repository.save(editorial);
    }

    @Override
    public void update(Editorial editorial) {
        repository.save(editorial);
    }

    @Override
    public void delete(Integer editorialId) {
        repository.deleteById(editorialId);
    }

    @Override
    @Transactional(readOnly=true)
    public Editorial findById(Integer editorialId) {
        return repository.findById(editorialId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)

    public Collection<Editorial> findAll() {

        return repository.findAll();
    }
}
