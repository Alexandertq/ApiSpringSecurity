package com.alex.controller;

import com.alex.entity.UserE;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UserRestController {

    @Autowired
    private UserService userService;

    public UserRestController() {
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<UserE> userDb = userService.findAll();
        return new ResponseEntity<>(userDb, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody UserE user) {

        userService.insert(user);
        return new ResponseEntity<>("¡Usuario registrado!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{userId}")
    public ResponseEntity<?> editar_PUT(@RequestBody UserE newUser, @PathVariable Integer userId) {
        UserE userDb = userService.findById(userId);

        if (userDb != null) {
            newUser.setUserId(userId);
            userService.update(newUser);

            return new ResponseEntity<>("¡Usuario editado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Usuario no existe!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{userId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer userId) {
        UserE userDb = userService.findById(userId);

        if (userDb != null) {
            userService.delete(userId);
            return new ResponseEntity<>("¡Usuario borrado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Usuario no existe!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{userId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer userId) {
        {

            UserE userDb = userService.findById(userId);

            if (userDb != null) {


                return new ResponseEntity<>(userDb, HttpStatus.FOUND);
            }

            return new ResponseEntity<>("¡Error Usuario no existe!", HttpStatus.NOT_FOUND);
        }

    }


}
