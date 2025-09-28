package co.edu.poli.actividad5.model;

/**
 * Representa el lugar de origen del medicamento.
 */
public class Lugarorigen {
    private Pais pais;
    private String ciudad;
    private double codigo;

    public Lugarorigen() {}

    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public double getCodigo() { return codigo; }
    public void setCodigo(double codigo) { this.codigo = codigo; }
}