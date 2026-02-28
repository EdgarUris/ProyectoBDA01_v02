/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import config.ConexionDB;
import interfaces.iUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Autoridad;
import models.Usuario;

/**
 *
 * @author axelm
 */
public class UsuarioDAO implements iUsuarioDAO{

    @Override
    public boolean insertar(Usuario usuario) {
        String query = "INSERT INTO Usuario(nombre, correo, telefono) VALUES(?, ?, ?)";
        try(Connection con = ConexionDB.getConnection()){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getTelefono());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            System.err.println("Error al insertar al usuario: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Usuario obtenerPorId(int idUsuario) {
        String query = "SELECT * FROM Usuario WHERE id_usuario = ?";
        Usuario usuario = null;
        try(Connection con = ConexionDB.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario(rs.getInt("id_usuario"), 
                        rs.getString("correoElectronico"), 
                        rs.getString("nombre"), 
                        rs.getString("telefono"));
            }
        }catch(SQLException ex){
            System.err.println("Error al obtener el usuario por ID: " + ex.getMessage());
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreoElectronico(rs.getString("correo"));
                usuario.setTelefono(rs.getString("telefono"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener todos los usuarios: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public List<Usuario> obtenerTodosPorFiltro(String filtro) {
        String sql = "SELECT * FROM Usuario WHERE nombre LIKE ?";
        List<Usuario> lista = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ResultSet rs = ps.executeQuery()) {
            ps.setString(1, "%" + filtro + "%");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreoElectronico(rs.getString("correo"));
                usuario.setTelefono(rs.getString("telefono"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener todos los usuarios: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE Usuario SET nombre = ?, correo = ?, telefono = ? WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getTelefono());
            ps.setInt(5, usuario.getIdUsuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar usuario: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idUsuario) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        try (Connection conn = ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar usuario: " + ex.getMessage());
            return false;
        }
    }
}