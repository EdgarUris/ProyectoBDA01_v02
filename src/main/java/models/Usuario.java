package models;

/**
 *
 * @author axelm
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correoElectronico;
    private String telefono;

    public Usuario() {}

    public Usuario(int idUsuario, String correoElectronico, String nombre, String telefono) {
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
