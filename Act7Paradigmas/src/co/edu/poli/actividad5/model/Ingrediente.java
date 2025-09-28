package co.edu.poli.actividad5.model;

/**
 * Representa un ingrediente químico de la composición.
 */
public class Ingrediente {
    private String procedencia;
    private String nombrequimico;
    private String medicion;
    private double pureza;
    private boolean esalergenico;
    private String id;

    public Ingrediente() {}

    public String getProcedencia() { return procedencia; }
    public void setProcedencia(String procedencia) { this.procedencia = procedencia; }
    public String getNombrequimico() { return nombrequimico; }
    public void setNombrequimico(String nombrequimico) { this.nombrequimico = nombrequimico; }
    public String getMedicion() { return medicion; }
    public void setMedicion(String medicion) { this.medicion = medicion; }
    public double getPureza() { return pureza; }
    public void setPureza(double pureza) { this.pureza = pureza; }
    public boolean isEsalergenico() { return esalergenico; }
    public void setEsalergenico(boolean esalergenico) { this.esalergenico = esalergenico; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}