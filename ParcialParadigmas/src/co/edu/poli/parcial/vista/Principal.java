package co.edu.poli.parcial.vista;
import co.edu.poli.parcial.model.*;
import co.edu.poli.parcial.servicios.ImplementacionOperacionCRUD;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ImplementacionOperacionCRUD gestor = new ImplementacionOperacionCRUD(50);
        int opcion;

        // Artistas Predefinidos
        Artista artista1 = new Artista("ART01", "Leonardo da Vinci", "Italiana");
        Artista artista2 = new Artista("ART02", "Auguste Rodin", "Francesa");
        Artista artista3 = new Artista("ART03", "Fernando Botero", "Colombiana");
        Artista[] artistas = {artista1, artista2, artista3};

        System.out.println("--- GESTOR DE COLECCIÓN DE ARTE DEL MUSEO ---");

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Crear Pintura");
            System.out.println("2. Crear Escultura");
            System.out.println("3. Listar todas las Obras");
            System.out.println("4. Ver detalle de una Obra");
            System.out.println("5. Modificar Obra");
            System.out.println("6. Eliminar Obra");
            System.out.println("7. Guardar Colección en Archivo (Serializar)");
            System.out.println("8. Cargar Colección desde Archivo (Deserializar)");
            System.out.println("9. Salir");
            System.out.print("--> Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1, 2: {
                    System.out.print("Ingrese código de la obra: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese fecha de creación (formato dd/mm/aaaa): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Ingrese dimensiones (ej. 77x53 cm): ");
                    String dims = scanner.nextLine();

                    System.out.println("Seleccione un artista:");
                    for (int i = 0; i < artistas.length; i++) {
                        System.out.println((i + 1) + ". " + artistas[i].getNombre());
                    }
                    System.out.print("--> Opción de artista: ");
                    int opcArtista = scanner.nextInt();
                    scanner.nextLine();
                    Artista artistaSeleccionado = artistas[opcArtista - 1];

                    if (opcion == 1) {
                        System.out.print("Ingrese técnica de la pintura (ej. Óleo): ");
                        String tecnica = scanner.nextLine();
                        Pintura nuevaPintura = new Pintura(codigo, titulo, fecha, dims, artistaSeleccionado, tecnica);
                        System.out.println(gestor.create(nuevaPintura));
                    } else {
                        System.out.print("Ingrese material de la escultura (ej. Mármol): ");
                        String material = scanner.nextLine();
                        Escultura nuevaEscultura = new Escultura(codigo, titulo, fecha, dims, artistaSeleccionado, material);
                        System.out.println(gestor.create(nuevaEscultura));
                    }
                    break;
                }
                case 3: {
                    System.out.println("\n--- LISTA DE OBRAS EN LA COLECCIÓN ---");
                    ObradeArte[] todas = gestor.readAll();
                    if (todas.length == 0) {
                        System.out.println("La colección está vacía.");
                    } else {
                        for (ObradeArte obra : todas) {
                            System.out.println(" -> " + obra.getCodigo() + " - " + obra.getTitulo());
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.print("Ingrese el código de la obra a detallar: ");
                    String codigoBusqueda = scanner.nextLine();
                    ObradeArte obraEncontrada = gestor.readId(codigoBusqueda);
                    if (obraEncontrada != null) {
                        System.out.println("\n--- DETALLES DE LA OBRA ---");
                        System.out.println(obraEncontrada.mostrarInformacionCompleta());
                        System.out.println("---------------------------");
                    } else {
                        System.out.println("No se encontró obra con ese código.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Ingrese el código de la obra a modificar: ");
                    String codigoMod = scanner.nextLine();
                    ObradeArte obraModificar = gestor.readId(codigoMod);
                    if (obraModificar == null) {
                        System.out.println("ERROR: No existe obra con ese código.");
                        break;
                    }
                    
                    System.out.print("Nuevo título (actual: " + obraModificar.getTitulo() + "): ");
                    obraModificar.setTitulo(scanner.nextLine());
                    System.out.print("Nuevas dimensiones (actual: " + obraModificar.getDimensiones() + "): ");
                    obraModificar.setDimensiones(scanner.nextLine());
                    
                    if (obraModificar instanceof Pintura p) {
                        System.out.print("Nueva técnica (actual: " + p.getTecnica() + "): ");
                        p.setTecnica(scanner.nextLine());
                    } else if (obraModificar instanceof Escultura e) {
                        System.out.print("Nuevo material (actual: " + e.getMaterial() + "): ");
                        e.setMaterial(scanner.nextLine());
                    }
                    System.out.println(gestor.update(obraModificar));
                    break;
                }
                case 6: {
                    System.out.print("Ingrese el código de la obra a eliminar: ");
                    String codigoDel = scanner.nextLine();
                    System.out.println(gestor.delete(codigoDel));
                    break;
                }
                case 7: {
                    System.out.println(gestor.serializar(gestor.readAll(), "data/", "coleccion.dat"));
                    break;
                }
                case 8: {
                    ObradeArte[] obrasCargadas = gestor.deserializar("data/", "coleccion.dat");
                    if (obrasCargadas.length > 0 || gestor.readAll().length > 0) {
                         gestor.cargarObras(obrasCargadas);
                         System.out.println("Colección cargada desde el archivo.");
                    } else {
                        System.out.println("ADVERTENCIA: No se encontró el archivo o estaba vacío.");
                    }
                    break;
                }
                case 9:
                    System.out.println("Haz seleccionado salir del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
	}

}