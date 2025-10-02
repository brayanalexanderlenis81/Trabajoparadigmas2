package co.edu.poli.actividad3.model;
/**
 * Ingrediente quimico presente en un medicamento.
 */
public class Ingrediente {

    /** Procedencia del ingrediente. */
    private String procedencia;

    /** Nombre quimico. */
    private String nombrequimico;

    /** Unidad o tipo de medicion. */
    private String medicion;

    /** Valor de pureza. */
    private double pureza;

    /** Indicador de alergenicidad. */
    private boolean esalergenico;

    /** Identificador del ingrediente. */
    private String id;

    /** Crea un ingrediente sin datos. */
    public Ingrediente() {}

    /**
     * Crea un ingrediente con datos.
     * @param id identificador
     * @param nombrequimico nombre quimico
     * @param medicion unidad de medicion
     * @param pureza pureza declarada
     * @param esalergenico indicador de alergenicidad
     * @param procedencia procedencia del ingrediente
     */
    public Ingrediente(String id, String nombrequimico, String medicion,
                       double pureza, boolean esalergenico, String procedencia) {
        this.id = id;
        this.nombrequimico = nombrequimico;
        this.medicion = medicion;
        this.pureza = pureza;
        this.esalergenico = esalergenico;
        this.procedencia = procedencia;
    }

    /** @return procedencia */
    public String getProcedencia() { return procedencia; }

    /** @param procedencia nueva procedencia */
    public void setProcedencia(String procedencia) { this.procedencia = procedencia; }

    /** @return nombre quimico */
    public String getNombrequimico() { return nombrequimico; }

    /** @param nombrequimico nuevo nombre quimico */
    public void setNombrequimico(String nombrequimico) { this.nombrequimico = nombrequimico; }

    /** @return unidad de medicion */
    public String getMedicion() { return medicion; }

    /** @param medicion nueva unidad de medicion */
    public void setMedicion(String medicion) { this.medicion = medicion; }

    /** @return pureza declarada */
    public double getPureza() { return pureza; }

    /** @param pureza nueva pureza */
    public void setPureza(double pureza) { this.pureza = pureza; }

    /** @return indicador de alergenicidad */
    public boolean isEsalergenico() { return esalergenico; }

    /** @param esalergenico nuevo indicador de alergenicidad */
    public void setEsalergenico(boolean esalergenico) { this.esalergenico = esalergenico; }

    /** @return identificador */
    public String getId() { return id; }

    /** @param id nuevo identificador */
    public void setId(String id) { this.id = id; }

    /** @return representacion textual del ingrediente */
    @Override
    public String toString() {
        return "Ingrediente{id='" + id + "', nombrequimico='" + nombrequimico
                + "', medicion='" + medicion + "', pureza=" + pureza
                + ", esalergenico=" + esalergenico + ", procedencia='" + procedencia + "'}";
    }
}