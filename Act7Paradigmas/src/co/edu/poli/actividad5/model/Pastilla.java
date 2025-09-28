package co.edu.poli.actividad5.model;

/**
 * Subclase de Medicamento que representa una pastilla/tabla.
 */
public class Pastilla extends Medicamento {
    private boolean esmasticable;
    private double mg;
    private int cantidadporcaja;

    public Pastilla() { super(); }
    public Pastilla(String serial) { super(serial); }

    public boolean isEsmasticable() { return esmasticable; }
    public void setEsmasticable(boolean esmasticable) { this.esmasticable = esmasticable; }
    public double getMg() { return mg; }
    public void setMg(double mg) { this.mg = mg; }
    public int getCantidadporcaja() { return cantidadporcaja; }
    public void setCantidadporcaja(int cantidadporcaja) { this.cantidadporcaja = cantidadporcaja; }

    @Override
    public String mostrarInstrucciones() {
        String base = super.mostrarInstrucciones();
        return base + " Instrucciones Pastilla: Tomar con un vaso lleno de agua. No masticar si no es masticable.";
    }
}
