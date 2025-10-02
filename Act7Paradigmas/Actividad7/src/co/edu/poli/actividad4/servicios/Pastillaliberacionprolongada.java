package co.edu.poli.actividad4.servicios;
import co.edu.poli.actividad3.model.Pastilla;
/**
 * Pastilla de liberacion prolongada.
 */
public class Pastillaliberacionprolongada extends Pastilla {

    /** Horas de liberacion. */
    private int horasdeliberacion;

    /** Crea una pastilla de liberacion prolongada sin datos. */
    public Pastillaliberacionprolongada() {}

    /** @return horas de liberacion */
    public int getHorasdeliberacion() { return horasdeliberacion; }

    /** @param horasdeliberacion nuevas horas de liberacion */
    public void setHorasdeliberacion(int horasdeliberacion) { this.horasdeliberacion = horasdeliberacion; }

    /** @return representacion textual de la presentacion */
    @Override
    public String toString() {
        return "PastillaLP{serial='" + getSerial() + "', horas=" + horasdeliberacion + "}";
    }
}