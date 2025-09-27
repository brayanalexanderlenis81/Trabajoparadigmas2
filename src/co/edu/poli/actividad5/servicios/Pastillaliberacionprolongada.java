package co.edu.poli.actividad5.servicios;
import co.edu.poli.actividad5.model.Pastilla;

/**
 * Subsubclase de Pastilla para representar pastillas de liberación prolongada.
 * (Esta clase se colocó en el paquete servicios según tu diagrama original).
 */
public class Pastillaliberacionprolongada extends Pastilla {
    private int horasdeliberacion;

    public Pastillaliberacionprolongada() { super(); }
    public Pastillaliberacionprolongada(String serial) { super(serial); }

    public int getHorasdeliberacion() { return horasdeliberacion; }
    public void setHorasdeliberacion(int horasdeliberacion) { this.horasdeliberacion = horasdeliberacion; }
}