package com.cetus.farmacia.repository;

import com.cetus.farmacia.model.entity.RecepcionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcionRepository extends JpaRepository<RecepcionesEntity,Integer> {
}
