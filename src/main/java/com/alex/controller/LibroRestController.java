package com.alex.controller;

import com.alex.entity.Libro;
import com.alex.mapper.LibroMapper;
import com.alex.service.LibroService;
import com.alex.util.LibroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/libro")
public class LibroRestController {

    @Autowired
    private LibroService libroService;

    public LibroRestController() {
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Libro> libroDb = libroService.findAll();
        Collection<LibroMapper> libroMapper = LibroUtil.convertList(libroDb);

        return new ResponseEntity<>(libroMapper, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Libro libro) {
        libroService.insert(libro);
        return new ResponseEntity<>("¡Libro registrado!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{libroId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Libro newLibro, @PathVariable Integer libroId) {
        Libro libroDb = libroService.findById(libroId);

        if (libroDb != null) {
            newLibro.setLibroId(libroId);
            libroService.update(newLibro);

            return new ResponseEntity<>("¡Libro editado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Libro no existe!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{libroId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer libroId) {
        Libro libroDb = libroService.findById(libroId);

        if (libroDb != null) {
            libroService.delete(libroId);
            return new ResponseEntity<>("¡Libro borrado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Libro no existe!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{libroId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer libroId) {
        {

            Libro libroDb = libroService.findById(libroId);

            if (libroDb != null) {

                LibroMapper libroMapper = LibroUtil.convertEntity(libroDb);
                return new ResponseEntity<>(libroMapper, HttpStatus.FOUND);
            }

            return new ResponseEntity<>("¡Error Libro no existe!", HttpStatus.NOT_FOUND);
        }

    }
}