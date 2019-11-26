package articulo;

public class Articulo {
	
	private String nombre;
	private int codArt;
	private String descripcion;
	private double importe;
	private String marca;
	private String imagen;

	public Articulo(String nombre, int codArt, String descripcion, double importe, String marca, String imagen) {
		super();
		this.codArt = codArt;
		this.marca = marca;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.importe = importe;
		this.imagen = imagen;
	
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public int getCodArt() {
		return codArt;
	}

	public void setCodArt(int codArt) {
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
	
	@Override
	public String toString() {
		return  codArt + " "   + marca +  " " + nombre +   " " + descripcion + " " +  importe + " $";
	}
	
}
