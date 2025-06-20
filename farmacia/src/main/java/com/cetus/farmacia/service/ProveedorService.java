package com.cetus.farmacia.service;

import com.cetus.farmacia.model.entity.ProveedoresEntity;
import com.cetus.farmacia.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
     public List<ProveedoresEntity> getProveedores(){
         return proveedorRepository.findAll();
     }

     public Optional<ProveedoresEntity>  findById(Integer id){
                return proveedorRepository.findById(id);
     };
     public ProveedoresEntity save(ProveedoresEntity proveedoresEntity){
         return proveedorRepository.save(proveedoresEntity);
     }

     public void deleteById(Integer id){
         proveedorRepository.deleteById(id);
     }
}
