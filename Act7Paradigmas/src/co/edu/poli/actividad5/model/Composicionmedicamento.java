package co.edu.poli.actividad5.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa la composición de un medicamento. Contiene una lista de ingredientes.
 */
public class Composicionmedicamento {
    private String nombre;
    private double ph;
    private double densidad;
    private String id;
    private String medicion;
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public Composicionmedicamento() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPh() { return ph; }
    public void setPh(double ph) { this.ph = ph; }
    public double getDensidad() { return densidad; }
    public void setDensidad(double densidad) { this.densidad = densidad; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMedicion() { return medicion; }
    public void setMedicion(String medicion) { this.medicion = medicion; }
    public List<Ingrediente> getIngredientes() { return ingredientes; }
    public void addIngrediente(Ingrediente ing) { if (ing != null) this.ingredientes.add(ing); }
}