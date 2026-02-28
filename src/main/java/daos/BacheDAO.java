/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import interfaces.iBacheDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Bache;

/**
 *
 * @author axelm
 */
public class BacheDAO implements iBacheDAO{

    @Override
    public boolean insertar(Bache bache) {
        String query = "INSERT INTO Bache(ubicacion, tamanIo_aproximado, nivel_severidad, estado_actual, fecha_reporte, id_usuario) VALUES(?, ?, ?, ?, ?. ?)";
        try(Connection con = ConexionDB.getConnection()){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bache.getUbicacion());
            ps.setString(2, bache.getTamanoAprox());
            ps.setString(3, bache.getNivelSeveridad());
            ps.setString(4, bache.getEstado());
            ps.setDate(5, bache.getFechaReporte());
            ps.setInt(6, bache.getIdUsuario());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            System.err.println("Error al insertar al bache: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Bache obtenerPorId(int idBache) {
        String query = "SELECT * FROM Bache WHERE id_bache = ?";
        Bache bache = null;
        try(Connection con = ConexionDB.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idBache);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bache = new Bache();
                bache.setIdBache(rs.getInt("id_bache"));
                bache.setUbicacion(rs.getString("ubicacion"));
                bache.setTamanoAprox(rs.getString("tamanio_aproximado"));
                bache.setEstado(rs.getString("estado_actual"));
                bache.setNivelSeveridad(rs.getString("nivel_severidad"));
                bache.setIdUsuario(rs.getInt("id_usuario"));
                bache.setFechaReporte(rs.getDate("fecha_reporte"));
            }
        }catch(SQLException ex){
            System.err.println("Error al obtener el bache por ID: " + ex.getMessage());
        }
        return bache;
    }

    @Override
    public List<Bache> obtenerTodos() {
        String sql = "SELECT * FROM Bache";
        List<Bache> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bache bache = new Bache();
                bache.setIdBache(rs.getInt("id_bache"));
                bache.setUbicacion(rs.getString("ubicacion"));
                bache.setTamanoAprox(rs.getString("tamanio_aproximado"));
                bache.setNivelSeveridad(rs.getString("nivel_severidad"));
                bache.setEstado(rs.getString("estado_actual"));
                bache.setFechaReporte(rs.getDate("fecha_reporte"));
                bache.setIdUsuario(rs.getInt("id_usuario"));
                lista.add(bache);
            }

        } catch (SQLException ex) {
            System.err.println("Error al obtener todos los baches: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public List<Bache> obtenerTodosPorFiltro(String filtro) {
        String sql = "SELECT * FROM Bache WHERE ubicacion LIKE ?";
        List<Bache> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {
            ps.setString(1, "%" + filtro + "%");
            while (rs.next()) {
                Bache bache = new Bache();
                bache.setIdBache(rs.getInt("id_bache"));
                bache.setUbicacion(rs.getString("ubicacion"));
                bache.setTamanoAprox(rs.getString("tamanio_aprocimado"));
                bache.setNivelSeveridad(rs.getString("nivel_severidad"));
                bache.setEstado(rs.getString("estado_actual"));
                bache.setFechaReporte(rs.getDate("fecha_reporte"));
                bache.setIdUsuario(rs.getInt("id_usuario"));
                lista.add(bache);
            }

        } catch (SQLException ex) {
            System.err.println("Error al obtener todos los baches: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Bache bache) {
        String sql = "UPDATE Bache SET ubicacion = ?, tamanio_aproximado = ?, nivel_severidad = ?, estado_actual = ?, fecha_reporte = ?, id_usuario = ? WHERE id_bache = ?";
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bache.getUbicacion());
            ps.setString(2, bache.getTamanoAprox());
            ps.setString(3, bache.getNivelSeveridad());
            ps.setString(4, bache.getEstado());
            ps.setDate(5, bache.getFechaReporte());
            ps.setInt(6, bache.getIdUsuario());
            ps.setInt(7, bache.getIdBache());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar bache: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idBache) {
        String sql = "DELETE FROM Bache WHERE id_bache = ?";
        try (Connection conn = ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idBache);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar bache: " + ex.getMessage());
            return false;
        }
    }
}