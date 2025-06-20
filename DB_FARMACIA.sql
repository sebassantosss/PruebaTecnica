CREATE DATABASE IF NOT EXISTS FARMACIA;
USE  FARMACIA; 
CREATE TABLE proveedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_identificacion ENUM('CEDULA', 'NIT', 'CEDULA_EXTRANJERIA', 'NIT_EXTRANJERIA') NOT NULL,
    numero_identificacion VARCHAR(20) NOT NULL UNIQUE,
    razon_social VARCHAR(255) NOT NULL,
    direccion TEXT NOT NULL,
    nombre_contacto VARCHAR(255) NOT NULL,
    celular_contacto VARCHAR(20) NOT NULL
    
    );
    
    CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    nombre_laboratorio VARCHAR(255) NOT NULL,
    estado ENUM('ACTIVO', 'INACTIVO') DEFAULT 'ACTIVO'
   
);
CREATE TABLE recepciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora_recepcion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    proveedor_id INT NOT NULL,
    producto_id INT NOT NULL,
    numero_factura VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    lote VARCHAR(100) NOT NULL,
    registro_invima VARCHAR(100),
    fecha_vencimiento DATE NOT NULL,
    descripcion_estado_presentacion TEXT NOT NULL,
   
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);
