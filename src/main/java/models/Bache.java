package models;

import java.sql.Date;

/**
 *
 * @author axelm
 */
public class Bache {
    private int idBache;
    private String ubicacion;
    private String tamanoAprox;
    private String nivelSeveridad;
    private String estado;
    private Date fechaReporte;
    private int idUsuario;

    public Bache() {}

    public Bache(int idBache, String ubicacion, String tamanoAprox, String estado, String nivelSeveridad, int idReporte) {
        this.idBache = idBache;
        this.ubicacion = ubicacion;
        this.tamanoAprox = tamanoAprox;
        this.estado = estado;
        this.nivelSeveridad = nivelSeveridad;
        this.idUsuario = idReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdBache(int idBache) {
        this.idBache = idBache;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setTamanoAprox(String tamanoAprox) {
        this.tamanoAprox = tamanoAprox;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNivelSeveridad(String nivelSeveridad) {
        this.nivelSeveridad = nivelSeveridad;
    }

    public Date getFechaReporte() {
        return fechaReporte;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdBache() {
        return idBache;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTamanoAprox() {
        return tamanoAprox;
    }

    public String getEstado() {
        return estado;
    }

    public String getNivelSeveridad() {
        return nivelSeveridad;
    }
}
