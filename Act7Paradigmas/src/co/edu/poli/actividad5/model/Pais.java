package co.edu.poli.actividad5.model;

/**
 * Representa un país (usado por Lugarorigen).
 */
public class Pais {
    private String ciudad;
    private int id;
    private String idioma;

    public Pais() {}

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
}