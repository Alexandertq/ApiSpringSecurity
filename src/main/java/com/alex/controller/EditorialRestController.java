package com.alex.controller;

import com.alex.entity.Editorial;
import com.alex.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/editorial")
public class EditorialRestController {

    @Autowired
    private EditorialService editorialService;

    public EditorialRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Editorial> detalleDb=editorialService.findAll();
        return new ResponseEntity<>(detalleDb, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Editorial editorial)
    {
        editorialService.insert(editorial);
        return new ResponseEntity<>("¡Editorial registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{editorialId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Editorial newEditorial,@PathVariable Integer editorialId)
    {
        Editorial editorialDb= editorialService.findById(editorialId);

        if(editorialDb!=null)
        {
            newEditorial.setEditorialId(editorialId);
            editorialService.update(newEditorial);

            return new ResponseEntity<>("¡Editorial editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Editorial no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{editorialId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer editorialId)
    {
        Editorial editorialDb= editorialService.findById(editorialId);

        if(editorialDb!=null)
        {
            editorialService.delete(editorialId);
            return new ResponseEntity<>("¡Editorial borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Editorial no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{editorialId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer editorialId)
    {
        Editorial editorialDb= editorialService.findById(editorialId);

        if(editorialDb!=null){
            return new ResponseEntity<>(editorialDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error Editorial no existe!",HttpStatus.NOT_FOUND);
    }
}
