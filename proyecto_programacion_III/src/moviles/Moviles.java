package moviles;

import articulo.Articulo;

public class Moviles extends Articulo{
	
	private double pantalla;
	private double resolucion;
	private String sisOperativo;
	
	public Moviles(String nombre, int codArt, String descripcion, double importe, String marca, double pantalla, String imagen, int resolucion, String sisOperativo) {
		super(nombre, codArt, descripcion, importe, marca, imagen);
		this.pantalla = pantalla;
		this.resolucion = resolucion;
		this.sisOperativo = sisOperativo;
	}

	public double getPantalla() {
		return pantalla;
	}

	public void setPanatalla(double tamanyo) {
		this.pantalla = tamanyo;
	}

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public String getSisOperativo() {
		return sisOperativo;
	}

	public void setSisOperativo(String sisOperativo) {
		this.sisOperativo = sisOperativo;
	}

}
