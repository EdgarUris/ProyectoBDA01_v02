/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import daos.BacheDAO;
import interfaces.iBacheDAO;
import java.time.Instant;
import java.sql.Date;
import java.time.Clock;
import java.time.Duration;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Bache;

/**
 *
 * @author EdgarUrias
 */
public class BacheController {
    private final iBacheDAO bacheDAO;
    
    public BacheController(){
        bacheDAO = new BacheDAO();
    }
    
    public boolean agregar(String ubicacion, String tamanoAprox, 
            String nivelSeveridad, String estado, Date fechaReporte, int idUsuario){
        if(ubicacion == null || ubicacion.trim().isEmpty()){
            System.err.println("Error: La ubicacion no puede ser nula");
            return false;
        }
        if(tamanoAprox == null || tamanoAprox.trim().isEmpty()){
            System.err.println("Error: El tamano no puede ser nulo");
            return false;
        }
        if(nivelSeveridad == null || nivelSeveridad.trim().isEmpty()){
            System.err.println("Error: El nivel de severidad no puede ser nulo");
            return false;
        }
        if(estado == null || estado.trim().isEmpty()){
            System.err.println("Error: El estado no puede ser nulo");
            return false;
        }
        if (fechaReporte == null || fechaReporte.after(new java.util.Date())) {
            System.err.println("Error: La fecha no puede ser nula ni estar en el futuro");
            return false;
        }
        if(idUsuario <= 0){
            System.err.println("ID de usuario invalido");
            return false;
        }
        
        Bache b = new Bache();
        b.setEstado(estado);
        b.setFechaReporte(fechaReporte);
        b.setIdUsuario(idUsuario);
        b.setNivelSeveridad(nivelSeveridad);
        b.setTamanoAprox(tamanoAprox);
        b.setUbicacion(ubicacion);
        
        return bacheDAO.insertar(b);
    }
    
    public Bache obtenerBache(int idBache) {
        if (idBache <= 0) {
            System.err.println("ID de bache inválido.");
            return null;
        }
        return bacheDAO.obtenerPorId(idBache);
    }

    public List<Bache> listarBaches() {
        return bacheDAO.obtenerTodos();
    }

    public boolean actualizarBache(int idBache, String ubicacion, String tamanoAprox, 
            String nivelSeveridad, String estado, Date fechaReporte, int idUsuario) {
        if(ubicacion == null || ubicacion.trim().isEmpty()){
            System.err.println("Error: La ubicacion no puede ser nula");
            return false;
        }
        if(tamanoAprox == null || tamanoAprox.trim().isEmpty()){
            System.err.println("Error: El tamano no puede ser nulo");
            return false;
        }
        if(nivelSeveridad == null || nivelSeveridad.trim().isEmpty()){
            System.err.println("Error: El nivel de severidad no puede ser nulo");
            return false;
        }
        if(estado == null || estado.trim().isEmpty()){
            System.err.println("Error: El estado no puede ser nulo");
            return false;
        }
        if(fechaReporte == null || estado.trim().isEmpty() || fechaReporte.after(
                Date.from(
                        Instant.now(
                                Clock.offset(
                                        Clock.systemDefaultZone(), Duration.ofMinutes(5)))))){
            System.err.println("Error: La fecha no puede ser en el futuro o nula");
            return false;
        }
        if(idUsuario <= 0){
            System.err.println("ID de usuario invalido");
            return false;
        }
        if(idBache <= 0){
            System.err.println("ID de bache invalido");
            return false;
        }
        
        Bache b = new Bache();
        b.setEstado(estado);
        b.setFechaReporte(fechaReporte);
        b.setIdUsuario(idUsuario);
        b.setNivelSeveridad(nivelSeveridad);
        b.setTamanoAprox(tamanoAprox);
        b.setUbicacion(ubicacion);
        
        return bacheDAO.actualizar(b);
    }

    public boolean eliminarBache(int idBache) {
        if (idBache <= 0) {
            System.err.println("ID de bache inválido.");
            return false;
        }
        return bacheDAO.eliminar(idBache);
    }
    
    public DefaultTableModel obtenerTablaBaches() {
        String[] columnas = {"ID", "UBICACION", "FECHA REPORTE", "SEVERIDAD", "TAMAÑO", "ESTADO", "ID USUARIO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Bache> lista = bacheDAO.obtenerTodos();
        for (Bache b : lista) {
            modelo.addRow(new Object[]{b.getIdBache(), b.getUbicacion(), b.getFechaReporte().toString(), 
                b.getNivelSeveridad(), b.getTamanoAprox(), b.getEstado(), String.valueOf(b.getIdUsuario())});
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerTablaBachesPorFiltro(String filtro) {
        String[] columnas = {"ID", "UBICACION", "FECHA REPORTE", "SEVERIDAD", "TAMAÑO", "ESTADO", "ID USUARIO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Bache> lista = bacheDAO.obtenerTodosPorFiltro(filtro);
        for (Bache b : lista) {
            modelo.addRow(new Object[]{b.getIdBache(), b.getUbicacion(), b.getFechaReporte().toString(), 
                b.getNivelSeveridad(), b.getTamanoAprox(), b.getEstado(), String.valueOf(b.getIdUsuario())});
        }
        return modelo;
    }    
}
