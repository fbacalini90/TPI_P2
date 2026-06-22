/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

import entities.Categoria;
import entities.Producto;
import entities.Usuario;
import entities.Pedido;

import enums.Rol;
import enums.Estado;
import enums.FormaPago;

import services.CategoriaService;
import services.ProductoService;
import services.UsuarioService;
import services.PedidoService;

public class Main {
    //Scanner único para toda la aplicación
    private static final Scanner sc =
            new Scanner(System.in);
    
    //Services del sistema
    private static final CategoriaService categoriaService =
            new CategoriaService();
    
    private static final ProductoService productoService =
            new ProductoService();
    
    private static final UsuarioService usuarioService =
            new UsuarioService();
    
    private static final PedidoService pedidoService =
            new PedidoService();  
    
    //Despliegue de opciones del menú
    
    public static void main(String[] args) {
        int opcion;
        
        do {
            System.out.println("\n***SISTEMA DE PEDIDOS - FOOD STORE***\n");
            System.out.println("1. Categorías");
            System.out.println("2. Productos");
            System.out.println("3. Usuarios");
            System.out.println("4. Pedidos");
            System.out.println("0. Salir");
            
            opcion = leerEntero("\nSeleccione: ");
            
            switch (opcion) {
                case 1:
                    menuCategorias();
                    break;
                
                case 2:
                    menuProductos();
                    break;
                
                case 3:
                    menuUsuarios();
                    break;
                
                case 4:
                    menuPedidos();
                    break;
                
                case 0:
                    System.out.println("Saliendo del sistema.");
                    break;
                
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
    
    //MENÚ Categorías
    public static void menuCategorias() {
        int opcion;
        do {
        System.out.println("\n***CATEGORÍAS***\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
        
        opcion = leerEntero("\nSeleccione: ");
        
        switch (opcion) {
            case 1:
                listarCategorias();
                break;
            
            case 2:
                crearCategoria();
                break;
            
            case 3:
                editarCategoria();
                break;
            
            case 4:
                eliminarCategoria();
                break;
            
            case 0:
                break;
            
            default:
                System.out.println("Opción inválida.");
          }
        } while (opcion != 0);  
    }
    //Métodos
    //Listar categorías
    public static void listarCategorias() {
        if (categoriaService.listarCategorias().isEmpty()) {
            System.out.println("\nNo hay categorías registradas.");
            return;
        }
        System.out.println("\n***LISTADO DE CATEGORÍAS***");
        for (Categoria categoria :
                categoriaService.listarCategorias()) {
            System.out.println(categoria);
        }
    }
    //Crear categoría
    public static void crearCategoria() {
        try {
            System.out.print("Nombre de la categoría: ");
            String nombre = sc.nextLine();
            
            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();
            
            Categoria categoria =
                    categoriaService.crearCategoria(nombre, descripcion);
            System.out.println("\nCategoría creada correctamente.");
            System.out.println(categoria);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    //Editar categoría
    public static void editarCategoria() {
        try {
            System.out.print("ID de la categoría: ");
            Long id = Long.parseLong(sc.nextLine());
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nueva descripción: ");
            String descripcion = sc.nextLine();
            
            categoriaService.editarCategoria(
                    id,
                    nombre,
                    descripcion);
            
            System.out.println("\nCategoría modificada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }      
    //Eliminar categoría
    public static void eliminarCategoria() {
        try {
            System.out.print("ID de la categoría: ");
            Long id = Long.parseLong(sc.nextLine());
            
            System.out.print("¿Confirma la eliminación? (S/N): ");
            String confirmacion = sc.nextLine().toUpperCase();
            
            if(!confirmacion.equals("S")) {
                System.out.println("Operación cancelada.");
                return;
            }
            
            categoriaService.eliminarCategoria(id);
            
            System.out.println("\nCategoría eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }  
    
    //MENÚ Productos
    public static void menuProductos() {
        int opcion;        
        do {
        System.out.println("\n***PRODUCTOS***\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
        
        opcion = leerEntero("Seleccione: ");
        
          switch (opcion) {

            case 1:
                listarProductos();
                break;

            case 2:
                crearProducto();
                break;

            case 3:
                editarProducto();
                break;

            case 4:
                eliminarProducto();
                break;

            case 0:
                break;

            default:
                System.out.println("Opción inválida.");
        }
      } while (opcion != 0);    
    }
    //Métodos
    //Listar productos
    public static void listarProductos() {

    if (productoService.listarProductos().isEmpty()) {
        System.out.println("\nNo hay productos registrados.");
        return;
    }
    System.out.println("\n=== LISTADO DE PRODUCTOS ===");
    for (Producto producto : productoService.listarProductos()) {
        System.out.println(producto);
    }
}
    //Crear producto
    public static void crearProducto() {
         try {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Stock: ");
        int stock = Integer.parseInt(sc.nextLine());
        System.out.print("Imagen: ");
        String imagen = sc.nextLine();
        System.out.print("Disponible (true/false): ");
        boolean disponible =
                Boolean.parseBoolean(sc.nextLine());

        listarCategorias();

        System.out.print("ID Categoría: ");
        Long idCategoria =
                Long.parseLong(sc.nextLine());

        Categoria categoria =
                categoriaService.buscarPorId(idCategoria);

        Producto producto =
                productoService.crearProducto(
                        nombre,
                        precio,
                        descripcion,
                        stock,
                        imagen,
                        disponible,
                        categoria);

        System.out.println("\nProducto creado correctamente.");
        System.out.println(producto);

    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
        }
    }    
    //Editar producto
    public static void editarProducto() {
        try {
            System.out.print("ID del producto: ");
            Long id = Long.parseLong(sc.nextLine());
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.print("Nueva descripción: ");
            String descripcion = sc.nextLine();
            System.out.print("Nuevo stock: ");
            int stock = Integer.parseInt(sc.nextLine());
            System.out.print("Nueva imagen: ");
            String imagen = sc.nextLine();                    
            System.out.print("Disponible (true para disponible/false para no disponible): ");
            boolean disponible = Boolean.parseBoolean(sc.nextLine());
            
            listarCategorias();
            System.out.print("ID de la categoría: ");
            Long idCategoria = Long.parseLong(sc.nextLine());
            Categoria categoria = categoriaService.buscarPorId(idCategoria);
            
            productoService.editarProducto(
                        id,
                        nombre,
                        precio,
                        descripcion,
                        stock,
                        imagen,
                        disponible,
                        categoria);
            System.out.println("\nProducto modificado correctamente.");           
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }        
    }
    //Eliminar producto
    public static void eliminarProducto() {
        try {
            System.out.print("ID del producto: ");
            Long id = Long.parseLong(sc.nextLine());
            System.out.print("¿Confirma la eliminación? (S/N): ");
            String confirmacion = sc.nextLine().toUpperCase();
            
            if (!confirmacion.equals("S")) {
                System.out.println("Operación cancelada.");
                return;
            }
            
        productoService.eliminarProducto(id);
        System.out.println("\nProducto eliminado correctamente");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
            
    //MENÚ Usuarios
    public static void menuUsuarios() {
        int opcion;
        do {
        System.out.println("\n***USUARIOS***\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Editar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
        
        opcion = leerEntero("Seleccione: ");
        
        switch (opcion) {
            case 1:
                listarUsuarios();
                break;
            
            case 2:
                crearUsuario();
                break;
            
            case 3:
                editarUsuario();
                break;
            
            case 4:
                eliminarUsuario();
                break;
            
            case 0:
                break;
                
            default:
                System.out.println("Opción inválida.");
        }
    } while (opcion != 0);
  }
    //Métodos
    //Listar usuarios
    public static void listarUsuarios() {
        if (usuarioService.listarUsuarios().isEmpty()) {
            System.out.println("\nNo hay usuarios registrados.");
            return;
        }
        System.out.println("\n***LISTADO DE USUARIOS***");
        for (Usuario usuario : usuarioService.listarUsuarios()) {
            System.out.println(usuario);
        }
    }
    //Crear usuario
    public static void crearUsuario() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Mail: ");
            String mail = sc.nextLine();
            System.out.print("Celular: ");
            String celular = sc.nextLine();
            System.out.print("Contraseña: ");
            String contrasenia = sc.nextLine();
            System.out.print("Rol (ADMIN/USUARIO): ");
            Rol rol = Rol.valueOf(sc.nextLine().toUpperCase());
            
            Usuario usuario =
                    usuarioService.crearUsuario(
                            nombre,
                            apellido,
                            mail,
                            celular,
                            contrasenia,
                            rol);
            System.out.println("\nUsuario creado correctamente.");
            System.out.println(usuario);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    //Editar usuario
    public static void editarUsuario() {
        try {
            System.out.print("ID del usuario: ");
            Long id = Long.parseLong(sc.nextLine());
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Mail: ");
            String mail = sc.nextLine();
            System.out.print("Celular: ");
            String celular = sc.nextLine();
            System.out.print("Contraseña: ");
            String contrasenia = sc.nextLine();
            System.out.print("Rol (ADMIN/USUARIO): ");
            Rol rol = Rol.valueOf(sc.nextLine().toUpperCase());
            
            usuarioService.editarUsuario(
                    id,
                    nombre,
                    apellido,
                    mail,
                    celular,
                    contrasenia,
                    rol);
            System.out.println("\nUsuario modificado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    //Eliminar usuario
    public static void eliminarUsuario() {
        try {
            System.out.print("ID del usuario: ");
            Long id = Long.parseLong(sc.nextLine());
            System.out.print("¿Confirma la eliminación? (S/N): ");
            String confirmacion = sc.nextLine().toUpperCase();
            
            if (!confirmacion.equals("S")) {
                System.out.println("Operación cancelada.");
                return;
            }
            
            usuarioService.eliminarUsuario(id);
            
            System.out.println("\nUsuario eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
    //MENÚ Pedidos
    public static void menuPedidos() {
        int opcion;
        
        do {
        System.out.println("\n***PEDIDOS***\n");
        System.out.println("1. Listar");
        System.out.println("2. Crear");
        System.out.println("3. Cambiar Estado/Forma de Pago");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");
        
        opcion = leerEntero("Seleccione: ");
        
        switch (opcion) {
            case 1:
                listarPedidos();
                break;
            
            case 2:
                crearPedido();
                break;
            
            case 3:
                actualizarPedido();
                break;
            
            case 4:
                eliminarPedido();
                break;
            
            case 0:
                break;
             
            default:
                System.out.println("Opción inválida.");
        }
    } while (opcion != 0);
 }
    //Listar pedidos
    public static void listarPedidos() {
        if (pedidoService.listarPedidos().isEmpty()) {
            System.out.println("\nNo hay pedidos registrados.");
            return;
        }
        System.out.println("\n***LISTADO DE PEDIDOS***");
        for (Pedido pedido : pedidoService.listarPedidos()) {
            System.out.println(pedido);
        }
    }
    //Crear pedido
    public static void crearPedido() {
        
        Pedido pedido = null;
        
        try {
            listarUsuarios();
            
            System.out.print("ID del usuario: ");
            Long idUsuario = Long.parseLong(sc.nextLine());
            Usuario usuario = usuarioService.buscarPorId(idUsuario);            
            System.out.print("Estado del pedido (PENDIENTE/CONFIRMADO/TERMINADO/CANCELADO): ");
            Estado estado = Estado.valueOf(sc.nextLine().toUpperCase());            
            System.out.print("Forma de Pago (EFECTIVO/TARJETA/TRANSFERENCIA): ");
            FormaPago formaPago = FormaPago.valueOf(sc.nextLine().toUpperCase());
            
            pedido =
                    pedidoService.crearPedido(
                            usuario, 
                            estado, 
                            formaPago);
            String continuar;
            
            do {
                listarProductos();
                
                System.out.print("ID del producto: ");
                Long idProducto = Long.parseLong(sc.nextLine());
                Producto producto = productoService.buscarPorId(idProducto);
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(sc.nextLine());
                
                pedidoService.agregarDetalle(
                        pedido, 
                        producto, 
                        cantidad);
                
                System.out.print("¿Agregar otro producto? (S/N): ");
                continuar = sc.nextLine().toUpperCase();
            } while (continuar.equals("S"));
            
            System.out.println("\nPedido creado correctamente.");
            System.out.println(pedido);            
        } catch (Exception e) {
            if (pedido != null) {
                pedidoService.getPedidos().remove(pedido);
            }
           System.out.println("ERROR: " + e.getMessage());
        }
    }
    //Actualizar estado o cambiar forma de pago del pedido
    public static void actualizarPedido() {
        try {
            listarPedidos();
            
            System.out.print("ID del pedido: ");
            Long id = Long.parseLong(sc.nextLine());
            
            System.out.println("\nESTADOS DISPONIBLES");
            System.out.println("1. PENDIENTE");
            System.out.println("2. CONFIRMADO");
            System.out.println("3. TERMINADO");
            System.out.println("4. CANCELADO");
            
            System.out.println("Seleccione estado: ");
            int opEstado = Integer.parseInt(sc.nextLine());
            
            Estado estado;
            
            switch (opEstado) {
                case 1:
                    estado = Estado.PENDIENTE;
                    break;
                
                case 2:
                    estado = Estado.CONFIRMADO;
                    break;                    
                    
                case 3:
                    estado = Estado.TERMINADO;
                    break;                   
                    
                case 4:
                    estado = Estado.CANCELADO;
                    break;
                    
                default:
                    System.out.println("Opción inválida");
                    return;
            }
            
            pedidoService.cambiarEstado(id, estado);
            
            System.out.println("\nFORMAS DE PAGO");
            System.out.println("1. EFECTIVO");
            System.out.println("2. TARJETA");
            System.out.println("3. TRANSFERENCIA");
            System.out.print("Seleccione la forma de pago: ");
            int opPago = Integer.parseInt(sc.nextLine());
            
            FormaPago formaPago;
            
            switch (opPago) {
                case 1:
                    formaPago = FormaPago.EFECTIVO;
                    break;
                    
                case 2:
                    formaPago = FormaPago.TARJETA;
                    break;
                
                case 3:
                    formaPago = FormaPago.TRANSFERENCIA;
                    break;
                
                default:
                    System.out.println("Opción inválida.");
                    return;        
            }
            
            pedidoService.cambiarFormaPago(id, formaPago);
            System.out.println("\nPedido actualizado correctamente.");
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    //Eliminar pedido
    public static void eliminarPedido() {
        try {
            listarPedidos();
            
            System.out.print("ID del pedido: ");
            Long id = Long.parseLong(sc.nextLine());
            System.out.print("¿Confirma la eliminación? (S/N): ");
            String confirmacion = sc.nextLine().toUpperCase();
            
            if (!confirmacion.equals("S")) {
                System.out.println("Operación cancelada.");
                return;
            }
            
            pedidoService.eliminarPedido(id);
            
            System.out.println("\nPedido eliminado correctamente");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    // Validar entrada
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }

            System.out.println("ERROR: Debe ingresar solo números.");
        }
    }
}