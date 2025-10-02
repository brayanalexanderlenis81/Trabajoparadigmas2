package co.edu.poli.actividad3.model;

/**
 * Clase abstracta base para las presentaciones de medicamento.
 */
public abstract class Medicamento {

    /** Peso en unidades enteras. */
    private int peso;

    /** Marca del medicamento. */
    private Marca marca;

    /** Indica si es original. */
    private boolean esoriginal;

    /** Estado del producto. */
    private String estado;

    /** Via de aplicacion. */
    private String viaaplicacion;

    /** Composicion fisico-quimica. */
    private Composicionmedicamento composicionmedicamento;

    /** Serial o identificador unico. */
    private String serial;

    /** Lugar de origen. */
    private Lugarorigen lugarorigen;

    /** Fecha de fabricacion en anio. */
    private int fechafabricacion;

    /** Factura asociada. */
    private Factura factura;

    /** Crea un medicamento sin datos. */
    public Medicamento() {}

    /** @return peso */
    public int getPeso() { return peso; }
    /** @param peso nuevo peso */
    public void setPeso(int peso) { this.peso = peso; }

    /** @return marca */
    public Marca getMarca() { return marca; }
    /** @param marca nueva marca */
    public void setMarca(Marca marca) { this.marca = marca; }

    /** @return indicador de originalidad */
    public boolean isEsoriginal() { return esoriginal; }
    /** @param esoriginal nuevo indicador */
    public void setEsoriginal(boolean esoriginal) { this.esoriginal = esoriginal; }

    /** @return estado */
    public String getEstado() { return estado; }
    /** @param estado nuevo estado */
    public void setEstado(String estado) { this.estado = estado; }

    /** @return via de aplicacion */
    public String getViaaplicacion() { return viaaplicacion; }
    /** @param viaaplicacion nueva via */
    public void setViaaplicacion(String viaaplicacion) { this.viaaplicacion = viaaplicacion; }

    /** @return composicion del medicamento */
    public Composicionmedicamento getComposicionmedicamento() { return composicionmedicamento; }
    /** @param composicionmedicamento nueva composicion */
    public void setComposicionmedicamento(Composicionmedicamento composicionmedicamento) {
        this.composicionmedicamento = composicionmedicamento;
    }

    /** @return serial del medicamento */
    public String getSerial() { return serial; }
    /** @param serial nuevo serial */
    public void setSerial(String serial) { this.serial = serial; }

    /** @return lugar de origen */
    public Lugarorigen getLugarorigen() { return lugarorigen; }
    /** @param lugarorigen nuevo lugar de origen */
    public void setLugarorigen(Lugarorigen lugarorigen) { this.lugarorigen = lugarorigen; }

    /** @return anio de fabricacion */
    public int getFechafabricacion() { return fechafabricacion; }
    /** @param fechafabricacion nuevo anio de fabricacion */
    public void setFechafabricacion(int fechafabricacion) { this.fechafabricacion = fechafabricacion; }

    /** @return factura asociada */
    public Factura getFactura() { return factura; }
    /** @param factura nueva factura asociada */
    public void setFactura(Factura factura) { this.factura = factura; }

    /**
     * Muestra instrucciones generales y retorna true.
     * Las clases hijas pueden sobreescribir este metodo.
     * @return indicador de ejecucion
     */
    public boolean mostrarInstrucciones() {
        System.out.println("Indicaciones generales del medicamento:");
        System.out.println("- Siga las indicaciones de su medico.");
        System.out.println("- Conservar en lugar fresco y seco.");
        return true;
    }

    /** @return representacion textual basica */
    @Override
    public String toString() {
        return "Medicamento{serial='" + serial + "', estado='" + estado + "'}";
    }
}