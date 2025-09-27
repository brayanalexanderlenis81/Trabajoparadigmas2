package co.edu.poli.actividad5.model;

/**
 * Representa un cliente asociado a la factura.
 */
public class Cliente {
    private String nombre;
    private String telefono;
    private int id;
    private int factura;
    private String correo;

    public Cliente() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getFactura() { return factura; }
    public void setFactura(int factura) { this.factura = factura; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}