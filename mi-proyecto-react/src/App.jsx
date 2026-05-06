import ProductoForm from "./assets/components/ProductoForm";
import ProductoList from "./assets/components/ProductoList";
import BuscarProducto from "./assets/components/BuscarProducto";


function App() {
  return (
    <div className="app-container">
      <header className="app-header">
        <h1>Gestión de Productos</h1>
        <p className="subtitle">Administración de inventario y recepciones</p>
      </header>
      
      <div className="grid-layout">
        <section className="card form-section">
          <h2>Nuevo Producto</h2>
          <ProductoForm onCreated={() => window.location.reload()} />
        </section>

        <section className="card search-section">
          <h2>Buscar Producto</h2>
          <BuscarProducto />
        </section>
      </div>

      <section className="card list-section">
        <ProductoList />
      </section>
    </div>
  );
}

export default App;
