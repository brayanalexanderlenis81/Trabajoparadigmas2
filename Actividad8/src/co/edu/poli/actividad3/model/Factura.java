package co.edu.poli.actividad3.model;
/**
 * Factura de compra de un medicamento.
 */
public class Factura {

    /** Numero de factura. */
    private int numero;

    /** Fecha de emision en formato libre. */
    private String fecha;

    /** Monto total. */
    private double monto;

    /** Indicador de pago. */
    private boolean fuepagada;

    /** Moneda del monto. */
    private String moneda;

    /** Descuento aplicado. */
    private double descuento;

    /** Cliente asociado. */
    private Cliente cliente;

    /** Crea una factura sin datos. */
    public Factura() {}

    /**
     * Crea una factura con datos.
     * @param numero numero de factura
     * @param fecha fecha de emision
     * @param monto monto total
     * @param fuepagada indicador de pago
     * @param moneda codigo de moneda
     * @param descuento descuento aplicado
     * @param cliente cliente asociado
     */
    public Factura(int numero, String fecha, double monto, boolean fuepagada,
                   String moneda, double descuento, Cliente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.fuepagada = fuepagada;
        this.moneda = moneda;
        this.descuento = descuento;
        this.cliente = cliente;
    }

    /** @return numero de factura */
    public int getNumero() { return numero; }

    /** @param numero nuevo numero */
    public void setNumero(int numero) { this.numero = numero; }

    /** @return fecha de emision */
    public String getFecha() { return fecha; }

    /** @param fecha nueva fecha */
    public void setFecha(String fecha) { this.fecha = fecha; }

    /** @return monto total */
    public double getMonto() { return monto; }

    /** @param monto nuevo monto */
    public void setMonto(double monto) { this.monto = monto; }

    /** @return indicador de pago */
    public boolean isFuepagada() { return fuepagada; }

    /** @param fuepagada nuevo indicador de pago */
    public void setFuepagada(boolean fuepagada) { this.fuepagada = fuepagada; }

    /** @return moneda */
    public String getMoneda() { return moneda; }

    /** @param moneda nueva moneda */
    public void setMoneda(String moneda) { this.moneda = moneda; }

    /** @return descuento aplicado */
    public double getDescuento() { return descuento; }

    /** @param descuento nuevo descuento */
    public void setDescuento(double descuento) { this.descuento = descuento; }

    /** @return cliente asociado */
    public Cliente getCliente() { return cliente; }

    /** @param cliente nuevo cliente asociado */
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    /** @return representacion textual de la factura */
    @Override
    public String toString() {
        return "Factura{numero=" + numero + ", fecha='" + fecha + "', monto=" + monto
                + ", fuepagada=" + fuepagada + ", moneda='" + moneda
                + "', descuento=" + descuento + ", cliente=" + cliente + "}";
    }
}
