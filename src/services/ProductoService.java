/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Categoria;
import entities.Producto;
import exceptions.DatoInvalidoException;
import exceptions.EntidadNoEncontradaException;

import java.util.ArrayList;
import java.util.List;

//CLASE ProductoService
//Service encargado de la gestión de productos del sistema
public class ProductoService {
    //Colección en memoria
    private List<Producto> productos;
    
    //Constructor
    public ProductoService () {
        productos = new ArrayList<>();
    }
    
    //Creación de un producto
    public Producto crearProducto(String nombre,
                                  double precio,
                                  String descripcion,
                                  int stock,
                                  String imagen,
                                  boolean disponible,
                                  Categoria categoria)
            throws DatoInvalidoException {
        
        //Validación del nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException(
                "El nombre del producto no puede estar vacío.");
        }
        //Validación del precio
        if (precio < 0) {
            throw new DatoInvalidoException(
                "El precio no puede ser negativo.");
        }
        //Validación del stock
        if (stock < 0) {
            throw new DatoInvalidoException(
                "El stock no puede ser negativo.");
        }
        //Validación de la categoría
        if (categoria == null || categoria.isEliminado()) {
            throw new DatoInvalidoException (
                "La categoría seleccionada no es válida.");
        }
        
        Producto producto =
                new Producto(nombre.trim(),
                             precio,
                             descripcion,
                             stock,
                             imagen,
                             disponible,
                             categoria);
        productos.add(producto);
        
        //Manutención de la relación Categoria -> Producto
        categoria.agregarProducto(producto);
        return producto;
    }
    
    //Listar productos activos
    public List<Producto> listarProductos() {
        List<Producto> activos =
                new ArrayList<>();
        for (Producto producto : productos) {
            if (!producto.isEliminado()) {
                activos.add(producto);
            }
        }
        return activos;
    }
    
    //Buscar producto por ID
    public Producto buscarPorId(Long id)
            throws EntidadNoEncontradaException {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)
                && !producto.isEliminado()) {
                return producto;
            }
        }
        throw new EntidadNoEncontradaException(
                "No existe un producto con el ID " + id + ".");
            }
    
    //Editar producto
    public void editarProducto(Long id,
                               String nombre,
                               double precio,
                               String descripcion,
                               int stock,
                               String imagen,
                               boolean disponible,
                               Categoria categoria)
            throws EntidadNoEncontradaException,
                   DatoInvalidoException {
        Producto producto =
                buscarPorId(id);
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException(
                    "El nombre no puede estar vacío.");
        }
        if (precio < 0) {
            throw new DatoInvalidoException(
                    "El precio no puede ser negativo.");
        }
        if (stock < 0) {
            throw new DatoInvalidoException(
                    "El stock no puede ser negativo");
        }
        if (categoria == null || categoria.isEliminado()) {
            throw new DatoInvalidoException(
                    "La categoría seleccionada no es válida");
        }
        producto.setNombre(nombre.trim());
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setStock(stock);
        producto.setImagen(imagen);
        producto.setDisponible(disponible);
        producto.setCategoria(categoria);
    }
    
    //Baja lógica
    public void eliminarProducto(Long id)
            throws EntidadNoEncontradaException {
        Producto producto =
                buscarPorId(id);
        producto.setEliminado(true);
    }
    
    //Obtener colección completa
    public List<Producto> getProductos() {
        return productos;
    }
}
