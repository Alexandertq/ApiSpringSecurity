package com.alex.controller;

import com.alex.entity.Detalle;
import com.alex.entity.Editorial;
import com.alex.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/detalle")
public class DetalleRestController {

    @Autowired
    private DetalleService detalleService;

    public DetalleRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Detalle> detalleDb=detalleService.findAll();
        return new ResponseEntity<>(detalleDb, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Detalle detalle)
    {
        detalleService.insert(detalle);
        return new ResponseEntity<>("¡Detalle registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{detalleId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Detalle newDetalle,@PathVariable Integer detalleId)
    {
        Detalle detalleDb=detalleService.findById(detalleId);

        if(detalleDb!=null)
        {
            newDetalle.setDetalleId(detalleId);
            detalleService.update(newDetalle);

            return new ResponseEntity<>("¡Detalle editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Detalle no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{detalleId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer detalleId)
    {
        Detalle detalleDb= detalleService.findById(detalleId);

        if(detalleDb!=null)
        {
            detalleService.delete(detalleId);
            return new ResponseEntity<>("¡Detalle borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Detalle no existe!",HttpStatus.NOT_FOUND);


    }

    @GetMapping("/buscar/{detalleId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer detalleId)
    {
        Detalle detalleDb=detalleService.findById(detalleId);

        if(detalleDb!=null) {
            return new ResponseEntity<>(detalleDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error Detalle no existe!",HttpStatus.NOT_FOUND);
    }
}
