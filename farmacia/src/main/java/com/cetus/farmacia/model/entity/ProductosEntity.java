package com.cetus.farmacia.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productos")

public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String nombreLaboratorio;
    private String estado;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecepcionesEntity> recepciones;

}
