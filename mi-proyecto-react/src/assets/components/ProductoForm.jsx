import { useState } from "react";
import { createProducto } from "../api/apiProducto.js";

function ProductoForm({ onCreated }) {
  const [producto, setProducto] = useState({
    codigo: "",
    nombre: "",
    descripcion: "",
    estado: "ACTIVO",
    nombreLaboratorio: ""
  });

  const handleChange = (e) => {
    setProducto({ ...producto, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await createProducto(producto);
      alert("Producto guardado exitosamente.");
      setProducto({ codigo: "", nombre: "", descripcion: "", estado: "ACTIVO", nombreLaboratorio: "" });
      if (onCreated) onCreated();
    } catch (error) {
      alert("Error al guardar el producto: " + error.message);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="codigo" placeholder="Código" onChange={handleChange} value={producto.codigo} required />
      <input name="nombre" placeholder="Nombre" onChange={handleChange} value={producto.nombre} required />
      <input name="descripcion" placeholder="Descripción" onChange={handleChange} value={producto.descripcion} required />
      <select name="estado" onChange={handleChange} value={producto.estado}>
        <option value="ACTIVO">Activo</option>
        <option value="INACTIVO">Inactivo</option>
      </select>
      <input name="nombreLaboratorio" placeholder="Laboratorio" onChange={handleChange} value={producto.nombreLaboratorio} required />
      <button type="submit">Guardar Producto</button>
    </form>
  );
}

export default ProductoForm;
