/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import enums.Estado;
import enums.FormaPago;
import interfaces.Calculable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//CLASE Pedido
//Representa un pedido, implementando la interfaz Calculable para obtener el total a partir de sus detalles
public class Pedido extends Base implements Calculable {
    //Atributos
    private LocalDate fecha; //Fecha del pedido
    private Estado estado; //Estado del pedido
    private double total; //Total del pedido
    private FormaPago formaPago; //Forma de pago elegida
    private Usuario usuario; //Relación N:1 (muchos pedidos pueden pertenecer al mismo usuario)
    private List<DetallePedido> detalles; //Composición 1:N (un pedido puede contener más de un detalle)
    
    //Constructor
    public Pedido(Usuario usuario,
                 Estado estado,
                 FormaPago formaPago) {
        super(); //Llamada al constructor de Base
        
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.total = 0;
        this.detalles = new ArrayList<>();
        
    //Manutención de la relación Usuario -> Pedido
        usuario.agregarPedido(this);
    }
    
    //Agregar un detalle al pedido, con cálculo de subtotal dentro de DetallePedido
    public void addDetallePedido(int cantidad,
                                 Producto producto) {
        DetallePedido detalle =
                new DetallePedido(cantidad, producto);
        detalles.add(detalle);
        //Recálculo del total
        calcularTotal();
    }
    
    //Búsqueda de un detalle asociado a un producto
    public DetallePedido findDetallePedidoByProducto(
            Producto producto) {
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto()
                    .getId()
                    .equals(producto.getId())) {
                return detalle;
            }
        }
        return null;
    }
    
    //Eliminación de un detalle asociado a un producto
    public void deleteDetallePedidoByProducto(
            Producto producto) {
        DetallePedido detalle =
                findDetallePedidoByProducto(producto);
        if (detalle != null) {
            detalles.remove(detalle);
            calcularTotal();
        }
    }
    
    //Implementación obligatoria de la interfaz Calculable
    @Override
    public void calcularTotal() {
        total = 0;
        for (DetallePedido detalle : detalles) {
            total += detalle.getSubtotal();
        }
    }
    
    //Getters & Setters
    public LocalDate getFecha() {
        return fecha;
    }
    
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    } 
    
    public double getTotal() {
        return total;
    }
    
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<DetallePedido> getDetalles() {
        return detalles;
    }
    
    //toString
    @Override
    public String toString() {
        return "PEDIDO | " +
               "ID: " + getId() + " | " + 
               "Usuario: " + usuario.getNombre() + " " + usuario.getApellido() + " | " + 
               "Estado: " + estado + " | " +
               "Forma de Pago: " + formaPago + " | " + 
               "Total: $" + total + " | " + 
               "Fecha: " + fecha; 
    }
}
