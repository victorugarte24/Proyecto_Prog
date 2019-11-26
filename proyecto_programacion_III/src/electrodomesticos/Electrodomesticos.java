package electrodomesticos;

import articulo.Articulo;

public class Electrodomesticos extends Articulo{
	
	private String tipo;
	private int peso;
	private double tamaño;
	
	public Electrodomesticos(String nombre, int codArt, String descripcion, double importe, String marca, String imagen, String tipo, int peso, double tamaño) {
		super(nombre, codArt, descripcion, importe, marca, imagen);
		this.tipo = tipo;
		this.peso = peso;
		this.tamaño = tamaño;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getTamaño() {
		return tamaño;
	}

	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}

}
