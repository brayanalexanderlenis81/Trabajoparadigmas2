package co.edu.poli.actividad5.model;

public class Pais {
	private String ciudad;
	private int id;
	private String idioma;


	public Pais() {}
	public Pais(String idioma) { this.idioma = idioma; }


	public String getIdioma() { return idioma; }
	public int getId() { return id; }
	public String getCiudad() { return ciudad; }


	@Override
	public String toString() {
	return "Pais{id=" + id + ", ciudad=" + ciudad + ", idioma=" + idioma + "}";
	}
}
