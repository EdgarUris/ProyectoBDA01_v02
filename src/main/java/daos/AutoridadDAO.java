/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import interfaces.iAutoridadDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Autoridad;

/**
 *
 * @author axelm
 */
public class AutoridadDAO implements iAutoridadDAO{

    @Override
    public boolean insertar(Autoridad autoridad) {
        String query = "INSERT INTO Autoridad(nombre, correo, telefono, dependencia) VALUES(?, ?, ?, ?)";
        try(Connection con = ConexionDB.getConnection()){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, autoridad.getNombre());
            ps.setString(2, autoridad.getCorreoElectronico());
            ps.setString(3, autoridad.getTelefono());
            ps.setString(4, autoridad.getDependencia());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            System.err.println("Error al insertar a la autoridad: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Autoridad obtenerPorId(int idAutoridad){
        String query = "SELECT * FROM Autoridad WHERE idAutoridad = ?";
        Autoridad autoridad = null;
        try(Connection con = ConexionDB.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idAutoridad);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                autoridad = new Autoridad();
                autoridad.setIdAutoridad(rs.getInt("id_autoridad"));
                autoridad.setNombre(rs.getString("nombre"));
                autoridad.setTelefono(rs.getString("telefono"));
                autoridad.setCorreoElectronico(rs.getString("correo"));
                autoridad.setDependencia(rs.getString("dependencia"));
            }
        }catch(SQLException ex){
            System.err.println("Error al obtener la autoridad por ID: " + ex.getMessage());
        }
        return autoridad;
    }

    @Override
    public List<Autoridad> obtenerTodos() {
        String sql = "SELECT * FROM Autoridad";
        List<Autoridad> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Autoridad autoridad = new Autoridad();
                autoridad.setIdAutoridad(rs.getInt("id_autoridad"));
                autoridad.setNombre(rs.getString("nombre"));
                autoridad.setCorreoElectronico(rs.getString("correo"));
                autoridad.setTelefono(rs.getString("telefono"));
                autoridad.setDependencia(rs.getString("dependencia"));
                lista.add(autoridad);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener todas las autoridades: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public List<Autoridad> obtenerTodosPorFiltro(String filtro) {
        String sql = "SELECT * FROM Autoridad WHERE nombre LIKE ?";
        List<Autoridad> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Autoridad autoridad = new Autoridad();
                autoridad.setIdAutoridad(rs.getInt("id_autoridad"));
                autoridad.setNombre(rs.getString("nombre"));
                autoridad.setCorreoElectronico(rs.getString("correo"));
                autoridad.setTelefono(rs.getString("telefono"));
                autoridad.setDependencia(rs.getString("dependencia"));
                lista.add(autoridad);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener autoridades por filtro: " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public boolean actualizar(Autoridad autoridad) {
        String sql = "UPDATE Autoridad SET nombre = ?, correo = ?, telefono = ?, dependencia = ? WHERE id_autoridad = ?";
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, autoridad.getNombre());
            ps.setString(2, autoridad.getCorreoElectronico());
            ps.setString(3, autoridad.getTelefono());
            ps.setString(4, autoridad.getDependencia());
            ps.setInt(5, autoridad.getIdAutoridad());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar autoridad: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idAutoridad) {
        String sql = "DELETE FROM Autoridad WHERE id_autoridad = ?";
        try (Connection conn = ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAutoridad);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar autoridad: " + ex.getMessage());
            return false;
        }
    }
}