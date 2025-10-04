package co.edu.poli.actividad4.servicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.actividad3.model.Medicamento;

/**
 * Implementación binaria usando ObjectOutputStream/ObjectInputStream.
 *
 * IMPORTANTE: Asegúrate de que TODAS las clases del grafo de objetos (Medicamento, Pastilla,
 * Jarabe, Pastillaliberacionprolongada, Marca, Pais, etc.) implementen java.io.Serializable.
 */
public class ArchivoMedicamentosBinario implements OperacionArchivo {

    @Override
    public String serializar(Medicamento[] medicamentos, String path, String name) {
        File dir = new File(path);
        if (!dir.exists() && !dir.mkdirs()) {
            return "No se pudo crear el directorio: " + dir.getAbsolutePath();
        }
        File file = new File(dir, name);

        // Compactar nulls antes de guardar
        List<Medicamento> compact = new ArrayList<>();
        if (medicamentos != null) {
            for (Medicamento m : medicamentos) {
                if (m != null) compact.add(m);
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(compact.toArray(new Medicamento[0]));
            oos.flush();
            return "Archivo guardado OK en: " + file.getAbsolutePath() + " | registros: " + compact.size();
        } catch (IOException e) {
            return "Error al guardar: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
    }

    @Override
    public Medicamento[] deserializar(String path, String name) {
        File file = new File(path, name);
        if (!file.exists()) {
            return new Medicamento[0]; // nunca null
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Medicamento[]) {
                Medicamento[] data = (Medicamento[]) obj;
                return (data != null) ? data : new Medicamento[0];
            }
            return new Medicamento[0];
        } catch (IOException | ClassNotFoundException e) {
            // Si hay error de lectura, devolvemos arreglo vacío para no romper el flujo del menú
            return new Medicamento[0];
        }
    }
}