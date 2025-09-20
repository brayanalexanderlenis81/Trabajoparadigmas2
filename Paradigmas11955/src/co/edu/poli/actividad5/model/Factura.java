package co.edu.poli.actividad5.model;

public class Factura {
	private int numero;
	private String fecha;
	private double monto;
	private boolean fuepagada; 
	private String moneda;
	private double descuento;
	private Cliente cliente;


	public Factura() {}


	public Factura(int numero, double monto, Cliente cliente) {
	this.numero = numero;
	this.monto = monto;
	this.cliente = cliente;
	}


	public int getNumero() { return numero; }
	public boolean isFuepagada() { return fuepagada; }
	public Cliente getCliente() { return cliente; }
	public void setFuepagada(boolean fuepagada) { this.fuepagada = fuepagada; }




	public void setFecha(String fecha) {
	this.fecha = fecha;
	}


	public String getFecha() {
	return this.fecha;
	}
	public void setMoneda(String moneda) {
	this.moneda = moneda;
	}


	public String getMoneda() {
	return this.moneda;
	}


	@Override
	public String toString() {
	return "Factura{numero=" + numero + ", fecha=" + fecha + ", monto=" + monto + ", fuepagada=" + fuepagada + ", moneda=" + moneda + ", descuento=" + descuento + ", cliente=" + (cliente != null ? cliente.getNombre() : "null") + "}";
	}
}
