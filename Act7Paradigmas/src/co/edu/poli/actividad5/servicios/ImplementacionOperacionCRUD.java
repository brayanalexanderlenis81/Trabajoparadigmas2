package co.edu.poli.actividad5.servicios;
import co.edu.poli.actividad5.model.Medicamento;
import java.util.Arrays;

/**
 * Implementación de OperacionCRUD que usa un arreglo estático en memoria de Medicamento.
 * El arreglo es dinámicamente redimensionado cuando está lleno (duplica su capacidad).
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {
    private Medicamento[] almacenamiento;
    private int maxSize;
    private static final int DEFAULT_CAPACITY = 100;

    public ImplementacionOperacionCRUD() {
        this.maxSize = DEFAULT_CAPACITY;
        this.almacenamiento = new Medicamento[this.maxSize];
    }

    /**
     * Inserta el medicamento en el primer null (izquierda a derecha).
     * Si el arreglo está lleno, se redimensiona (se duplica capacidad) y luego se inserta.
     * Valida que no se inserten nulos y que no exista un duplicado por ID.
     */
    @Override
    public synchronized boolean create(Medicamento m) {
        if (m == null || m.getId() == null) return false;
        // evitar duplicados por ID
        if (readid(m.getId()) != null) return false;

        // buscar primer null
        for (int i = 0; i < almacenamiento.length; i++) {
            if (almacenamiento[i] == null) {
                almacenamiento[i] = m;
                return true;
            }
        }

        // si llegamos acá, no había null -> redimensionar y agregar al final de la parte usada
        ensureCapacity();
        for (int i = 0; i < almacenamiento.length; i++) {
            if (almacenamiento[i] == null) {
                almacenamiento[i] = m;
                return true;
            }
        }

        // debería no llegar nunca aquí
        return false;
    }

    /**
     * Retorna todos los Medicamento no nulos en un arreglo compacto.
     */
    @Override
    public synchronized Medicamento[] readall() {
        int count = 0;
        for (Medicamento x : almacenamiento) if (x != null) count++;
        Medicamento[] salida = new Medicamento[count];
        int idx = 0;
        for (Medicamento x : almacenamiento) {
            if (x != null) salida[idx++] = x;
        }
        return salida;
    }

    /**
     * Busca un Medicamento por su ID (getId()).
     * @param id identificador
     * @return Medicamento encontrado o null si no existe
     */
    @Override
    public synchronized Medicamento readid(String id) {
        if (id == null) return null;
        for (Medicamento x : almacenamiento) {
            if (x != null && id.equals(x.getId())) return x;
        }
        return null;
    }

    /**
     * Reemplaza el Medicamento que tenga el ID dado por el objeto m.
     * El objeto m puede tener otro ID, pero la búsqueda se hace por "id" pasado.
     * @param id id a buscar
     * @param m nuevo objeto para colocar en la misma posición
     * @return true si se actualizó, false si no se encontró
     */
    @Override
    public synchronized boolean update(String id, Medicamento m) {
        if (id == null || m == null) return false;
        for (int i = 0; i < almacenamiento.length; i++) {
            Medicamento x = almacenamiento[i];
            if (x != null && id.equals(x.getId())) {
                // evitar duplicar ID con otra posición distinta (si m.getId() ya existe en otra posición)
                if (m.getId() != null && !m.getId().equals(id) && readid(m.getId()) != null) {
                    return false; // conflicto de ID
                }
                almacenamiento[i] = m;
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina (set a null) el Medicamento con el ID proporcionado.
     * @param id identificador
     * @return true si se eliminó, false si no se encontró
     */
    @Override
    public synchronized boolean delete(String id) {
        if (id == null) return false;
        for (int i = 0; i < almacenamiento.length; i++) {
            Medicamento x = almacenamiento[i];
            if (x != null && id.equals(x.getId())) {
                almacenamiento[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Duplicar la capacidad del arreglo de almacenamiento.
     */
    private void ensureCapacity() {
        int used = 0;
        for (Medicamento m : almacenamiento) if (m != null) used++;
        if (used < almacenamiento.length) return; // aún hay espacio
        int nuevaCap = Math.max(1, almacenamiento.length * 2);
        this.almacenamiento = Arrays.copyOf(this.almacenamiento, nuevaCap);
        this.maxSize = nuevaCap;
    }

    /**
     * (Opcional) devuelve la capacidad actual del arreglo interno (útil para pruebas).
     */
    public int capacity() {
        return this.almacenamiento.length;
    }
}