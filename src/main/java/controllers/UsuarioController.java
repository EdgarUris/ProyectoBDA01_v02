/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.UsuarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Usuario;

/**
 *
 * @author EdgarUrias
 */
public class UsuarioController{
    
    private final UsuarioDAO userDAO;
    
    public UsuarioController(){
        userDAO = new UsuarioDAO();
    }
    
    public boolean agregar(String nombre, String correo, String telefono){
        if(nombre == null || nombre.trim().isEmpty()){
            System.err.println("Error: El nombre del usuario no puede ser nulo");
            return false;
        }
        if(correo == null || correo.trim().isEmpty()){
            System.err.println("Error: El correo del usuario no puede ser nulo");
            return false;
        }
        if(telefono == null || telefono.trim().isEmpty()){
            System.err.println("Error: El telefono del usuario no puede ser nulo");
            return false;
        }
        
        Usuario u = new Usuario();
        u.setNombre(nombre.trim());
        u.setCorreoElectronico(correo.trim());
        u.setTelefono(telefono.trim());
        return userDAO.insertar(u);
    }
    
    public Usuario obtenerUsuario(int idUsuario) {
        if (idUsuario <= 0) {
            System.err.println("ID de usuario inválido.");
            return null;
        }
        return userDAO.obtenerPorId(idUsuario);
    }
    
    public List<Usuario> listarUsuarios() {
        return userDAO.obtenerTodos();
    }

    public boolean actualizarUsuario(String nombre, String correo, String telefono) {
        if(nombre == null || nombre.trim().isEmpty()){
            System.err.println("Error: El nombre del usuario no puede ser nulo");
            return false;
        }
        if(correo == null || correo.trim().isEmpty()){
            System.err.println("Error: El correo del usuario no puede ser nulo");
            return false;
        }
        if(telefono == null || telefono.trim().isEmpty()){
            System.err.println("Error: El telefono del usuario no puede ser nulo");
            return false;
        }
        
        Usuario u = new Usuario();
        u.setNombre(nombre.trim());
        u.setCorreoElectronico(correo.trim());
        u.setTelefono(telefono.trim());
        return userDAO.actualizar(u);
    }
    
    public boolean eliminarUsuario(int idUsuario) {
        if (idUsuario <= 0) {
            System.err.println("ID de usuario inválido.");
            return false;
        }
        return userDAO.eliminar(idUsuario);
    }
    
    public DefaultTableModel obtenerTablaUsuarios() {
        String[] columnas = {"ID", "NOMBRE", "CORREO", "TELEFÓNO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Usuario> lista = userDAO.obtenerTodos();
        for (Usuario u : lista) {
            modelo.addRow(new Object[]{u.getIdUsuario(), u.getNombre(), u.getCorreoElectronico(), u.getTelefono()});
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerTablaUsuariosPorFiltro(String filtro) {
        String[] columnas = {"ID", "NOMBRE", "CORREO", "TELEFÓNO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Usuario> lista = userDAO.obtenerTodosPorFiltro(filtro);
        for (Usuario u : lista) {
            modelo.addRow(new Object[]{u.getIdUsuario(), u.getNombre(), u.getCorreoElectronico(), u.getTelefono()});
        }
        return modelo;
    }
}
