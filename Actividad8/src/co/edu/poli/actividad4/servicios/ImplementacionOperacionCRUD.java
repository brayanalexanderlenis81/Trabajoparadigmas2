package co.edu.poli.actividad4.servicios;
import java.util.Arrays;

import co.edu.poli.actividad3.model.Medicamento;

/**
 * Implementacion del CRUD usando un arreglo que inicia en 3 y
 * se duplica cuando esta lleno (3, 6, 12, ...).
 * Todos los recorridos se realizan con for dentro de cada operacion.
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {

    /** Arreglo subyacente de almacenamiento. Puede contener null. */
    private Medicamento[] almacenamiento = new Medicamento[3];

    /** {@inheritDoc} */
    @Override
    public String create(Medicamento m) {
        if (m == null) return "ERROR: objeto nulo.";
        if (m.getSerial() == null || m.getSerial().isEmpty())
            return "ERROR: el serial es obligatorio.";

        // Validar serial unico
        for (int i = 0; i < almacenamiento.length; i++) {
            Medicamento actual = almacenamiento[i];
            if (actual != null && m.getSerial().equals(actual.getSerial())) {
                return "ERROR: ya existe un medicamento con serial '" + m.getSerial() + "'.";
            }
        }

        // Buscar primer null
        int indiceLibre = -1;
        for (int i = 0; i < almacenamiento.length; i++) {
            if (almacenamiento[i] == null) { indiceLibre = i; break; }
        }

        // Si esta lleno, duplicar y volver a buscar
        if (indiceLibre == -1) {
            almacenamiento = Arrays.copyOf(almacenamiento, Math.max(1, almacenamiento.length * 2));
            for (int i = 0; i < almacenamiento.length; i++) {
                if (almacenamiento[i] == null) { indiceLibre = i; break; }
            }
        }

        almacenamiento[indiceLibre] = m;
        return "OK: creado en indice " + indiceLibre + " (capacidad=" + almacenamiento.length + ").";
    }

    /** {@inheritDoc} */
    @Override
    public Medicamento[] readall() {
        return almacenamiento;
    }

    /** {@inheritDoc} */
    @Override
    public Medicamento readid(String serial) {
        if (serial == null) return null;
        for (int i = 0; i < almacenamiento.length; i++) {
            Medicamento actual = almacenamiento[i];
            if (actual != null && serial.equals(actual.getSerial())) {
                return actual;
            }
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public String update(String serial, Medicamento m) {
        if (serial == null || serial.isEmpty()) return "ERROR: serial a buscar es obligatorio.";
        if (m == null) return "ERROR: objeto de actualizacion es nulo.";
        if (m.getSerial() == null || m.getSerial().isEmpty())
            return "ERROR: el nuevo objeto debe tener serial.";

        Medicamento encontrado = readid(serial);
        if (encontrado == null) return "ERROR: no existe medicamento con serial '" + serial + "'.";

        // Si cambian el serial, validar choque
        if (!serial.equals(m.getSerial())) {
            for (int i = 0; i < almacenamiento.length; i++) {
                Medicamento actual = almacenamiento[i];
                if (actual != null && m.getSerial().equals(actual.getSerial())) {
                    return "ERROR: el serial '" + m.getSerial() + "' ya esta en uso.";
                }
            }
        }

        // Reemplazar en el mismo indice
        for (int i = 0; i < almacenamiento.length; i++) {
            if (almacenamiento[i] != null && serial.equals(almacenamiento[i].getSerial())) {
                almacenamiento[i] = m;
                return "OK: actualizado en indice " + i + ".";
            }
        }
        return "ERROR: no se pudo actualizar.";
    }

    /** {@inheritDoc} */
    @Override
    public Medicamento delete(String serial) {
        if (serial == null || serial.isEmpty()) return null;

        Medicamento encontrado = readid(serial);
        if (encontrado == null) return null;

        for (int i = 0; i < almacenamiento.length; i++) {
            Medicamento actual = almacenamiento[i];
            if (actual != null && serial.equals(actual.getSerial())) {
                almacenamiento[i] = null;
                return encontrado;
            }
        }
        return null;
        
    }
   
}