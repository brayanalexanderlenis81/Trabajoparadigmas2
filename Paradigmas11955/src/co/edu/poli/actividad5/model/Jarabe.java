package co.edu.poli.actividad5.model;

public class Jarabe extends Medicamento {
	private String sabor;
	private double volumenml;
	private boolean incluyedosificador;


	public Jarabe() { super(); }


	public Jarabe(String serial, Marca marca, double volumenml) {
	super(serial, marca);
	this.volumenml = volumenml;
	}
	public void setSabor(String sabor) {
	this.sabor = sabor;
	}


	public String getSabor() {
	return this.sabor;
	}


	@Override
	public String toString() {
	return "Jarabe{" + super.toString()
	+ ", sabor=" + sabor
	+ ", volumenml=" + volumenml
	+ ", incluyedosificador=" + incluyedosificador + "}";
	}
}
