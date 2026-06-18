/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Pedido;    
import entities.Producto;   
import entities.Usuario;
import entities.DetallePedido;
import enums.Estado;
import enums.FormaPago;
import exceptions.DatoInvalidoException;
import exceptions.EntidadNoEncontradaException;
import exceptions.StockInsuficienteException;

import java.util.ArrayList;
import java.util.List;

//CLASE PedidoService
//Service encargado de la gestión de pedidos del sistema
public class PedidoService {
    //Colección en memoria
    private List<Pedido> pedidos;
    
    //Constructor
    public PedidoService() {
        pedidos = new ArrayList<>();
    }
    
    //Creación de pedido
    public Pedido crearPedido(Usuario usuario,
                              Estado estado,
                              FormaPago formaPago)
            throws DatoInvalidoException {
        //Validar usuario
        if (usuario == null || usuario.isEliminado()) {
            throw new DatoInvalidoException(
                    "El usuario seleccionado no es válido."); 
        }
        
        Pedido pedido =
                new Pedido(usuario,
                           estado,
                           formaPago);
        pedidos.add(pedido);
        return pedido;
    }
    
    //Agregar detalle a un pedido
    public void agregarDetalle(Pedido pedido,
                               Producto producto,
                               int cantidad)
            throws DatoInvalidoException,
                   StockInsuficienteException {
        //Validación del pedido
        if (pedido == null) {
            throw new DatoInvalidoException(
                    "El pedido no puede estar vacío.");
        }
        //Validación del producto
        if (producto == null || producto.isEliminado()) {
            throw new DatoInvalidoException(
                    "El producto seleccionado no es válido.");
        }
        //Validar cantidad
        if (cantidad <= 0) {
            throw new DatoInvalidoException(
                    "La cantidad debe ser un número positivo");
        }
        //Validar stock
        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException(
                    "El stock de " + producto.getNombre() + " es insuficiente para procesar el pedido.");
        }
        
        //Agregar detalle
        pedido.addDetallePedido(cantidad, 
                                producto);
        //Descontar stock
        producto.setStock(
                producto.getStock() - cantidad);
    }
    
    //Listado de pedidos activos
    public List<Pedido> listarPedidos() {
        List<Pedido> activos =
                new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.isEliminado()) {
                activos.add(pedido);
            }
        }
        return activos;
    }
    
    //Búsqueda de pedido por ID
    public Pedido buscarPorId(Long id)
                throws EntidadNoEncontradaException {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)
                    && !pedido.isEliminado()) {
                return pedido;
            }
        }
        throw new EntidadNoEncontradaException(
                "No existe un pedido con el ID " + id + ".");
    }
    
    //Cambio de estado de un pedido
    public void cambiarEstado(Long id,
                              Estado nuevoEstado)
            throws EntidadNoEncontradaException {
        Pedido pedido =
                buscarPorId(id);
        pedido.setEstado(nuevoEstado);
    }
    
    //Cambio de forma de pago
    public void cambiarFormaPago(Long id,
                                 FormaPago formaPago)
            throws EntidadNoEncontradaException {
        Pedido pedido =
                buscarPorId(id);
        pedido.setFormaPago(formaPago);
    }
    
    //Baja lógica
    public void eliminarPedido(Long id)
            throws EntidadNoEncontradaException {
        Pedido pedido =
                buscarPorId(id);
        pedido.eliminarDetalles();                
        pedido.setEliminado(true);
    }
    
    //Obtener colección completa
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
