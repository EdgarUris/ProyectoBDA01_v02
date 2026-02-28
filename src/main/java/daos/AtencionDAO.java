/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import interfaces.iAtencionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Atencion;

/**
 *
 * @author axelm
 */
public class AtencionDAO implements iAtencionDAO{

    @Override
    public boolean insertar(Atencion atencion) {
        String query = "INSERT INTO Atencion(fecha_inicio_reparacion, fecha_solucion, estatus_final, id_bache, id_autoridad) VALUES(?, ?, ?, ?, ?)";
        try(Connection con = ConexionDB.getConnection()){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, atencion.getFecha_inicio_reparacion());
            ps.setDate(2, atencion.getFecha_solucion());
            ps.setString(3, atencion.getEstatus_final());
            ps.setInt(4, atencion.getIdBache());
            ps.setInt(5, atencion.getIdAutoridad());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            System.err.println("Error al insertar a la atencion: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Atencion obtenerPorId(int idAtencion) {
        String query = "SELECT * FROM Atencion WHERE id_atencion = ?";
        Atencion atencion = null;
        try(Connection con = ConexionDB.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idAtencion);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                atencion = new Atencion();
                atencion.setIdAtencion(rs.getInt("id_atencion"));
                atencion.setFecha_inicio_reparacion(rs.getDate("fecha_inicio_reparacion"));
                atencion.setFecha_solucion(rs.getDate("fecha_solucion"));
                atencion.setEstatus_final(rs.getString("estatus_final"));
                atencion.setIdBache(rs.getInt("id_bache"));
                atencion.setIdAutoridad(rs.getInt("id_autoridad"));
                return atencion;
            }
        }catch(SQLException ex){
            System.err.println("Error al obtener la atencion por ID: " + ex.getMessage());
        }
        return atencion;
    }

    @Override
    public List<Atencion> obtenerTodos() {
        String sql = "SELECT * FROM Atencion";
        List<Atencion> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Atencion atencion = new Atencion();
                atencion.setIdAtencion(rs.getInt("id_atencion"));
                atencion.setFecha_inicio_reparacion(rs.getDate("fecha_inicio_reparacion"));
                atencion.setFecha_solucion(rs.getDate("fecha_solucion"));
                atencion.setEstatus_final(rs.getString("estatus_final"));
                atencion.setIdBache(rs.getInt("id_bache"));
                atencion.setIdAutoridad(rs.getInt("id_autoridad"));
                lista.add(atencion);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener todas las atenciones: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public List<Atencion> obtenerPorBache(int idBache) {
        String sql = "SELECT * FROM Atencion WHERE id_bache = ?";
        List<Atencion> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBache);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Atencion atencion = new Atencion();
                atencion.setIdAtencion(rs.getInt("id_atencion"));
                atencion.setFecha_inicio_reparacion(rs.getDate("fecha_inicio_reparacion"));
                atencion.setFecha_solucion(rs.getDate("fecha_solucion"));
                atencion.setEstatus_final(rs.getString("estatus_final"));
                atencion.setIdBache(rs.getInt("id_bache"));
                atencion.setIdAutoridad(rs.getInt("id_autoridad"));
                lista.add(atencion);
            }

        } catch (SQLException ex) {
            System.err.println("Error al obtener las atenciones por bache: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public List<Atencion> obtenerPorAutoridad(int idAutoridad) {
        String sql = "SELECT * FROM Atencion WHERE id_autoridad = ?";
        List<Atencion> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAutoridad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Atencion atencion = new Atencion();
                atencion.setIdAtencion(rs.getInt("id_atencion"));
                atencion.setFecha_inicio_reparacion(rs.getDate("fecha_inicio_reparacion"));
                atencion.setFecha_solucion(rs.getDate("fecha_solucion"));
                atencion.setEstatus_final(rs.getString("estatus_final"));
                atencion.setIdBache(rs.getInt("id_bache"));
                atencion.setIdAutoridad(rs.getInt("id_autoridad"));
                lista.add(atencion);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener las atenciones por autoridad: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Atencion atencion) {
        String sql = "UPDATE Atencion SET fecha_inicio_reparacion = ?, fecha_solucion = ?, estatus_final = ?, id_bache = ?, id_autoridad = ? WHERE id_atencion = ?";
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, atencion.getFecha_inicio_reparacion());
            ps.setDate(2, atencion.getFecha_solucion());
            ps.setString(3, atencion.getEstatus_final());
            ps.setInt(4, atencion.getIdBache());
            ps.setInt(5, atencion.getIdAutoridad());
            ps.setInt(6, atencion.getIdAtencion());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar atencion: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idAtencion) {
        String sql = "DELETE FROM Atencion WHERE id_atencion  = ?";
        try (Connection conn = ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAtencion);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar atencion: " + ex.getMessage());
            return false;
        }
    }
}