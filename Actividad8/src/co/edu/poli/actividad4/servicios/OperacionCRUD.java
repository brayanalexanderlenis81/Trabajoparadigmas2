package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.Medicamento;

/**
 * Interfaz de operaciones CRUD para la entidad Medicamento.
 * Reglas del ejercicio:
 * - El arreglo inicia con tamano 3 en la implementacion.
 * - readall retorna el arreglo interno.
 * - readid recorre el arreglo y compara por serial.
 * - delete coloca null en la posicion y retorna el objeto eliminado.
 * - update reemplaza el objeto encontrado y retorna un mensaje.
 * - create inserta en primer null y duplica el arreglo cuando esta lleno.
 */
public interface OperacionCRUD {

    /**
     * Inserta un medicamento en el primer espacio disponible.
     * Si el arreglo esta lleno, se duplica y luego se inserta.
     * @param m objeto a insertar. Debe tener serial unico y no vacio.
     * @return mensaje de resultado
     */
    String create(Medicamento m);

    /**
     * Retorna el arreglo interno (puede contener posiciones null).
     * @return arreglo de almacenamiento
     */
    Medicamento[] readall();

    /**
     * Busca por serial recorriendo el arreglo.
     * @param serial identificador a buscar
     * @return el medicamento encontrado o null si no existe
     */
    Medicamento readid(String serial);

    /**
     * Reemplaza el registro cuyo serial coincide con el parametro.
     * @param serial identificador del registro a reemplazar
     * @param m nuevo objeto. Su serial no debe estar en uso por otro registro.
     * @return mensaje de resultado
     */
    String update(String serial, Medicamento m);

    /**
     * Elimina el registro cuyo serial coincide.
     * La posicion queda en null.
     * @param serial identificador del registro a eliminar
     * @return el objeto eliminado o null si no existe
     */
    Medicamento delete(String serial);
}