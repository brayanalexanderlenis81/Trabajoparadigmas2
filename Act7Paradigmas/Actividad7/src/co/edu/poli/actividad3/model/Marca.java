package co.edu.poli.actividad3.model;

/**
 * Marca del medicamento.
 */
public class Marca {

    /** Localizacion de la marca. */
    private String localizacion;

    /** Identificador de la marca. */
    private String id;

    /** Slogan de la marca. */
    private String slogan;

    /** Crea una marca sin datos. */
    public Marca() {}

    /**
     * Crea una marca con datos.
     * @param id identificador
     * @param localizacion localizacion
     * @param slogan slogan
     */
    public Marca(String id, String localizacion, String slogan) {
        this.id = id;
        this.localizacion = localizacion;
        this.slogan = slogan;
    }

    /** @return localizacion */
    public String getLocalizacion() { return localizacion; }

    /** @param localizacion nueva localizacion */
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }

    /** @return identificador de la marca */
    public String getId() { return id; }

    /** @param id nuevo identificador */
    public void setId(String id) { this.id = id; }

    /** @return slogan */
    public String getSlogan() { return slogan; }

    /** @param slogan nuevo slogan */
    public void setSlogan(String slogan) { this.slogan = slogan; }

    /** @return representacion textual de la marca */
    @Override
    public String toString() {
        return "Marca{id='" + id + "', localizacion='" + localizacion + "', slogan='" + slogan + "'}";
    }
}