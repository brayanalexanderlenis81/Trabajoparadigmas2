package co.edu.poli.actividad3.vista;
import java.io.File;
import java.util.Scanner;
import co.edu.poli.actividad3.model.Medicamento;
import co.edu.poli.actividad3.model.Pastilla;
import co.edu.poli.actividad3.model.Jarabe;
import co.edu.poli.actividad4.servicios.Pastillaliberacionprolongada;
import co.edu.poli.actividad4.servicios.ImplementacionOperacionCRUD;
import co.edu.poli.actividad4.servicios.ArchivoMedicamentosBinario;
import co.edu.poli.actividad4.servicios.OperacionArchivo;

public class Principal {

    private final Scanner sc = new Scanner(System.in);
    private final ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
    private final OperacionArchivo archiver = new ArchivoMedicamentosBinario();
    private final String PATH = "./data";
    private final String NAME = "medicamentos.dat";

    public static void main(String[] args) {
        new Principal().run();
    }

    private void run() {
        int op;
        do {
            showMenu();
            op = readInt("Elige una opción: ");
            switch (op) {
                case 1 -> crearMedicamento(); // Crear
                case 2 -> listarTodos(); // Listar todos
                case 3 -> listarUno(); // Listar uno
                case 4 -> guardarArchivo(); // Guardar archivo
                case 5 -> leerArchivo(); // Leer archivo
                case 6 -> modificar(); // Modificar
                case 7 -> eliminar(); // Eliminar
                case 8 -> System.out.println("Saliendo..."); // Salir
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 8);
        sc.close();
    }

    private void showMenu() {
        System.out.println("=======================================");
        System.out.println(" ACTIVIDAD 8 - MENÚ CRUD ");
        System.out.println("=======================================");
        System.out.println("1. Crear medicamento");
        System.out.println("2. Listar todos");
        System.out.println("3. Listar uno");
        System.out.println("4. Guardar archivo (serializar)");
        System.out.println("5. Leer archivo (deserializar)");
        System.out.println("6. Modificar medicamento");
        System.out.println("7. Eliminar medicamento");
        System.out.println("8. Salir");
        System.out.println("=======================================");
    }

    // ================== CREATE ==================
    private void crearMedicamento() {
        System.out.println("Tipo de medicamento:");
        System.out.println("1) Pastilla");
        System.out.println("2) Jarabe");
        System.out.println("3) Pastilla de liberación prolongada");

        int tipo = readInt("Selecciona (1-3): ");
        String serialIngresado = readString("Serial del medicamento: ");
        Medicamento nuevo = null;

        switch (tipo) {
            case 1 -> {
                double mg = readDouble("mg (double): ");
                int cantidadPorCaja = readInt("cantidad por caja (int): ");
                boolean esmasticable = readBoolean("¿es masticable? (true/false): ");
                Pastilla p = new Pastilla();
                setSerialSafe(p, serialIngresado);
                trySet(p, "setMg", double.class, mg);
                trySet(p, "setCantidadporcaja", int.class, cantidadPorCaja);
                trySet(p, "setEsmasticable", boolean.class, esmasticable);
                nuevo = p;
            }
            case 2 -> {
                double volumenMl = readDouble("volumen (ml) (double): ");
                boolean incluyeDosificador = readBoolean("¿incluye dosificador? (true/false): ");
                Jarabe j = new Jarabe();
                setSerialSafe(j, serialIngresado);

                if (!trySet(j, "setVolumenml", double.class, volumenMl)) {
                    if (!trySet(j, "setVolumenMl", double.class, volumenMl)) {
                        trySet(j, "setVolumen", double.class, volumenMl);
                    }
                }

                if (!trySet(j, "setIncluyedosificador", boolean.class, incluyeDosificador)) {
                    if (!trySet(j, "setIncluyeDosificador", boolean.class, incluyeDosificador)) {
                        trySet(j, "setIncluyeDosificador", Boolean.class, incluyeDosificador);
                    }
                }
                nuevo = j;
            }
            case 3 -> {
                double mg = readDouble("mg (double): ");
                int cantidadPorCaja = readInt("cantidad por caja (int): ");
                int horasLib = readInt("horas de liberación (int): ");
                Pastillaliberacionprolongada plp = new Pastillaliberacionprolongada();
                setSerialSafe(plp, serialIngresado);
                trySet(plp, "setMg", double.class, mg);
                trySet(plp, "setCantidadporcaja", int.class, cantidadPorCaja);

                if (!trySet(plp, "setHorasdeliberacion", int.class, horasLib)) {
                    trySet(plp, "setHorasDeLiberacion", int.class, horasLib);
                }
                nuevo = plp;
            }
            default -> System.out.println("Tipo inválido.");
        }

        if (nuevo != null) {
            System.out.println(crud.create(nuevo));
            System.out.println("Serial generado: " + serialIngresado);
        }
    }

    // ================== READ ALL ==================
    private void listarTodos() {
        Medicamento[] arr = crud.readall();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println("[" + i + "] " + arr[i]);
                count++;
            }
        }
        if (count == 0) System.out.println("No hay registros.");
    }

    // ================== READ ONE ==================
    private void listarUno() {
        String serial = readString("Ingresa el serial: ");
        Medicamento m = crud.readid(serial);
        if (m == null)
            System.out.println("No se encontró.");
        else
            System.out.println(m);
    }

    // ================== SAVE (SERIALIZE) ==================
    private void guardarArchivo() {
        Medicamento[] arr = crud.readall();
        String msg = archiver.serializar(arr, PATH, NAME);
        System.out.println(msg);
        File f = new File(PATH, NAME);
        System.out.println("EVIDENCIA → Archivo: " + f.getAbsolutePath() + " | existe: " + f.exists());
    }

    // ================== LOAD (DESERIALIZE) ==================
    private void leerArchivo() {
        Medicamento[] data = archiver.deserializar(PATH, NAME);
        for (Medicamento m : data) {
            if (m != null)
                crud.create(m);
        }
        System.out.println("Datos cargados desde archivo: " + data.length);
    }

    // ================== UPDATE ==================
    private void modificar() {
        String serial = readString("Serial del medicamento a modificar: ");
        Medicamento m = crud.readid(serial);
        if (m == null) {
            System.out.println("No encontrado.");
            return;
        }

        if (m instanceof Pastilla p) {
            double nuevoMg = readDouble("Nuevo mg (double): ");
            int nuevaCant = readInt("Nueva cantidad por caja (int): ");
            trySet(p, "setMg", double.class, nuevoMg);
            trySet(p, "setCantidadporcaja", int.class, nuevaCant);
            System.out.println(crud.update(serial, p));
        } else if (m instanceof Pastillaliberacionprolongada plp) {
            double nuevoMg = readDouble("Nuevo mg (double): ");
            int nuevaCant = readInt("Nueva cantidad por caja (int): ");
            trySet(plp, "setMg", double.class, nuevoMg);
            trySet(plp, "setCantidadporcaja", int.class, nuevaCant);
            System.out.println(crud.update(serial, plp));
        } else if (m instanceof Jarabe j) {
            double nuevoVol = readDouble("Nuevo volumen (ml) (double): ");
            if (!trySet(j, "setVolumenml", double.class, nuevoVol)) {
                if (!trySet(j, "setVolumenMl", double.class, nuevoVol)) {
                    trySet(j, "setVolumen", double.class, nuevoVol);
                }
            }
            System.out.println(crud.update(serial, j));
        } else {
            System.out.println("Tipo no soportado para edición.");
        }
    }

    // ================== DELETE ==================
    private void eliminar() {
        String serial = readString("Serial a eliminar: ");
        Medicamento eliminado = crud.delete(serial);
        if (eliminado == null)
            System.out.println("No se eliminó.");
        else
            System.out.println("Eliminado: " + eliminado);
    }

    // ================== Helpers ==================
    private int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Valor inválido. Intenta de nuevo.");
            }
        }
    }

    private double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Valor inválido. Intenta de nuevo.");
            }
        }
    }

    private boolean readBoolean(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("true") || s.equals("false"))
                return Boolean.parseBoolean(s);
            System.out.println("Escribe true o false.");
        }
    }

    private String readString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    // ====== Setters seguros ======
    private void setSerialSafe(Object obj, String serial) {
        if (!trySet(obj, "setSerial", String.class, serial)) {
            trySet(obj, "setSerials", String.class, serial);
        }
    }

    private boolean trySet(Object target, String method, Class<?> type, Object value) {
        try {
            var m = target.getClass().getMethod(method, type);
            m.invoke(target, value);
            return true;
        } catch (Exception ignore) {
            return false;
        }
    }
}