package co.edu.poli.actividad5.model;
import java.util.ArrayList;
import java.util.List;
public class Composicionmedicamento {
	private String nombre;
	private double PH;
	private double densidad;
	private String id;
	private String medicion;

	private List<Ingrediente> ingrediente = new ArrayList<>();


	public Composicionmedicamento() {}


	public void addIngrediente(Ingrediente ing) {
	ingrediente.add(ing);
	}


	public List<Ingrediente> getIngredientes() { return ingrediente; }
	public String getId() { return id; }
	public String getNombre() { return nombre; }


	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setPH(double PH) { this.PH = PH; }
	public void setDensidad(double d) { this.densidad = d; }
	public void setId(String id) { this.id = id; }


	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Composicion{id=").append(id)
	.append(", nombre=").append(nombre)
	.append(", PH=").append(PH)
	.append(", densidad=").append(densidad)
	.append(", ingredientes=[");
	for (Ingrediente i : ingrediente) {
	sb.append(i.getNombrequimico()).append(", ");
	}
	if (!ingrediente.isEmpty()) sb.setLength(sb.length() - 2); // quitar última coma
	sb.append("]}");
	return sb.toString();
	}
}
