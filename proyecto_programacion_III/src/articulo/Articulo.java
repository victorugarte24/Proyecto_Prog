package articulo;

public class Articulo {
	
	private String nombre;
	private String codArt;
	private String descripcion;
	private double importe;
	private String marca;

	public Articulo(String nombre, String codArt, String descripcion, double importe, String marca) {
		super();
		this.nombre = nombre;
		this.codArt = codArt;
		this.descripcion = descripcion;
		this.importe = importe;
		this.marca = marca;
	}

	public Articulo() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodArt() {
		return codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}