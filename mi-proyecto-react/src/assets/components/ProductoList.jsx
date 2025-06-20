import { useEffect, useState } from "react";
import { getProductos, deleteProducto } from "../api/apiProducto.js";


function ProductoList() {
  const [productos, setProductos] = useState([]);

  const loadProductos = async () => {
    const res = await getProductos();
    setProductos(res.data);
  };

  const handleDelete = async (id) => {
    await deleteProducto(id);
    loadProductos();
  };

  useEffect(() => {
    loadProductos();
  }, []);

  return (
    <div>
      <h2>Listado de Productos</h2>
      <ul>
        {productos.map((p) => (
          <li key={p.id}>
            {p.nombre} - {p.codigo} - {p.estado}
            <button onClick={() => handleDelete(p.id)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ProductoList;
