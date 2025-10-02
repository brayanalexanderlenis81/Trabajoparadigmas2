package co.edu.poli.actividad3.model;
/**
 * Entidad Cliente.
 * Contiene datos basicos de un cliente asociado a una factura.
 */
public class Cliente {

    /** Nombre del cliente. */
    private String nombre;

    /** Numero telefonico. */
    private String telefono;

    /** Identificador interno. */
    private int id;

    /** Numero de factura asociada. */
    private int factura;

    /** Correo electronico. */
    private String correo;

    /** Crea un cliente sin datos iniciales. */
    public Cliente() {}

    /**
     * Crea un cliente con datos.
     * @param id identificador del cliente
     * @param nombre nombre del cliente
     * @param telefono telefono de contacto
     * @param correo correo electronico
     * @param factura numero de factura asociada
     */
    public Cliente(int id, String nombre, String telefono, String correo, int factura) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.factura = factura;
    }

    /** @return nombre del cliente */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return telefono del cliente */
    public String getTelefono() { return telefono; }

    /** @param telefono nuevo telefono */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /** @return identificador del cliente */
    public int getId() { return id; }

    /** @param id nuevo identificador */
    public void setId(int id) { this.id = id; }

    /** @return numero de factura asociada */
    public int getFactura() { return factura; }

    /** @param factura nuevo numero de factura */
    public void setFactura(int factura) { this.factura = factura; }

    /** @return correo electronico */
    public String getCorreo() { return correo; }

    /** @param correo nuevo correo electronico */
    public void setCorreo(String correo) { this.correo = correo; }

    /** @return representacion textual del cliente */
    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', telefono='" + telefono
                + "', correo='" + correo + "', factura=" + factura + "}";
    }
}