package com.cetus.farmacia.service;

import com.cetus.farmacia.model.entity.RecepcionesEntity;
import com.cetus.farmacia.repository.RecepcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepcionService {

    @Autowired

    private RecepcionRepository recepcionRepository;

    public List<RecepcionesEntity> getRecepciones() {
        return recepcionRepository.findAll();
    }

    public Optional<RecepcionesEntity> findById(Integer id){
        return recepcionRepository.findById(id);

    }
    public RecepcionesEntity save(RecepcionesEntity recepcionesEntity){
        return recepcionRepository.save(recepcionesEntity);
    }

    public void deleteById(Integer id){
        recepcionRepository.deleteById(id);
    }
}
