package entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;

//CLASE ABSTRACTA Base
//Base del sistema. Todas las entidades heredan de esta clase, reutilizando atributos comunes
public class Base {
    //Atributos
    private Long id; //Identificador único
    private static Long contadorId = 0L; //Contador estático por todas las entidades para generar IDs automáticos
    private boolean eliminado; //Baja lógica 
    private LocalDateTime createdAt; //Fecha de creación del objeto
    
    //Constructor base para ejecución automáticva cuando una clase hija utiliza super()
    public Base() {
        contadorId++; //Incrementa el contador
        this.id = contadorId; //Asignación automática de ID
        this.eliminado = false; //Por defecto el objeto no se considera eliminado
        this.createdAt = LocalDateTime.now(); //Fecha actual del sistema
    }
    //Getters & Setters
    public Long getId() {
        return id;
    }
    
    public boolean isEliminado() {
        return eliminado;
    }
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }    
}
