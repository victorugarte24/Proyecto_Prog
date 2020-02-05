package usuario;

public class Usuario   { 
	
	//Atributos de la clase
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private int codigoPostal;
	private String codigoUsuario;
	private String contraseña;
	private String[] MetodoPago;
	private int cuentaBancaria;
	private int telefono;
	private String email;
	
	//Constructores de la clase
	public Usuario(String email) {
		this.email = email;
	}
	
	public Usuario(String email, String contraseña) {
		this.email = email;
		this.contraseña = contraseña;
	}
	
	public Usuario(String nombre, String apellidos, String direccion, String poblacion, int codigoPostal, String codigoUsuario, String[] MetodoPago, int cuentaBancaria, int telefono, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.codigoUsuario = codigoUsuario;
		this.cuentaBancaria = cuentaBancaria;
		this.telefono = telefono;
		this.MetodoPago = MetodoPago;
		this.email = email;
	}
	
	public Usuario(String nombre, String apellidos, String direccion, String poblacion, int codigoPostal, String contraseña, String codigoUsuario, String[] MetodoPago, int cuentaBancaria, int telefono, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.codigoUsuario = codigoUsuario;
		this.contraseña = contraseña;
		this.cuentaBancaria = cuentaBancaria;
		this.telefono = telefono;
		this.MetodoPago = MetodoPago;
	}
	
	public Usuario(String nombre, String apellidos, String email, int telefono, String contraseña) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;		
	}
	
	
	//Getters and Setters de la clase
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getMetodoPago() {
		return MetodoPago;
	}
	public void setMetodoPago(String[] MetodoPago) {
		this.MetodoPago = MetodoPago;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(int cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [email " + email + ", contraseña = " + contraseña + " ]";
	}
	
	public String toString2() {
		return "Usuario [nombre =" + nombre + ", apellidos =" + apellidos
				+ ", direccion=" + direccion + ", poblacion=" + poblacion
				+ ", codigoPostal=" + codigoPostal + ", codigoUsuario="
				+ codigoUsuario + ", contraseña =" + contraseña
				+ ", MetodoPago=" + MetodoPago + ", cuentaBancaria=" + cuentaBancaria + ", telefono=" + telefono + ",]";
	}
	
	public String toString3() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", poblacion=" + poblacion
				+ ", codigoPostal=" + codigoPostal + ", codigoUsuario="
				+ codigoUsuario + ", MetodoPago=" + MetodoPago + ", cuentaBancaria=" + cuentaBancaria + ", telefono=" + telefono + ",]";
	} 

}
