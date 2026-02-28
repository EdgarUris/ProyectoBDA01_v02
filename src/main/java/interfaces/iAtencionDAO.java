/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Atencion;

/**
 *
 * @author axelm
 */
public interface iAtencionDAO{
    boolean insertar(Atencion atencion);
    Atencion obtenerPorId(int idAtencion);
    List<Atencion> obtenerTodos();
    List<Atencion> obtenerPorBache(int idBache);
    List<Atencion> obtenerPorAutoridad(int idAutoridad);
    boolean actualizar(Atencion atencion);
    boolean eliminar(int idAtencion);
}
