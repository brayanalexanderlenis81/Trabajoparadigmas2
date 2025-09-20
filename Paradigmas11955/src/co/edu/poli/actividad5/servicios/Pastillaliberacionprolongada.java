package co.edu.poli.actividad5.servicios;
import co.edu.poli.actividad5.model.Pastilla;
public class Pastillaliberacionprolongada extends Pastilla {
	private int horasdeliberacion;
    private String marcaxd; // dato extra, opcional (puedes eliminarlo si usas Marca del padre)

    public Pastillaliberacionprolongada() {
        super();
    }

    public Pastillaliberacionprolongada(String serial, double mg, int horas) {
        super(serial, null, mg);
        this.horasdeliberacion = horas;
    }

    @Override
    public String mostrarInstrucciones() {
        String base = super.mostrarInstrucciones();
        String extra = "\nInstrucciones (liberación prolongada): tomar cada "
                + horasdeliberacion + " horas. No partir la pastilla.";
        System.out.println("[Pastillaliberacionprolongada] override mostrarInstrucciones() invoked.");
        return base + extra;
    }

    public void setMarcax(String marcaxd) {
        this.marcaxd = marcaxd;
    }

    public String getMarcax() {
        return this.marcaxd;
    }

    public int getHorasdeliberacion() {
        return horasdeliberacion;
    }

    @Override
    public String toString() {
        return "Pastillaliberacionprolongada{" + super.toString()
                + ", horasdeliberacion=" + horasdeliberacion
                + (marcaxd != null ? ", marcax=" + marcaxd : "") + "}";
    }
}
