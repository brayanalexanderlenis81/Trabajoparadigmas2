package co.edu.poli.actividad3.model;
/**
 * Presentacion en pastilla.
 */
public class Pastilla extends Medicamento {

    /** Indica si es masticable. */
    private boolean esmasticable;

    /** Miligramos de principio activo. */
    private double mg;

    /** Cantidad por caja. */
    private int cantidadporcaja;

    /** Crea una pastilla sin datos. */
    public Pastilla() {}

    /** @return indicador masticable */
    public boolean isEsmasticable() { return esmasticable; }

    /** @param esmasticable nuevo indicador */
    public void setEsmasticable(boolean esmasticable) { this.esmasticable = esmasticable; }

    /** @return miligramos de principio activo */
    public double getMg() { return mg; }

    /** @param mg nueva cantidad en miligramos */
    public void setMg(double mg) { this.mg = mg; }

    /** @return cantidad por caja */
    public int getCantidadporcaja() { return cantidadporcaja; }

    /** @param cantidadporcaja nueva cantidad por caja */
    public void setCantidadporcaja(int cantidadporcaja) { this.cantidadporcaja = cantidadporcaja; }

    /**
     * Muestra instrucciones especificas para pastilla.
     * @return indicador de ejecucion
     */
    @Override
    public boolean mostrarInstrucciones() {
        super.mostrarInstrucciones();
        System.out.println("Instrucciones especificas para pastilla:");
        System.out.println("- Tomar con vaso lleno de agua.");
        System.out.println("- No masticar la pastilla.");
        return true;
    }

    /** @return representacion textual de la pastilla */
    @Override
    public String toString() {
        return "Pastilla{serial='" + getSerial() + "', mg=" + mg + ", masticable=" + esmasticable + "}";
    }
}