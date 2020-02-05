package ordenadores;

import articulo.Articulo;

public class Ordenadores extends Articulo{
	
	private String procesador;
	private String grafica;
	private double pantalla;
	
	public Ordenadores(String nombre, int codArt, String descripcion, double importe, String marca,String imagen, String procesador, String grafica, double pantalla) {
		super(nombre, codArt, descripcion, importe, marca, imagen);
		this.procesador = procesador;
		this.grafica = grafica;
		this.pantalla = pantalla;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getGrafica() {
		return grafica;
	}

	public void setGrafica(String grafica) {
		this.grafica = grafica;
	}

	public double getPantalla() {
		return pantalla;
	}

	public void setPantalla(double pantalla) {
		this.pantalla = pantalla;
	}
	
	@Override
	public String toString2() {
		return  "Nombre: " + nombre + " Código: " + codArt + " Descripción: " + descripcion+ " Importe: " + importe + " Marca: " + marca + " Procesador: " + procesador + " Gráfica: " + grafica + " Pantalla: " + pantalla;
	}
	
	

}
