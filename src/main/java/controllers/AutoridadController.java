/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.AutoridadDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Autoridad;

/**
 *
 * @author EdgarUrias
 */
public class AutoridadController {
    private final AutoridadDAO autoridadDAO;
    
    public AutoridadController(){
        autoridadDAO = new AutoridadDAO();
    }
    
    public boolean agregar(String nombre, String correo, String telefono, String dependencia){
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
        if(dependencia == null || dependencia.trim().isEmpty()){
            System.err.println("Error: El telefono del usuario no puede ser nulo");
            return false;
        }
        
        Autoridad a = new Autoridad();
        a.setNombre(nombre.trim());
        a.setCorreoElectronico(correo.trim());
        a.setTelefono(telefono.trim());
        a.setDependencia(dependencia.trim());
        return autoridadDAO.insertar(a);
    }
    
    public Autoridad obtenerUsuario(int idAutoridad) {
        if (idAutoridad <= 0) {
            System.err.println("ID de autoridad inválido.");
            return null;
        }
        return autoridadDAO.obtenerPorId(idAutoridad);
    }

    public List<Autoridad> listarUsuarios() {
        return autoridadDAO.obtenerTodos();
    }

    public boolean actualizarAutoridad(String nombre, String correo, String telefono, String dependencia) {
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
        if(dependencia == null || dependencia.trim().isEmpty()){
            System.err.println("Error: El telefono del usuario no puede ser nulo");
            return false;
        }
        
        Autoridad a = new Autoridad();
        a.setNombre(nombre.trim());
        a.setCorreoElectronico(correo.trim());
        a.setTelefono(telefono.trim());
        a.setDependencia(dependencia.trim());
        return autoridadDAO.actualizar(a);
    }

    public boolean eliminarUsuario(int idAutoridad) {
        if (idAutoridad <= 0) {
            System.err.println("ID de autoridad inválido.");
            return false;
        }
        return autoridadDAO.eliminar(idAutoridad);
    }
    
    public DefaultTableModel obtenerTablaUsuarios() {
        String[] columnas = {"ID", "NOMBRE", "CORREO", "TELEFÓNO", "DEPENDENCIA"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Autoridad> lista = autoridadDAO.obtenerTodos();
        for (Autoridad a : lista) {
            modelo.addRow(new Object[]{a.getIdAutoridad(), a.getNombre(), a.getCorreoElectronico(), a.getTelefono()});
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerTablaUsuariosPorFiltro(String filtro) {
        String[] columnas = {"ID", "NOMBRE", "CORREO", "TELEFÓNO", "DEPENDENCIA"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Autoridad> lista = autoridadDAO.obtenerTodosPorFiltro(filtro);
        for (Autoridad a : lista) {
            modelo.addRow(new Object[]{a.getIdAutoridad(), a.getNombre(), a.getCorreoElectronico(), a.getTelefono()});
        }
        return modelo;
    }
}
