package com.cetus.farmacia.repository;

import com.cetus.farmacia.model.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosEntity, Integer> {
}
