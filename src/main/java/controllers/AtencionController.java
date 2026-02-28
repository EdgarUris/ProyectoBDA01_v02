/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.AtencionDAO;
import models.Atencion;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EdgarUrias
 */
public class AtencionController {
    
    private final AtencionDAO atencionDAO;
    
    public AtencionController(){
        atencionDAO = new AtencionDAO();
    }
    
public boolean agregar(Date fechaInicioRepa, Date fechaSolucion, String estatusFinal, 
        int idBache, int idAutoridad){
        if(fechaInicioRepa == null){
            System.err.println("Error: La fecha no puede ser nulo");
            return false;
        }
        if(estatusFinal == null || estatusFinal.trim().isEmpty()){
            System.err.println("Error: El estatus final no puede ser nulo");
            return false;
        }
        if(idBache <= 0){
            System.err.println("Error: ID del bache invalido");
            return false;
        }
        if(idAutoridad <= 0){
            System.err.println("Error: ID de autoridad invalido");
            return false;
        }
        
        //la fechasolucion puede ser nula hasta q se repare
        
        Atencion a = new Atencion();
        a.setEstatus_final(estatusFinal);
        a.setIdAutoridad(idAutoridad);
        a.setIdBache(idBache);
        a.setFecha_solucion(fechaSolucion);
        a.setFecha_inicio_reparacion(fechaInicioRepa);
        return atencionDAO.insertar(a);
    }
    
    public Atencion obtenerAtencion(int idAtencion) {
        if (idAtencion <= 0) {
            System.err.println("ID de atencion inválido.");
            return null;
        }
        return atencionDAO.obtenerPorId(idAtencion);
    }

    public List<Atencion> listarAtenciones() {
        return atencionDAO.obtenerTodos();
    }

    public boolean actualizarAtencion(Date fechaInicioRepa, Date fechaSolucion, String estatusFinal, 
        int idBache, int idAutoridad) {
        if(fechaInicioRepa == null){
            System.err.println("Error: La fecha de inicio de reparacion no puede ser nulo");
            return false;
        }
        if(estatusFinal == null || estatusFinal.trim().isEmpty()){
            System.err.println("Error: El estatus final no puede ser nulo");
            return false;
        }
        if(idBache <= 0){
            System.err.println("Error: ID del bache invalido");
            return false;
        }
        if(idAutoridad <= 0){
            System.err.println("Error: ID de autoridad invalido");
            return false;
        }
        
        //la fechasolucion puede ser nula hasta q se repare
        
        Atencion a = new Atencion();
        a.setEstatus_final(estatusFinal);
        a.setIdAutoridad(idAutoridad);
        a.setIdBache(idBache);
        a.setFecha_solucion(fechaSolucion);
        a.setFecha_inicio_reparacion(fechaInicioRepa);
        return atencionDAO.actualizar(a);
    }
    
    public boolean eliminarAtencion(int idAtencion) {
        if (idAtencion <= 0) {
            System.err.println("ID de atencion inválido.");
            return false;
        }
        return atencionDAO.eliminar(idAtencion);
    }
    
    public DefaultTableModel obtenerTablaAtencionPorBache(int idBache) {
        String[] columnas = {"ID", "ID BACHE", "ID AUTORIDAD", "FECHA INICIO REPARACION", "FECHA SOLUCION", "ESTATUS FINAL"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Atencion> lista = atencionDAO.obtenerPorBache(idBache);
        for (Atencion a : lista) {
            modelo.addRow(new Object[]{a.getIdAtencion(), a.getIdBache(), a.getIdAutoridad(), a.getFecha_inicio_reparacion(), a.getFecha_solucion(), a.getEstatus_final()});
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerTablaAtencionPorAutoridad(int idAutoridad) {
        String[] columnas = {"ID", "ID BACHE", "ID AUTORIDAD", "FECHA INICIO REPARACION", "FECHA SOLUCION", "ESTATUS FINAL"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Atencion> lista = atencionDAO.obtenerPorAutoridad(idAutoridad);
        for (Atencion a : lista) {
            modelo.addRow(new Object[]{a.getIdAtencion(), a.getIdBache(), a.getIdAutoridad(), a.getFecha_inicio_reparacion(), a.getFecha_solucion(), a.getEstatus_final()});
        }
        return modelo;
    }
}
