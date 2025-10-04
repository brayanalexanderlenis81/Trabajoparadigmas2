package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.Medicamento;

/**
 * Interfaz para operaciones de persistencia en archivo binario de la jerarquía Medicamento.
 *
 * Requisito del profesor:
 *  - El primer método retorna un String (mensaje de confirmación).
 *  - El segundo método retorna el arreglo de objetos (Medicamento[]).
 */
public interface OperacionArchivo {

    /**
     * Serializa (guarda) el arreglo de medicamentos en un archivo binario.
     *
     * @param medicamentos arreglo de medicamentos a serializar (puede contener nulls)
     * @param path ruta del directorio destino (por ejemplo "./data")
     * @param name nombre del archivo (por ejemplo "medicamentos.dat")
     * @return mensaje de confirmación o detalle de error controlado
     */
    String serializar(Medicamento[] medicamentos, String path, String name);

    /**
     * Deserializa (lee) el archivo binario y retorna el arreglo de medicamentos.
     *
     * @param path ruta del directorio origen
     * @param name nombre del archivo
     * @return arreglo de medicamentos leído (si no existe o está vacío, retorna arreglo de longitud 0; nunca null)
     */
    Medicamento[] deserializar(String path, String name);
}