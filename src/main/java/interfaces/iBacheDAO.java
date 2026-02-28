/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Bache;

/**
 *
 * @author axelm
 */
public interface iBacheDAO {
    boolean insertar(Bache bache);
    Bache obtenerPorId(int idBache);
    List<Bache> obtenerTodos();
    List<Bache> obtenerTodosPorFiltro(String filtro);
    boolean actualizar(Bache bache);
    boolean eliminar(int idBache);
}
