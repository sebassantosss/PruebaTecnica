package com.cetus.farmacia.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recepciones")

public class RecepcionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String fechaHoraRecepcion;
    private String numeroFactura;
    private Integer cantidad;
    private String lote;
    private String registroInvima;
    private String fechaVencimiento;
    private String descripcionEstadoPresentacion;

    // Relación Many-to-One con Proveedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id", nullable = false)
    private ProveedoresEntity proveedor;

    // Relación Many-to-One con Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductosEntity producto;

    public static List<RecepcionesEntity> getAll() {
        return List.of();
    }
}

