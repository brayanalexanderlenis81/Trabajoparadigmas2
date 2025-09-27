package co.edu.poli.actividad5.model;

/**
 * Subclase de Medicamento que representa un jarabe.
 */
public class Jarabe extends Medicamento {
    private String sabor;
    private double volumenml;
    private boolean incluyedosificador;

    public Jarabe() { super(); }
    public Jarabe(String serial) { super(serial); }

    public String getSabor() { return sabor; }
    public void setSabor(String sabor) { this.sabor = sabor; }
    public double getVolumenml() { return volumenml; }
    public void setVolumenml(double volumenml) { this.volumenml = volumenml; }
    public boolean isIncluyedosificador() { return incluyedosificador; }
    public void setIncluyedosificador(boolean incluyedosificador) { this.incluyedosificador = incluyedosificador; }
}