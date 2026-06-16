/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

//CLASE MailDuplicadoException
//Excepción utilizada cuando se intenta registrar un mail ya existente en el sistema
public class MailDuplicadoException extends Exception {
    public MailDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
