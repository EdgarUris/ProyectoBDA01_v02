/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Autoridad;

/**
 *
 * @author axelm
 */
public interface iAutoridadDAO {
    boolean insertar(Autoridad autoridad);
    Autoridad obtenerPorId(int idAutoridad);
    List<Autoridad> obtenerTodos();
    List<Autoridad> obtenerTodosPorFiltro(String filtro);
    boolean actualizar(Autoridad autoridad);
    boolean eliminar(int idAutoridad);
}
