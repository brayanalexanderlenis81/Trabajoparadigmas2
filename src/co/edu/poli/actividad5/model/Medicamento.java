package co.edu.poli.actividad5.model;
import java.time.LocalDate;
/**
 * Clase abstracta que representa un medicamento genérico.
 * Contiene atributos comunes y operaciones básicas.
 * El campo "Serial" actúa como el identificador (ID) del medicamento.
 */
public abstract class Medicamento {
    private int peso;
    private Marca marca;
    private boolean esOriginal;
    private String estado;
    private String viaaplicacion;
    private Composicionmedicamento composicionmedicamento;
    private String Serial; // ID
    private Lugarorigen lugarorigen;
    private int fechafabricacion; // año (por simplicidad)
    private Factura factura;

    public Medicamento() {}

    public Medicamento(String serial) {
        this.Serial = serial;
    }

    // Getters / Setters
    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }
    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
    public boolean isEsOriginal() { return esOriginal; }
    public void setEsOriginal(boolean esOriginal) { this.esOriginal = esOriginal; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getViaaplicacion() { return viaaplicacion; }
    public void setViaaplicacion(String viaaplicacion) { this.viaaplicacion = viaaplicacion; }
    public Composicionmedicamento getComposicionmedicamento() { return composicionmedicamento; }
    public void setComposicionmedicamento(Composicionmedicamento composicionmedicamento) { this.composicionmedicamento = composicionmedicamento; }
    public String getSerial() { return Serial; }
    public void setSerial(String serial) { this.Serial = serial; }
    public Lugarorigen getLugarorigen() { return lugarorigen; }
    public void setLugarorigen(Lugarorigen lugarorigen) { this.lugarorigen = lugarorigen; }
    public int getFechafabricacion() { return fechafabricacion; }
    public void setFechafabricacion(int fechafabricacion) { this.fechafabricacion = fechafabricacion; }
    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }

    /**
     * Devuelve el ID del medicamento (alias Serial).
     * Se usa para las operaciones CRUD por ID.
     * @return id / serial del medicamento
     */
    public String getId() {
        return this.Serial;
    }

    /**
     * Determina si el medicamento está vencido.
     * Para este ejemplo consideramos vencido si tiene más de 2 años desde la fecha de fabricación.
     * @return true si vencido, false si no
     */
    public boolean estaVencido() {
        int annoActual = LocalDate.now().getYear();
        return (annoActual - this.fechafabricacion) > 2;
    }

    /**
     * Retorna la fecha (año) de fabricación.
     * @return año de fabricación
     */
    public int calcularFechafabricacion() {
        return this.fechafabricacion;
    }

    /**
     * Verifica indicaciones mínimas según dosis.
     * Implementación protegida para uso por subclases.
     * @param dosis texto de dosis
     * @return true si válida (heurística simple)
     */
    protected boolean verificarIndicaciones(String dosis) {
        return dosis != null && !dosis.trim().isEmpty();
    }

    /**
     * Verifica indicaciones con edad del paciente.
     * @param dosis dosis indicada
     * @param edadPaciente edad del paciente
     * @return true si válida (heurística simple)
     */
    protected boolean verificarIndicaciones(String dosis, int edadPaciente) {
        if (!verificarIndicaciones(dosis)) return false;
        return edadPaciente >= 0 && edadPaciente < 120;
    }

    /**
     * Muestra instrucciones generales del medicamento.
     * Subclases pueden sobreescribir para añadir instrucciones específicas.
     * @return texto con instrucciones
     */
    public String mostrarInstrucciones() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instrucciones generales: ");
        sb.append("Verificar dosis y conservar según indicación del empaque.");
        return sb.toString();
    }
}