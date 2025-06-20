import axios from "axios";

const API_URL = "http://localhost:8080/api/producto";

export const createProducto = (producto) =>
  axios.post(`${API_URL}/guardarProducto`, producto);

export const getProductoById = (id) =>
  axios.get(`${API_URL}/${id}`);

export const getProductos = () =>
  axios.get(`${API_URL}/listarProductos`);

export const deleteProducto = (id) =>
  axios.delete(`${API_URL}/${id}`);

