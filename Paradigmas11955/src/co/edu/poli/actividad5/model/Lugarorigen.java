package co.edu.poli.actividad5.model;

public class Lugarorigen {
	private Pais pais;
	private String ciudad;
	private double codigo;


	public Lugarorigen() {}


	public Lugarorigen(Pais pais, String ciudad, double codigo) {
	this.pais = pais;
	this.ciudad = ciudad;
	this.codigo = codigo;
	}


	public Pais getPais() { return pais; }
	public String getCiudad() { return ciudad; }
	public double getCodigo() { return codigo; }


	@Override
	public String toString() {
	return "Lugarorigen{ciudad=" + ciudad + ", codigo=" + codigo + ", pais=" + (pais != null ? pais.getIdioma() : "null") + "}";
	}
}
