package articulo;

public class Ordenadores extends Articulo{
	
	private String procesador;
	private String grafica;
	private double panatalla;
	
	public Ordenadores(String nombre, String codArt, String descripcion, double importe, String marca,
			String procesador, String grafica, double panatalla) {
		super(nombre, codArt, descripcion, importe, marca);
		this.procesador = procesador;
		this.grafica = grafica;
		this.panatalla = panatalla;
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

	public double getPanatalla() {
		return panatalla;
	}

	public void setPanatalla(double panatalla) {
		this.panatalla = panatalla;
	}
	
	

}