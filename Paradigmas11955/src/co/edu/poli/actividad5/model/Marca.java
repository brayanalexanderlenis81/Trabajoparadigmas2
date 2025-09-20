package co.edu.poli.actividad5.model;

public class Marca {
	private String localizacion;
	private String id;
	private String slogan;


	public Marca() {}
	public Marca(String id, String slogan) {
	this.id = id;
	this.slogan = slogan;
	}


	public String getId() { return id; }
	public String getLocalizacion() { return localizacion; }
	public String getSlogan() { return slogan; }
	public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }


	@Override
	public String toString() {
	return "Marca{id=" + id + ", localizacion=" + localizacion + ", slogan=" + slogan + "}";
	}
}
