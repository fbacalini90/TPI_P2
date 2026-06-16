/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import enums.Rol;
import java.util.ArrayList;
import java.util.List; 

//CLASE Usuario
//Representa un usuario dentro del sistema
public class Usuario extends Base {
    //Atributos
    private String nombre; //Nombre del usuario
    private String apellido; //Apellido del usuario
    private String mail; //E-Mail del usuario
    private String celular; //Número de celular del usuario
    private String contrasenia; //Contraseña de acceso
    private Rol rol; //Rol del usuario en el sistema
    private List<Pedido> pedidos; //Relación 1:N (un usuario puede tener muchos pedidos)    
    
    //Constructor
    public Usuario (String nombre,
                    String apellido,
                    String mail,
                    String celular,
                    String contrasenia,
                    Rol rol) {
        super(); //Llamada al constructor de Base
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contrasenia = contrasenia;
        this.rol = rol;
        
        this.pedidos = new ArrayList<>();
    }
    
    //Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    //toString
    @Override
    public String toString() {
        return "USUARIO | " +
                "ID: " + getId() + " | " +
                "Nombre: " + nombre + " | " +
                "Apellido: " + apellido + " | " +
                "E-Mail: " + mail + " | " +
                "Rol: " + rol;
    }
}
