package moviles;

import java.io.Serializable;

import articulo.Articulo;

public class Moviles extends Articulo implements Serializable{
	
	protected double pantalla;
	protected double resolucion;
	protected String sisOperativo;
	
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
	
	@Override
	public String toString2() {
		return  "Nombre: " + nombre + " Código: " + codArt + " Descripción: " + descripcion+ " Importe: " + importe + " Marca: " + marca + " Pantalla: " + pantalla + " Resolución: " + resolucion + " Sistema Operativo: " + sisOperativo;
	}

}
