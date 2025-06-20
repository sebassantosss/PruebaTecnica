package com.cetus.farmacia.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="proveedores")

public class ProveedoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String razonSocial;
    private String direccion;
    private String nombreContacto;
    private String celularContacto;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecepcionesEntity> recepciones;

}
