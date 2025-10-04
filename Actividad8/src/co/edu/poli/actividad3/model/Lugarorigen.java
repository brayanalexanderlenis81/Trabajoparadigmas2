package co.edu.poli.actividad3.model;

/**
 * Lugar de origen del medicamento.
 */
public class Lugarorigen {

    /** Pais asociado. */
    private Pais pais;

    /** Ciudad del lugar de origen. */
    private String ciudad;

    /** Codigo interno. */
    private double codigo;

    /** Crea un lugar de origen sin datos. */
    public Lugarorigen() {}

    /**
     * Crea un lugar de origen con datos.
     * @param pais pais asociado
     * @param ciudad ciudad de origen
     * @param codigo codigo interno
     */
    public Lugarorigen(Pais pais, String ciudad, double codigo) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.codigo = codigo;
    }

    /** @return pais asociado */
    public Pais getPais() { return pais; }

    /** @param pais nuevo pais */
    public void setPais(Pais pais) { this.pais = pais; }

    /** @return ciudad del lugar de origen */
    public String getCiudad() { return ciudad; }

    /** @param ciudad nueva ciudad */
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    /** @return codigo interno */
    public double getCodigo() { return codigo; }

    /** @param codigo nuevo codigo */
    public void setCodigo(double codigo) { this.codigo = codigo; }

    /** @return representacion textual del lugar de origen */
    @Override
    public String toString() {
        return "Lugarorigen{pais=" + pais + ", ciudad='" + ciudad + "', codigo=" + codigo + "}";
    }
}