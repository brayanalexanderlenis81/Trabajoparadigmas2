package co.edu.poli.actividad5.model;

/**
 * Representa la marca asociada a un medicamento.
 */
public class Marca {
    private String localizacion;
    private String id;
    private String slogan;

    public Marca() {}

    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getSlogan() { return slogan; }
    public void setSlogan(String slogan) { this.slogan = slogan; }
}
