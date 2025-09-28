package co.edu.poli.actividad5.servicios;
import co.edu.poli.actividad5.model.Medicamento;

/**
 * Interfaz que define las operaciones CRUD para Medicamento.
 * Métodos:
 * - create: inserta un Medicamento (primer null de izquierda a derecha, con crecimiento dinámico)
 * - readall: retorna todos los medicamentos almacenados (no nulos)
 * - readid: retorna el medicamento por su ID
 * - update: actualiza el medicamento con el ID dado
 * - delete: elimina (set a null) el medicamento con el ID dado
 */
public interface OperacionCRUD {
    boolean create(Medicamento m);
    Medicamento[] readall();
    Medicamento readid(String id);
    boolean update(String id, Medicamento m);
    boolean delete(String id);
}