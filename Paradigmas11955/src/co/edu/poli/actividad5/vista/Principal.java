package co.edu.poli.actividad5.vista;
import co.edu.poli.actividad5.model.*;
import co.edu.poli.actividad5.servicios.Pastillaliberacionprolongada;
public class Principal {
	public static void main(String[] args) {
        System.out.println("Registrar medicamentos en farmacia");

        Marca marca = new Marca("Genfar", "Salud para todos");
        marca.setLocalizacion("Bogotá, CO");
        System.out.println("Creada Marca: " + marca);

        Composicionmedicamento comp = new Composicionmedicamento();
        comp.setId("HPD-18076");
        comp.setNombre("AnalgésicoCompo");
        comp.setPH(7.2);
        comp.setDensidad(1.05);
        comp.addIngrediente(new Ingrediente("Ibuprofeno químico"));
        comp.addIngrediente(new Ingrediente("Paracetamol químico"));
        System.out.println("Creada Composición: " + comp);

        Pastilla aspirina = new Pastilla("S-ASP-001", marca, 500.0);
        aspirina.setEsmasticable(false);
        aspirina.setCantidadporcaja(20);
        aspirina.setPeso(850);
        aspirina.setViaaplicacion("oral");
        aspirina.setFechafabricacion(2018);
        aspirina.setLugarorigen(new Lugarorigen(null, "Argentina", 0));
        System.out.println("Creada Pastilla: " + aspirina);

        Jarabe jarabe = new Jarabe("J-JAR-001", marca, 120.0);
        jarabe.setPeso(300);
        jarabe.setViaaplicacion("Oral");
        jarabe.setFechafabricacion(2019);
        jarabe.setLugarorigen(new Lugarorigen(null, "Argentina", 0));
        jarabe.setSabor("Fresa-Kiwi");
        System.out.println("Creado Jarabe: " + jarabe);

        Cliente cliente = new Cliente("Catalina Gómez", 1001);
        Factura factura = new Factura(9001, 12000.0, cliente);
        factura.setFecha("2022");
        factura.setMoneda("COP");
        factura.setFuepagada(false);
        aspirina.setFactura(factura);
        cliente.setCorreo("catysgomez07@gmail.com");
        cliente.setTelefono("310 8863361");
        System.out.println("Creada Factura: " + factura + " asociada al cliente: " + cliente);

        Pastillaliberacionprolongada plp = new Pastillaliberacionprolongada("PLP-001", 250.0, 12);
        plp.setPeso(20);
        plp.setMarcax("Dolex");
        plp.setViaaplicacion("Oral");
        plp.setFechafabricacion(2023);
        plp.setLugarorigen(new Lugarorigen(null, "Estados Unidos", 0));
        plp.setFactura(factura);
        plp.setCantidadporcaja(8);
        System.out.println("Creada Pastillaliberacionprolongada: " + plp);

        System.out.println("Impresión de objetos");

        Medicamento medGenerico = new Medicamento("GEN-001", marca);
        System.out.println(medGenerico.mostrarInstrucciones());

        System.out.println(aspirina.mostrarInstrucciones());

        System.out.println(plp.mostrarInstrucciones());

        System.out.println("Métodos sobrecargados:");
        aspirina.invocarVerificarIndicaciones();

        // Punto 1 
        // Crear un arreglo de tipo 'supersuperclase' (Medicamento) con 5 posiciones
        // y colocar 3 objetos diferentes de las subclases. Imprimir sobrescritura.
        Medicamento[] arregloPolimorfico = new Medicamento[5];
        arregloPolimorfico[0] = aspirina; // Pastilla
        arregloPolimorfico[1] = jarabe;   // Jarabe
        arregloPolimorfico[2] = plp;      // Pastillaliberacionprolongada (sub-subclase)
        arregloPolimorfico[3] = medGenerico; // Medicamento genérico
        arregloPolimorfico[4] = crearMedicamentoPrototipo("pastilla", marca); // prototipo

        System.out.println("\n--- Punto 1: Polimorfismo en arreglo (mostrarInstrucciones) ---");
        for (int i = 0; i < arregloPolimorfico.length; i++) {
            Medicamento m = arregloPolimorfico[i];
            System.out.println("Posición " + i + ": clase = " + (m != null ? m.getClass().getSimpleName() : "null"));
            if (m != null) {
                System.out.println(m.mostrarInstrucciones()); // invocación polimórfica
            }
        }

        // Punto 2
        // Dos métodos aplicando polimorfismo:
        // - uno que reciba un parámetro (procesarMedicamento)
        // - otro que retorne un tipo supersuperclase (crearMedicamentoPrototipo)
        System.out.println("\n--- Requerimiento 2: Métodos polimórficos ---");
        procesarMedicamento(plp); // recibe un Medicamento (polimorfismo por parámetro)

        Medicamento creado = crearMedicamentoPrototipo("plp", marca); // retorna un Medicamento
        System.out.println("Medicamento creado por crearMedicamentoPrototipo: " + creado.getClass().getSimpleName());
        System.out.println(creado.mostrarInstrucciones());

        // Punto 3 
        // - Atributo que no se puede cambiar: Medicamento.SISTEMA (final)
        // - Método que no se pueda sobreescribir: Medicamento.obtenerDescripcionBasica() (final)
        // - Clase que no se pueda heredar: ConstantesFarmacia (final)
        System.out.println("\n--- Requerimiento 3: Elementos final ---");
        System.out.println("Constante de sistema (atributo final): " + Medicamento.SISTEMA);
        System.out.println("Uso de método final obtenerDescripcionBasica(): " + aspirina.obtenerDescripcionBasica());
        System.out.println("Uso de clase final ConstantesFarmacia.VERSION: " + ConstantesFarmacia.VERSION);
    }

    /**
     * MÉTODO 1 (recibe parámetro) - aplica polimorfismo porque acepta la superclase Medicamento
     */
    public static void procesarMedicamento(Medicamento m) {
        System.out.println("[procesarMedicamento] Procesando instancia de: " + (m != null ? m.getClass().getSimpleName() : "null"));
        if (m == null) return;

        // Llamada polimórfica a mostrarInstrucciones()
        System.out.println(m.mostrarInstrucciones());

        // comportamiento específico según tipo (ejemplo)
        if (m instanceof Pastilla) {
            System.out.println("-> Es una Pastilla. Invocando verificación de indicaciones...");
            ((Pastilla) m).invocarVerificarIndicaciones();
        } else if (m instanceof Jarabe) {
            System.out.println("-> Es un Jarabe. Sabor: " + ((Jarabe) m).getSabor());
        }
    }

    /**
     * MÉTODO 2 (retorna la superclase) - aplica polimorfismo en el retorno
     */
    public static Medicamento crearMedicamentoPrototipo(String tipo, Marca marca) {
        if ("pastilla".equalsIgnoreCase(tipo)) {
            return new Pastilla("PROT-PST-001", marca, 100.0);
        } else if ("jarabe".equalsIgnoreCase(tipo)) {
            return new Jarabe("PROT-JAR-001", marca, 80.0);
        } else if ("plp".equalsIgnoreCase(tipo) || "pastillaliberacionprolongada".equalsIgnoreCase(tipo)) {
            return new Pastillaliberacionprolongada("PROT-PLP-001", 200.0, 8);
        } else {
            return new Medicamento("PROT-GEN-001", marca);
        }
    }
}
