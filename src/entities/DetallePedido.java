/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

//CLASE DetallePedido
//Representa un detalle dentro de un pedido, referenciando un producto y cantidad determinada
public class DetallePedido extends Base {
    //Atributos
    private int cantidad; //Cantidad solicitada del producto
    private double subtotal; //Subtotal del detalle
    private Producto producto; //Relación N:1 (muchos detalles pueden referenciar al mismo producto)
    
    //Constructor
    public DetallePedido(int cantidad,
                         Producto producto) {
        super(); //Llamada al constructor de Base
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = cantidad * producto.getPrecio(); //Cálculo automático del subtotal
    }
    
    //Método para cálculo del subtotal
    public double calcularSubtotal() {
        if (producto == null) {
            return 0;
        }
        return cantidad * producto.getPrecio();
    }
    
    //Getters & Setters
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal (double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    //toString
    @Override
    public String toString() {
        return "DETALLE PEDIDO | " +
               "ID: " + getId() + " | " + 
               "Producto: " + producto.getNombre() + " | " + 
               "Cantidad: " + cantidad + " | " + 
               "Subtotal: $" + subtotal;  
    }
}
