/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

//CLASE EntidadNoEncontradaException
//Excepción utilizada cuando no se encuentra una entidad buscada mediante su ID u otro criterio de búsqueda
public class EntidadNoEncontradaException extends Exception{
    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
    } 
}
