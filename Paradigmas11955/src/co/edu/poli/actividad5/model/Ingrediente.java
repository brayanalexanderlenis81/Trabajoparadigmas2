package co.edu.poli.actividad5.model;

public class Ingrediente {
	private String procedencia;
	private String nombrequimico;
	private String medicion;
	private double pureza;
	private boolean esalergenico;
	private String id;


	public Ingrediente() {}


	public Ingrediente(String nombrequimico) {
	this.nombrequimico = nombrequimico;
	}


	public String getNombrequimico() { return nombrequimico; }
	public String getId() { return id; }
	public void setProcedencia(String p) { this.procedencia = p; }
	public void setPureza(double p) { this.pureza = p; }


	@Override
	public String toString() {
	return "Ingrediente{id=" + id + ", nombreQuimico=" + nombrequimico + ", procedencia=" + procedencia+ ", pureza=" + pureza + ", alergeno=" + esalergenico + "}";
	}
}
