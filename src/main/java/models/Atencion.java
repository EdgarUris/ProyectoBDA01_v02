/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author axelm
 */
public class Atencion {
    private int idAtencion;
    private Date fecha_inicio_reparacion;
    private Date fecha_solucion;
    private String estatus_final;
    private int idBache;
    private int idAutoridad;

    public Atencion() {}

    public Atencion(int idAtencion, Date fecha_inicio_reparacion, Date fecha_solucion, String estatus_final, int idBache, int idAutoridad) {
        this.idAtencion = idAtencion;
        this.fecha_inicio_reparacion = fecha_inicio_reparacion;
        this.fecha_solucion = fecha_solucion;
        this.estatus_final = estatus_final;
        this.idBache = idBache;
        this.idAutoridad = idAutoridad;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public void setFecha_inicio_reparacion(Date fecha_inicio_reparacion) {
        this.fecha_inicio_reparacion = fecha_inicio_reparacion;
    }

    public void setFecha_solucion(Date fecha_solucion) {
        this.fecha_solucion = fecha_solucion;
    }

    public void setEstatus_final(String estatus_final) {
        this.estatus_final = estatus_final;
    }

    public void setIdBache(int idBache) {
        this.idBache = idBache;
    }

    public void setIdAutoridad(int idAutoridad) {
        this.idAutoridad = idAutoridad;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public Date getFecha_inicio_reparacion() {
        return fecha_inicio_reparacion;
    }

    public Date getFecha_solucion() {
        return fecha_solucion;
    }

    public String getEstatus_final() {
        return estatus_final;
    }

    public int getIdBache() {
        return idBache;
    }

    public int getIdAutoridad() {
        return idAutoridad;
    }
}
