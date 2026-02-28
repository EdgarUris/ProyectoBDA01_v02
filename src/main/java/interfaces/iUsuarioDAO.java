/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Usuario;

/**
 *
 * @author axelm
 */
public interface iUsuarioDAO {
    boolean insertar(Usuario usuario);
    Usuario obtenerPorId(int idUsuario);
    List<Usuario> obtenerTodos();
    List<Usuario> obtenerTodosPorFiltro(String filtro);
    boolean actualizar(Usuario usuario);
    boolean eliminar(int idUsuario);
}