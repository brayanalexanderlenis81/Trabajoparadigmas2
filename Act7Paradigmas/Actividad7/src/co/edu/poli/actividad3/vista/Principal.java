package co.edu.poli.actividad3.vista;
import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad4.servicios.*;

public class Principal {
    public static void main(String[] args) {

        // Instancias de ejemplo
        Pastilla p1 = new Pastilla();
        p1.setSerial("A-001"); p1.setMg(500); p1.setEsmasticable(false); p1.setEstado("Nuevo"); p1.setFechafabricacion(2023);

        Jarabe j1 = new Jarabe();
        j1.setSerial("J-002"); j1.setEstado("Sellado"); j1.setFechafabricacion(2022);

        Pastillaliberacionprolongada p2 = new Pastillaliberacionprolongada();
        p2.setSerial("A-003"); p2.setHorasdeliberacion(12); p2.setFechafabricacion(2019);

        Pastilla p3 = new Pastilla();
        p3.setSerial("A-004"); p3.setMg(250); p3.setEsmasticable(true);

        Pastilla p4 = new Pastilla();
        p4.setSerial("A-005"); p4.setMg(1000);

        // Polimorfismo
        System.out.println("== Mostrar instrucciones ==");
        Medicamento m = new Pastilla();
        m.setSerial("G-000");
        m.mostrarInstrucciones();
        System.out.println();
        p1.mostrarInstrucciones();

        // CRUD
        OperacionCRUD crud = new ImplementacionOperacionCRUD();

        System.out.println("\n== CREATE ==");
        System.out.println(crud.create(p1));
        System.out.println(crud.create(j1));
        System.out.println(crud.create(p2));
        System.out.println(crud.create(p3));
        System.out.println(crud.create(p4));

        System.out.println("\n== READ ALL ==");
        for (Medicamento med : crud.readall()) {
            System.out.println(med);
        }

        System.out.println("\n== READ ID (A-003) ==");
        System.out.println(crud.readid("A-003"));

        System.out.println("\n== UPDATE (A-004) ==");
        Pastilla p4Actualizada = new Pastilla();
        p4Actualizada.setSerial("A-004");
        p4Actualizada.setMg(750);
        p4Actualizada.setEsmasticable(false);
        System.out.println(crud.update("A-004", p4Actualizada));

        System.out.println("\n== DELETE (J-002) ==");
        Medicamento eliminado = crud.delete("J-002");
        if (eliminado != null) {
            System.out.println("Eliminado: " + eliminado);
        } else {
            System.out.println("No se encontro el serial 'J-002'.");
        }

        System.out.println("\n== READ ALL (post delete/update) ==");
        for (Medicamento med : crud.readall()) {
            System.out.println(med);
        }
    }
}