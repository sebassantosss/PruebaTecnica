package com.cetus.farmacia.controller;

import com.cetus.farmacia.model.entity.RecepcionesEntity;
import com.cetus.farmacia.service.RecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/Recepcion")

public class RecepcionController {

    @Autowired
    private RecepcionService recepcionService;

    @GetMapping
    public List<RecepcionesEntity> getRecepciones(){
        return RecepcionesEntity.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<RecepcionesEntity> getRecepcion(@PathVariable Integer id){
        Optional<RecepcionesEntity> recepcion = recepcionService.findById(id);
        if (recepcion.isPresent()){
            return ResponseEntity.ok(recepcion.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/guardarRecepcion")
    public RecepcionesEntity saveRecepcion(@RequestBody RecepcionesEntity recepcion){
        return recepcionService.save(recepcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecepcion(@PathVariable Integer id){
        if (recepcionService.findById(id).isPresent()){
            recepcionService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
