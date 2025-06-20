package com.cetus.farmacia.service;

import com.cetus.farmacia.model.entity.ProductosEntity;
import com.cetus.farmacia.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductosEntity> getAll(){
        return productoRepository.findAll();
    }
    
    public Optional<ProductosEntity> findById(Integer id){
        return productoRepository.findById(id);
    }

    public ProductosEntity save(ProductosEntity productosEntity){
        return productoRepository.save(productosEntity);

    }

    public void deleteById(Integer id){

        productoRepository.deleteById(id);
    }
}
