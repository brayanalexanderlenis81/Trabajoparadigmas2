package co.edu.poli.actividad3.model;

/**
 * Pais asociado al lugar de origen.
 * El diagrama incluye ciudad, id e idioma dentro de Pais.
 */
public class Pais {

    /** Ciudad principal o referencia. */
    private String ciudad;

    /** Identificador numerico. */
    private int id;

    /** Idioma principal. */
    private String idioma;

    /** Crea un pais sin datos. */
    public Pais() {}

    /**
     * Crea un pais con datos.
     * @param id identificador
     * @param ciudad ciudad de referencia
     * @param idioma idioma principal
     */
    public Pais(int id, String ciudad, String idioma) {
        this.id = id;
        this.ciudad = ciudad;
        this.idioma = idioma;
    }

    /** @return ciudad de referencia */
    public String getCiudad() { return ciudad; }

    /** @param ciudad nueva ciudad */
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    /** @return identificador */
    public int getId() { return id; }

    /** @param id nuevo identificador */
    public void setId(int id) { this.id = id; }

    /** @return idioma principal */
    public String getIdioma() { return idioma; }

    /** @param idioma nuevo idioma */
    public void setIdioma(String idioma) { this.idioma = idioma; }

    /** @return representacion textual del pais */
    @Override
    public String toString() {
        return "Pais{id=" + id + ", ciudad='" + ciudad + "', idioma='" + idioma + "'}";
    }
}