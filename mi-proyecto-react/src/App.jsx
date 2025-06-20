import ProductoForm from "./assets/components/ProductoForm";
import ProductoList from "./assets/components/ProductoList";
import BuscarProducto from "./assets/components/BuscarProducto";


function App() {
  return (
    <div>
      <h1>Gestión de Productos</h1>
      <ProductoForm onCreated={() => window.location.reload()} />
      <BuscarProducto />
      <ProductoList />
    </div>
  );
}

export default App;
