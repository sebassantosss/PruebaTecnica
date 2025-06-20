package com.cetus.farmacia.controller;

import com.cetus.farmacia.model.entity.ProductosEntity;
import com.cetus.farmacia.model.entity.ProveedoresEntity;
import com.cetus.farmacia.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/proveedor")

public class ProveedorController {

@Autowired
    private ProveedorService proveedorService;

@GetMapping
    public List<ProveedoresEntity> getProveedores(){
    return proveedorService.getProveedores();
}

@GetMapping("/{id}")
    public ResponseEntity<ProveedoresEntity> getProveedor(@PathVariable Integer id){
    Optional<ProveedoresEntity> proveedores = proveedorService.findById(id);
    if(proveedores.isPresent()){
        return ResponseEntity.ok(proveedores.get());
    }
    return ResponseEntity.notFound().build();


    }
    @PostMapping("/guardarProveedor")
    public ProveedoresEntity saveProveedor(@RequestBody ProveedoresEntity proveedoresEntity) {
        return proveedorService.save(proveedoresEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id){
    if(proveedorService.findById(id).isPresent()){
        proveedorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
    }
}





