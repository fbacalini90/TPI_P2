/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Categoria;
import exceptions.DatoInvalidoException;
import exceptions.EntidadNoEncontradaException;

import java.util.ArrayList;
import java.util.List;

//CLASE CategoriaService
//Service encargado de la gestión de las categorías del sistema
public class CategoriaService {
    //Colección en memoria
    private List<Categoria> categorias;
    
    //Constructor
    public CategoriaService() {
        categorias = new ArrayList<>();
    }
    
    //Creación de una nueva categoría
    public Categoria crearCategoria(String nombre,
                                    String descripcion)
            throws DatoInvalidoException {
        //Validar nombre vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException(
                    "El nombre de la categoría no puede estar vacío.");
        }
        //Validar descripción vacía
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new DatoInvalidoException(
                    "La descripción no puede estar vacía.");
        }
        //Validar nombre duplicado
        for (Categoria categoria : categorias) {
            if (!categoria.isEliminado()
                    && categoria.getNombre()
                    .equalsIgnoreCase(nombre.trim())) {
                throw new DatoInvalidoException(
                        "Ya existe una categoría con ese nombre.");
            }
        }
        
        Categoria categoria =
                new Categoria(nombre, descripcion);
        categorias.add(categoria);
        return categoria;
    }
    
    //Listado de categorías activas
    public List<Categoria> listarCategorias() {
        List<Categoria> activas =
                new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (!categoria.isEliminado()) {
                activas.add(categoria);
            }
        }
        return activas;
    }
    
    
    //Búsqueda de categoría por ID
    public Categoria buscarPorId(Long id)
            throws EntidadNoEncontradaException {
        for (Categoria categoria : categorias) {
            if (categoria.getId().equals(id)
                    && !categoria.isEliminado()) {
                return categoria;
            }
        }
        throw new EntidadNoEncontradaException(
                "No existe una categoría con el ID " + id);
    }
    
    //Modificación de una categoría existente
    public void editarCategoria(Long id,
                                String nuevoNombre,
                                String nuevaDescripcion)
            throws EntidadNoEncontradaException,
                   DatoInvalidoException {
        Categoria categoria =
                buscarPorId(id);
        //Validación de nombre vacío
        if (nuevoNombre == null
                || nuevoNombre.trim().isEmpty()) {
            throw new DatoInvalidoException(
                    "El nombre no puede estar vacío.");
        }
        //Validación de descripción vacía
        if (nuevaDescripcion == null
                || nuevaDescripcion.trim().isEmpty()) {
            throw new DatoInvalidoException(
                    "La descripción no puede estar vacía.");
        }
        //Validación de duplicados
        for (Categoria c : categorias) {
            if (!c.getId().equals(id)
                && !c.isEliminado()
                && c.getNombre()
                .equalsIgnoreCase(nuevoNombre)) {
            throw new DatoInvalidoException(
                    "Ya existe una categoría con ese nombre.");    
        }
    }
    categoria.setNombre(nuevoNombre.trim());
    categoria.setDescripcion(nuevaDescripcion.trim());
    }
    
    //Baja lógica
    public void eliminarCategoria(Long id)
            throws EntidadNoEncontradaException {
        Categoria categoria =
                buscarPorId(id);
        categoria.setEliminado(true);
    }
    
    //Devolución de la colección completa
    public List<Categoria> getCategorias() {
        return categorias;
    }
}
