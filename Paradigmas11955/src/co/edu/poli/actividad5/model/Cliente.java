package co.edu.poli.actividad5.model;

public class Cliente {
	private String nombre;
	private String telefono;
	private int id;
	private int factura; 
	private String correo;


	public Cliente() {}
	public Cliente(String nombre, int id) {
	this.nombre = nombre;
	this.id = id;
	}


	public String getNombre() { return nombre; }
	public int getId() { return id; }
	public void setTelefono(String telefono) {
	this.telefono = telefono;
	}


	public String getTelefono() {
	return this.telefono;
	}
	public void setCorreo(String correo) {
	this.correo = correo;
	}


	public String getCorreo() {
	return this.correo;
	}
	@Override
	public String toString() {
	return "Cliente{id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "}";
	}
}
