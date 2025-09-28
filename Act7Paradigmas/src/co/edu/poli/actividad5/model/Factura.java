package co.edu.poli.actividad5.model;

/**
 * Representa una factura asociada a un medicamento.
 */
public class Factura {
    private int numero;
    private String fecha;
    private double monto;
    private boolean fuepagada;
    private String moneda;
    private double descuento;
    private Cliente cliente;

    public Factura() {}

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public boolean isFuepagada() { return fuepagada; }
    public void setFuepagada(boolean fuepagada) { this.fuepagada = fuepagada; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}