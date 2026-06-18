/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

//CLASE DatoInvalidoException
//Excepción utilizada cuando un dato ingresado no cumple las validaciones del sisteme
public class DatoInvalidoException extends Exception {
        public DatoInvalidoException(String mensaje) {
            super(mensaje);
        }
}
