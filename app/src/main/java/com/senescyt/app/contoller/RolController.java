/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senescyt.app.contoller;

import com.senescyt.app.model.Rol;
import com.senescyt.app.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author ALEJO PC
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/read")
    public ResponseEntity<List<Rol>> read() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Rol> create(@RequestBody Rol p) {
        return new ResponseEntity<>(rolService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> update(@PathVariable Long id, @RequestBody Rol r) {
        Rol rol = rolService.findById(id);
        if (rol != null) {
            try {

                rol.setRolNombre(r.getRolNombre());
    rol.setRolFechaRegistro(r.getRolFechaRegistro());

                return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rol> delete(@PathVariable Long id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
