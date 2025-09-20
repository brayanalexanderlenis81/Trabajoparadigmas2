package co.edu.poli.actividad5.model;

public class Pastilla extends Medicamento {
	private boolean esmasticable;
    private double mg;
    private int cantidadporcaja;

    public Pastilla() { super(); }

    public Pastilla(String serial, Marca marca, double mg) {
        super(serial, marca);
        this.mg = mg;
    }

 
    @Override
    public String mostrarInstrucciones() {
        String base = super.mostrarInstrucciones();
        String especial = "\nInstrucciones específicas para pastilla:\n"
                + "- Tomar con un vaso lleno de agua.\n"
                + "- No masticar la pastilla.";
        System.out.println("[Pastilla] mostrarInstrucciones() override invoked.");
        return base + especial;
    }

    
    public void invocarVerificarIndicaciones() {
        System.out.println("[Pastilla] Invocando verificarIndicaciones(dosis)...");
        boolean r1 = this.verificarIndicaciones("500mg");
        System.out.println("[Pastilla] Resultado verificarIndicaciones(dosis): " + r1);

        System.out.println("[Pastilla] Invocando verificarIndicaciones(dosis, edadPaciente)...");
        boolean r2 = this.verificarIndicaciones("500mg", 30);
        System.out.println("[Pastilla] Resultado verificarIndicaciones(dosis, edadPaciente): " + r2);

        System.out.println("[Pastilla] Invocando verificarIndicaciones(dosis, edadPaciente) para edad baja...");
        boolean r3 = this.verificarIndicaciones("250mg", 8);
        System.out.println("[Pastilla] Resultado (250mg, 8 años): " + r3);
    }

   
    public void setEsmasticable(boolean esmasticable) { this.esmasticable = esmasticable; }
    public double getMg() { return mg; }
    public void setCantidadporcaja(int cantidad) { this.cantidadporcaja = cantidad; }

    @Override
    public String toString() {
        return "Pastilla{" + super.toString()
                + ", mg=" + mg
                + ", esmasticable=" + esmasticable
                + ", cantidadporcaja=" + cantidadporcaja + "}";
    }
}
