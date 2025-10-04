package co.edu.poli.actividad3.model;
/**
 * Datos de composicion fisico-quimica de un medicamento.
 */
public class Composicionmedicamento {

    /** Nombre de la composicion. */
    private String nombre;

    /** Valor de pH. */
    private double pH;

    /** Densidad. */
    private double densidad;

    /** Unidad o tipo de medicion. */
    private String medicion;

    /** Identificador de la composicion. */
    private String id;

    /** Ingrediente principal. */
    private Ingrediente ingrediente;

    /** Crea una composicion sin datos. */
    public Composicionmedicamento() {}

    /**
     * Crea una composicion con datos.
     * @param id identificador
     * @param nombre nombre de la composicion
     * @param pH valor de pH
     * @param densidad densidad
     * @param medicion unidad de medicion
     * @param ingrediente ingrediente principal
     */
    public Composicionmedicamento(String id, String nombre, double pH, double densidad,
                                  String medicion, Ingrediente ingrediente) {
        this.id = id;
        this.nombre = nombre;
        this.pH = pH;
        this.densidad = densidad;
        this.medicion = medicion;
        this.ingrediente = ingrediente;
    }

    /** @return nombre de la composicion */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return valor de pH */
    public double getpH() { return pH; }

    /** @param pH nuevo valor de pH */
    public void setpH(double pH) { this.pH = pH; }

    /** @return densidad */
    public double getDensidad() { return densidad; }

    /** @param densidad nueva densidad */
    public void setDensidad(double densidad) { this.densidad = densidad; }

    /** @return unidad de medicion */
    public String getMedicion() { return medicion; }

    /** @param medicion nueva unidad de medicion */
    public void setMedicion(String medicion) { this.medicion = medicion; }

    /** @return identificador de la composicion */
    public String getId() { return id; }

    /** @param id nuevo identificador */
    public void setId(String id) { this.id = id; }

    /** @return ingrediente principal */
    public Ingrediente getIngrediente() { return ingrediente; }

    /** @param ingrediente nuevo ingrediente principal */
    public void setIngrediente(Ingrediente ingrediente) { this.ingrediente = ingrediente; }

    /** @return representacion textual de la composicion */
    @Override
    public String toString() {
        return "Composicion{ id='" + id + "', nombre='" + nombre + "', pH=" + pH
                + ", densidad=" + densidad + ", medicion='" + medicion
                + "', ingrediente=" + ingrediente + " }";
    }
}
