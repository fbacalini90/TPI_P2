Food Store - Sistema de Gestión de Pedidos
Descripción General

Food Store es una aplicación de consola desarrollada en Java que permite gestionar el funcionamiento básico de una tienda de alimentos mediante la administración de categorías, productos, usuarios y pedidos.
El sistema fue diseñado aplicando los principios de Programación Orientada a Objetos (POO), incorporando conceptos como herencia, encapsulamiento, asociaciones entre clases, composición, interfaces, enumeraciones y manejo de excepciones personalizadas.
Toda la información se almacena en memoria mediante colecciones (ArrayList), permitiendo simular el comportamiento de un sistema de gestión sin necesidad de utilizar una base de datos.

Objetivos del Proyecto

El objetivo principal fue desarrollar una aplicación que permita:

Administrar categorías de productos.
Gestionar productos y su stock.
Registrar usuarios con distintos roles.
Crear pedidos asociados a usuarios.
Incorporar múltiples productos a cada pedido.
Calcular automáticamente subtotales y totales.
Aplicar validaciones y reglas de negocio.
Implementar bajas lógicas para preservar la información.
Arquitectura del Sistema

El proyecto se encuentra organizado en paquetes según su responsabilidad.

/entities

Contiene las entidades principales del dominio:

Base
Categoria
Producto
Usuario
Pedido
DetallePedido

Estas clases representan los objetos reales con los que trabaja el sistema.

/services

Contiene la lógica de negocio:

CategoriaService
ProductoService
UsuarioService
PedidoService

Los servicios realizan validaciones, búsquedas, modificaciones y coordinan las operaciones entre entidades.

/enums

Contiene las enumeraciones utilizadas por el sistema:

Rol
Estado
FormaPago

/interfaces

Contiene la interfaz:

Calculable

Implementada por la clase Pedido para calcular automáticamente el total del pedido.

/exceptions

Contiene excepciones personalizadas utilizadas para controlar errores y validar reglas de negocio.

Main

Punto de entrada de la aplicación. Gestiona la interacción con el usuario mediante menús en consola y delega la lógica correspondiente a cada servicio.

Modelo de Dominio
Base

Clase abstracta de la cual heredan todas las entidades.

Contiene:

ID autogenerado
Fecha de creación
Estado de eliminación lógica

Gracias a esta clase se evita duplicar atributos comunes.

Categoria

Representa una clasificación de productos.

Cada categoría posee:

Nombre
Descripción

Una categoría puede contener múltiples productos.

Producto

Representa un artículo disponible para la venta.

Cada producto posee:

Nombre
Precio
Descripción
Stock
Imagen
Disponibilidad
Categoría asociada

Un producto pertenece a una única categoría.

Usuario

Representa una persona registrada en el sistema.

Cada usuario posee:

Nombre
Apellido
Correo electrónico
Celular
Contraseña
Rol

Un usuario puede generar múltiples pedidos.

Pedido

Representa una compra realizada por un usuario.

Cada pedido posee:

Fecha de creación
Estado
Forma de pago
Total
Usuario asociado
Lista de detalles

El total se calcula automáticamente mediante la interfaz Calculable.

DetallePedido

Representa cada línea de un pedido.

Cada detalle contiene:

Producto
Cantidad
Subtotal

El subtotal se calcula automáticamente multiplicando la cantidad por el precio del producto.

Funcionamiento del Sistema
Gestión de Categorías

Permite:

Crear categorías.
Listar categorías activas.
Modificar información existente.
Eliminar categorías mediante baja lógica.

El sistema valida:

Nombre obligatorio.
Descripción obligatoria.
Nombres duplicados.
Gestión de Productos

Permite:

Registrar productos.
Consultar productos existentes.
Modificar información.
Eliminar productos mediante baja lógica.

Validaciones implementadas:

Nombre obligatorio.
Precio mayor que cero.
Stock válido.
Categoría existente.
Control de productos duplicados.
Gestión de Usuarios

Permite:

Crear usuarios.
Modificar usuarios.
Consultar usuarios registrados.
Eliminar usuarios mediante baja lógica.

Validaciones implementadas:

Campos obligatorios.
Control de datos inválidos.
Gestión mediante roles definidos por enumeración.
Gestión de Pedidos

Permite:

Crear pedidos asociados a usuarios.
Seleccionar forma de pago.
Seleccionar estado inicial.
Incorporar múltiples productos.
Calcular automáticamente subtotales y total.

Durante la creación del pedido el usuario puede agregar tantos productos como desee utilizando la opción de confirmación:

"S" para continuar agregando productos.

"N" para finalizar la carga.

Control de Stock

Cuando un producto es agregado a un pedido:

Se valida la existencia del producto.
Se verifica que exista stock suficiente.
Se genera el detalle correspondiente.
Se descuenta automáticamente el stock utilizado.

Si el stock disponible es insuficiente se lanza una excepción personalizada.

Actualización de Pedidos

El sistema permite:

Cambiar estado del pedido.
Modificar forma de pago.

Los cambios se realizan mediante búsquedas por ID.

Bajas Lógicas

La eliminación de entidades no elimina físicamente los objetos.

En su lugar:

Se marca el atributo eliminado como verdadero.
Los listados ignoran automáticamente los registros eliminados.

Esto permite conservar la información histórica del sistema.

Manejo de Excepciones

Se implementaron excepciones personalizadas para controlar errores frecuentes:

DatoInvalidoException
EntidadNoEncontradaException
StockInsuficienteException

Estas excepciones permiten mostrar mensajes claros al usuario sin interrumpir la ejecución del programa.

Validaciones Adicionales

Se incorporaron validaciones de entrada en los menús para evitar errores producidos por el ingreso de datos incorrectos.

De esta manera el sistema continúa ejecutándose aun cuando el usuario ingrese caracteres inválidos en opciones numéricas.

Tecnologías Utilizadas
Java
Programación Orientada a Objetos
GitHub
NetBeans

Integrantes
Bruno Asencio
Francisco Bacalini

Link al video explicativo: https://youtu.be/VCXK15xlth8
Informe PDF adjunto en la carpeta raíz del proyecto
