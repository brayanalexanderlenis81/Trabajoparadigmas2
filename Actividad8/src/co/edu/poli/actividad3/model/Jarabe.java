package co.edu.poli.actividad3.model;

/**
 * Presentacion en jarabe.
 */
import java.io.Serializable;

public class Jarabe extends Medicamento implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Sabor del jarabe. */
    private String sabor;

    /** Volumen en mililitros. */
    private double volumen;

    /** Indica si incluye dosificador. */
    private boolean incluyeDosificador;

    /** Crea un jarabe sin datos. */
    public Jarabe() {}

    /** @return sabor */
    public String getSabor() { return sabor; }

    /** @param sabor nuevo sabor */
    public void setSabor(String sabor) { this.sabor = sabor; }

    /** @return volumen en mililitros */
    public double getVolumen() { return volumen; }

    /** @param volumen nuevo volumen */
    public void setVolumen(double volumen) { this.volumen = volumen; }

    /** @return indicador de dosificador */
    public boolean isIncluyeDosificador() { return incluyeDosificador; }

    /** @param incluyeDosificador nuevo indicador de dosificador */
    public void setIncluyeDosificador(boolean incluyeDosificador) { this.incluyeDosificador = incluyeDosificador; }

    /**
     * Muestra instrucciones especificas para jarabe.
     * @return indicador de ejecucion
     */
    @Override
    public boolean mostrarInstrucciones() {
        super.mostrarInstrucciones();
        System.out.println("Instrucciones especificas para jarabe:");
        System.out.println("- Agitar antes de usar.");
        System.out.println("- Utilizar el dosificador si esta disponible.");
        return true;
    }
}