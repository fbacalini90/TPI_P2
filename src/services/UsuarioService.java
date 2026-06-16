/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Usuario;
import enums.Rol;
import exceptions.DatoInvalidoException;
import exceptions.EntidadNoEncontradaException;
import exceptions.MailDuplicadoException;

import java.util.ArrayList;
import java.util.List;

//CLASE UsuarioService
//Service encargado de gestionar a los usuarios del sistema
public class UsuarioService {
    //Colección en memoria
    private List<Usuario> usuarios;
    
    //Constructor
    public UsuarioService() {
        usuarios = new ArrayList<>();
    }
    
    //Crear usuario
    public Usuario crearUsuario(String nombre,
                                String apellido,
                                String mail,
                                String celular,
                                String contrasenia,
                                Rol rol)
            throws DatoInvalidoException,
                   MailDuplicadoException {
        //Validación del nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException(
                   "El nombre no puede estar vacío.");
        }
        //Validación del apellido
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new DatoInvalidoException(
                   "El apellido no puede estar vacío.");
        }
        //Validación del mail
        if (mail == null || mail.trim().isEmpty()) {
            throw new DatoInvalidoException(
                   "El mail no puede estar vacío.");
        }
        //Validación de mail duplicado
        for (Usuario usuario : usuarios) {
            if (!usuario.isEliminado()
                    && usuario.getMail()
                        .equalsIgnoreCase(mail.trim())) {
                throw new MailDuplicadoException(
                        "Ya existe un usuario con este mail.");
            }
        }
        
        Usuario usuario =
                new Usuario(nombre.trim(),
                            apellido.trim(),
                            mail.trim(),
                            celular,
                            contrasenia,
                            rol);
        usuarios.add(usuario);
        return usuario;
    }
    
    //Listar usuarios activos
    public List<Usuario> listarUsuarios() {
        List<Usuario> activos =
                new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (!usuario.isEliminado()) {
                activos.add(usuario);
            }
        }
        return activos;
    }
    
    //Búsqueda de usuario por ID
    public Usuario buscarPorId(Long id)
            throws EntidadNoEncontradaException {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)
                    && !usuario.isEliminado()) {
                return usuario;
            }
        }
        throw new EntidadNoEncontradaException(
                "No existe un usuario con ID " + id + ".");
    }
    
    //Editar usuario existente
    public void editarUsuario(Long id,
                              String nombre,
                              String apellido,
                              String mail,
                              String celular,
                              String contrasenia,
                              Rol rol)
            throws EntidadNoEncontradaException,
                   DatoInvalidoException,
                   MailDuplicadoException {
        Usuario usuario =
                buscarPorId(id);
        //Validar nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException(
                "El nombre no puede estar vacío.");
        }
        //Validar apellido
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new DatoInvalidoException(
                "El apellido no puede estar vacío.");
        }
        //Validar mail
        if (mail == null || mail.trim().isEmpty()) {
            throw new DatoInvalidoException(
                "El mail no puede estar vacío.");
        }
        //Validar mail duplicado
        for (Usuario u : usuarios) {
            if (!u.getId().equals(id)
                    && !u.isEliminado()
                    && u.getMail()
                        .equalsIgnoreCase(mail.trim())) {
                throw new MailDuplicadoException(
                        "Ya existe un usuario con ese mail.");
            }
        }
        
        usuario.setNombre(nombre.trim());
        usuario.setApellido(apellido.trim());
        usuario.setMail(mail.trim());
        usuario.setCelular(celular);
        usuario.setContrasenia(contrasenia);
        usuario.setRol(rol);        
    }
    
    //Baja lógica
    public void eliminarUsuario(Long id)
            throws EntidadNoEncontradaException {
        Usuario usuario =
                buscarPorId(id);
        usuario.setEliminado(true);
    }
    
    //Devolución de colección completa
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
