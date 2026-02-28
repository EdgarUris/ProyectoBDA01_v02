package models;

/**
 *
 * @author axelm
 */
 public class Autoridad {
    private int idAutoridad;
    private String nombre;
    private String correoElectronico;
    private String telefono;
    private String dependencia;

    public Autoridad() {}

    public Autoridad(int idAutoridad, String nombre, String telefono, String correoElectronico, String dependencia) {
        this.idAutoridad = idAutoridad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.dependencia = dependencia;
    }

    public void setIdAutoridad(int idAutoridad) {
        this.idAutoridad = idAutoridad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public int getIdAutoridad() {
        return idAutoridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDependencia() {
        return dependencia;
    }
}
