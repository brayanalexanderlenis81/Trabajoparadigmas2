package co.edu.poli.actividad5.vista;

import co.edu.poli.actividad5.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.actividad5.servicios.Pastillaliberacionprolongada;
import co.edu.poli.actividad5.model.Pastilla;
import co.edu.poli.actividad5.model.Jarabe;
import co.edu.poli.actividad5.model.Medicamento;
/*
 Clase Principal - demo para probar todas las operaciones CRUD.
 (NO se añadió Javadoc porque pediste Javadoc solo en model y services).
*/
public class Principal {

    public static void main(String[] args) {
        ImplementacionOperacionCRUD repo = new ImplementacionOperacionCRUD();

        // --- CREATE: crear varios medicamentos ---
        System.out.println(">>> CREATE:");

        Pastilla p1 = new Pastilla("P001");
        p1.setMg(500);
        p1.setCantidadporcaja(20);
        boolean createdP1 = repo.create(p1);
        System.out.println("create P001 -> " + createdP1);

        Jarabe j1 = new Jarabe("J001");
        j1.setVolumenml(150.0);
        boolean createdJ1 = repo.create(j1);
        System.out.println("create J001 -> " + createdJ1);

        Pastillaliberacionprolongada pl1 = new Pastillaliberacionprolongada("PL001");
        pl1.setHorasdeliberacion(12);
        boolean createdPL1 = repo.create(pl1);
        System.out.println("create PL001 -> " + createdPL1);

        // intentar crear duplicado (debería fallar)
        Pastilla dup = new Pastilla("P001");
        boolean createdDup = repo.create(dup);
        System.out.println("create duplicado P001 (esperado false) -> " + createdDup);

        // --- READALL: listar todos ---
        System.out.println("\n>>> READALL (lista de serials y tipos):");
        printAll(repo.readall());

        // --- READID: buscar por id ---
        System.out.println("\n>>> READID:");
        Medicamento found = repo.readid("P001");
        System.out.println("readid P001 -> " + (found != null ? describe(found) : "NULL"));

        Medicamento notFound = repo.readid("NO_EXISTE");
        System.out.println("readid NO_EXISTE -> " + (notFound != null ? describe(notFound) : "NULL"));

        // --- UPDATE: actualizar un objeto por su ID ---
        System.out.println("\n>>> UPDATE:");
        // crear un nuevo objeto con el mismo ID (reemplazo)
        Pastilla p1Updated = new Pastilla("P001");
        p1Updated.setMg(250); // cambio la dosis para ver la diferencia
        p1Updated.setCantidadporcaja(10);
        boolean updated = repo.update("P001", p1Updated);
        System.out.println("update P001 -> " + updated);
        System.out.println("readid P001 despues update -> " + describe(repo.readid("P001")));

        // intentar update que cause conflicto de ID (intentar cambiar P001 por J001 que ya existe)
        Pastilla conflict = new Pastilla("J001"); // id ya existe en otra posición
        boolean updateConflict = repo.update("P001", conflict);
        System.out.println("update P001 cambiando id a J001 (esperado false por conflicto) -> " + updateConflict);

        // --- DELETE: eliminar por ID ---
        System.out.println("\n>>> DELETE:");
        boolean deletedJ1 = repo.delete("J001");
        System.out.println("delete J001 -> " + deletedJ1);
        System.out.println("readid J001 despues delete -> " + (repo.readid("J001") != null ? "EXISTE" : "NULL"));

        // listar final
        System.out.println("\n>>> LIST FINAL (readall):");
        printAll(repo.readall());

        // --- Opcional: mostrar capacidad interna (para ver redimensionamiento si pruebas muchos inserciones) ---
        System.out.println("\nCapacidad interna actual: " + repo.capacity());
    }

    private static void printAll(Medicamento[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[vacío]");
            return;
        }
        for (Medicamento m : arr) {
            System.out.println(" - " + describe(m));
        }
    }

    private static String describe(Medicamento m) {
        if (m == null) return "NULL";
        String className = m.getClass().getSimpleName();
        return String.format("Serial=%s, Tipo=%s", m.getId(), className);
    }
}
