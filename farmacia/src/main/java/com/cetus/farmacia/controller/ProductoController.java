package com.cetus.farmacia.controller;

import com.cetus.farmacia.model.entity.ProductosEntity;
import com.cetus.farmacia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductosEntity> getProducto(){
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosEntity> getProductoById(@PathVariable Integer id) {
        Optional<ProductosEntity> productosEntity = productoService.findById(id);
        if (productosEntity.isPresent()) {
            return ResponseEntity.ok(productosEntity.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/guardarProducto")
    public ProductosEntity saveProducto(@RequestBody ProductosEntity productosEntity){
        return productoService.save(productosEntity);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id){
        if (productoService.findById(id).isPresent()){
               productoService.deleteById(id);
               return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

