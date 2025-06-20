import { useState } from "react";
import { getProductoById } from "../api/apiProducto.js";

function BuscarProducto() {
  const [id, setId] = useState("");
  const [producto, setProducto] = useState(null);

  const buscar = async () => {
    try {
      const res = await getProductoById(id);
      setProducto(res.data);
    } catch {
      setProducto(null);
      alert("Producto no encontrado");
    }
  };

  return (
    <div>
      <input placeholder="ID" value={id} onChange={(e) => setId(e.target.value)} />
      <button onClick={buscar}>Buscar</button>
      {producto && (
        <div>
          <p><b>Nombre:</b> {producto.nombre}</p>
          <p><b>Descripción:</b> {producto.descripcion}</p>
        </div>
      )}
    </div>
  );
}

export default BuscarProducto;
