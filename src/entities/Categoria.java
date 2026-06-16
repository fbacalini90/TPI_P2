/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

//CLASE Categoria
//Representa una categoría de productos dentro del sistema
public class Categoria extends Base {
    //Atributos
    private String nombre; //Nombre de la categoría
    private String descripcion; //Descripción de la categoría
    private List<Producto> productos; //Relación 1:N (una categoría puede tener muchos productos)
    
    //Constructor
    public Categoria(String nombre, String descripcion) {
        super(); //Llamada al constructor de Base
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = new ArrayList<>(); //Inicializa lista vacía 
    }
    
    //Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
    //toString
    @Override
    public String toString () {
        return "CATEGORÍA | " +
               "ID: " + getId() + " | " +
               "Nombre: " + nombre + " | " +
               "Descripción: " +  descripcion;  
    }
}
