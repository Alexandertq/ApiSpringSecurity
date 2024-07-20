package com.alex.service;

import com.alex.entity.Genero;
import com.alex.entity.Libro;
import com.alex.entity.Role;
import com.alex.entity.UserE;
import com.alex.repository.GeneroRepository;
import com.alex.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository repository;

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    @Transactional
    public void insert(Libro libro) {

        Set<Genero> generos = new HashSet<>();
        for (Genero genero : libro.getGenero()) {
            Genero existingRole = generoRepository.findById(genero.getGeneroId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "genero no encontrado"));
            generos.add(existingRole);
        }
        libro.setGenero(generos);


        repository.save(libro);
    }

    @Override
    @Transactional
    public void update(Libro libro) {
        repository.save(libro);
    }

    @Override
    @Transactional
    public void delete(Integer libroId) {
        repository.deleteById(libroId);
    }

    @Override
    @Transactional(readOnly=true)
    public Libro findById(Integer libroId) {
        return repository.findById(libroId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Libro> findAll() {
        return repository.findAll();
    }
}
