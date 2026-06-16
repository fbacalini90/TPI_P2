/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

//CLASE Producto
//Representa un producto del catálogo dentro del sistema

public class Producto extends Base {
    //Atributos
    private String nombre; //Nombre del producto
    private double precio; //Precio unitario del producto
    private String descripcion; //Descripción del producto
    private int stock; //Cantidad disponible del producto
    private String imagen; //Ruta o nombre de la imagen
    private boolean disponible; //Disponibilidad del producto para venta
    private Categoria categoria; //Relación 1:N (muchos productos pueden pertenecer a una categoría)
    
    //Constructor
    public Producto(String nombre,
                    double precio,
                    String descripcion,
                    int stock,
                    String imagen,
                    boolean disponible,
                    Categoria categoria) {
        super(); //Llamada al constructor de Base
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
        this.categoria = categoria;
    }
    
    //Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    //toString
    @Override
    public String toString() {
        return "PRODUCTO | " +
               "ID: " + getId() + " | " +
               "Nombre: " + nombre + " | " +
               "Precio: $" + precio + " | " +
               "Stock: " + stock + " | " +
               "Categoría: " + categoria.getNombre();
    }
}
