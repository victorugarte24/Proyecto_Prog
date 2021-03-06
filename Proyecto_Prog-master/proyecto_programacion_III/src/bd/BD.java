package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import usuario.Usuario;
import ventanas.VentanaInicio;

public class BD {

	private static Exception lastError = null;  // Informacion de ultimo error SQL ocurrido
	
	private static final String NOMBRETABLA = "Usuario";
	private static final String COLUMNAS_TABLA = "(nombre string, contraseña string)";
	
	/** Inicializa una BD SQLITE y devuelve una conexion con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexiï¿½n con la base de datos indicada. Si hay algï¿½n error, se devuelve null
	 */
	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			log( Level.INFO, "Conectada base de datos " + nombreBD, null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexion de base de datos " + nombreBD, e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexion ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexiï¿½n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table "+NOMBRETABLA+COLUMNAS_TABLA);
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			log( Level.INFO, "Creada base de datos", null );
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en creacion de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE Mï¿½TODO CON PRECAUCIï¿½N. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexiï¿½n ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists "+NOMBRETABLA);
			log( Level.INFO, "Reiniciada base de datos", null );
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	/** Cierra la base de datos abierta
	 * @param con	Conexiï¿½n abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en cierre de base de datos", e );
			e.printStackTrace();
		}
	}
	
	/** Devuelve la informaciï¿½n de excepciï¿½n del ï¿½ltimo error producido por cualquiera 
	 * de los mï¿½todos de gestiï¿½n de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}
	
	// TODO CAMBIAR SELECT, UPDATE, INSERT Y DELETE
	
	
	/** Aï¿½ade una analitica a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la analitica)
	 * @param codigo	Cï¿½digo a aï¿½adir a la BD (en nueva fila)
	 * @param contador	contador a aï¿½adir a esa nueva fila de la BD
	 * @return	true si la inserciï¿½n es correcta, false en caso contrario
	 */
	public static boolean usuariosInsert( Statement st, Usuario u ) {
		String sentSQL = "";
		try {
			sentSQL = "insert into Usuario values('" + secu(u.getEmail()) + "', '"+ secu(u.getContraseña()) + "')";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
	public static String usuariosSelect( Statement st, String contraseña) {
		String sentSQL = "";
		String nombre = "";
		try {
			
			sentSQL = "select nombre from Usuario where contraseña ='" + contraseña + "'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				nombre = rs.getString("nombre");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return nombre;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return null;
		}
	}
	public static String usuariosSelect2( Statement st, String nombre) {
		String sentSQL = "";
		String contraseña = "";
		try {
			
			sentSQL = "select contraseña from Usuario where nombre ='" + nombre + "'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				contraseña = rs.getString("contraseña");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return contraseña;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return null;
		}
	}
	public static boolean usuarioExiste( Statement st, String nombre) {
		String sentSQL = "";
		try {
			
			sentSQL = "select * from Usuario where nombre ='" + nombre + "'";
			ResultSet rs = st.executeQuery( sentSQL );
			boolean existe = rs.next();
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return existe;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return false;
		}
	}

	/** Modifica una analï¿½tica en la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la analï¿½tica)
	 * @param codigo	Cï¿½digo a modificar en la base de datos
	 * @param contador	Contador a modificar de ese cï¿½digo
	 * @return	true si la inserciï¿½n es correcta, false en caso contrario
	 */
	

	/** Borrar una analï¿½tica de la tabla abierta de BD, usando la sentencia DELETE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente a la analï¿½tica)
	 * @param codigo	Cï¿½digo de analï¿½tica a borrar de la base de datos
	 * @return	true si el borrado es correcto, false en caso contrario
	 */
	public static boolean analiticaDelete( Statement st, String codigo ) {
		String sentSQL = "";
		try {
			sentSQL = "delete from x where codigo='" + secu(codigo) + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD borrada " + val + " fila\t" + sentSQL, null );
			return (val==1);
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	//                      Mï¿½todos privados                           //
	/////////////////////////////////////////////////////////////////////

	// Devuelve el string "securizado" para volcarlo en SQL
	// (Implementaciï¿½n 1) Sustituye ' por '' y quita saltos de lï¿½nea
	// (Implementaciï¿½n 2) Mantiene solo los caracteres seguros en espaï¿½ol
	private static String secu( String string ) {
		// Implementaciï¿½n (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementaciï¿½n (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZï¿?.,:;-_(){}[]-+*=<>'\"¡!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}
	

	/////////////////////////////////////////////////////////////////////
	//                      Logging                                    //
	/////////////////////////////////////////////////////////////////////
	
	private static Logger logger = null;
	// Mï¿½todo pï¿½blico para asignar un logger externo
	/** Asigna un logger ya creado para que se haga log de las operaciones de base de datos
	 * @param logger	Logger ya creado
	 */
	public static void setLogger( Logger logger ) {
		BD.logger = logger;
	}
	// Mï¿½todo local para loggear (si no se asigna un logger externo, se asigna uno local)
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BD.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				logger.addHandler( new FileHandler( "data/bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
/*Creanción de tablas*/
	
	/**public void crearTablaArticulo(Connection con) {
		String sql = "";
		try {
			Statement st = con.createStatement();
			sql = "create table Articulo(nombre string, codArt int, descripcion string, importe double, marca string, imagen string,unidades int);";
			st.executeUpdate(sql);
			st.close();
			log( Level.INFO, "BD\t" + sql, null );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sql, e );
			e.printStackTrace();
			
		}
	}
	
	public void crearTablaElectrodomestico(Connection con) {
		String sql = "";
		try {
			Statement st = con.createStatement();
			sql = "create table Electrodomestico(tipo string, peso int, tamaño double, unidades int);";
			st.executeUpdate(sql);
			st.close();
			log( Level.INFO, "BD\t" + sql, null );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sql, e );
			e.printStackTrace();
			
		}
	}
	
	public void crearTablaMovil(Connection con) {
		String sql = "";
		try {
			Statement st = con.createStatement();
			sql = "create table Movil(pantalla double, resolucion double, sisOperativo string, unidades int);";
			st.executeUpdate(sql);
			st.close();
			log( Level.INFO, "BD\t" + sql, null );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sql, e );
			e.printStackTrace();
			
		}
	}
	
	public void crearTablaOrdenador(Connection con) {
		String sql = "";
		try {
			Statement st = con.createStatement();
			sql = "create table Ordenador(procesador string, grafica string, pantalla double, unidades int);";
			st.executeUpdate(sql);
			st.close();
			log( Level.INFO, "BD\t" + sql, null );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sql, e );
			e.printStackTrace();
			
		}
	}**/
	
	/* Insertar en Tablas*/
	
	/**public static void insertarNuevoArticulo(Statement st, int codArt, String descripcion, double importe, String marca, String imagen){
		String query = "SELECT * FROM Articulo WHERE nombre='"+nombre+"' AND "
				+ "codArt='"+codArt+"' AND descripcion='"+descripcion+"' "
						+ "AND importe="+importe+" AND marca='"+marca+" AND imagen='"+imagen+"'";
		
		try {
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				//El producto SÍ está repetido
				query = "UPDATE Articulo SET Unidades = Unidades + 1 WHERE nombre='"+nombre+"' AND "
				+ "codArt='"+codArt+"' AND descripcion='"+descripcion+"' "
						+ "AND importe="+importe+" AND marca='"+marca+" AND imagen='"+imagen+"'";
				
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila actualizada " + val + " fila\t" , null );
			}else{
				//El producto NO está repetido
				query = "INSERT INTO Articulo VALUES('"+nombre+"','"+codArt+"','"
						+ descripcion + "'," + importe + ",'" + marca + ",'" + imagen +"',1)";
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila añadida " + val + " fila\t" , null );
			}
			rs.close();
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + query, e );
			lastError = e;
			e.printStackTrace();
			
		}
	
				
	}
		
	public static void insertarNuevoMovil(Statement st, double pantalla, double resolucion, String sisOperativo){
		String query = "SELECT * FROM Movil WHERE pantalla='"+pantalla+"' AND "
				+ "resolucion='"+resolucion+"' AND sisOperativo='"+sisOperativo+"'";
		
		try {
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				//El producto SÍ está repetido
				query = "UPDATE Movil SET Unidades = Unidades + 1 WHERE pantalla='"+pantalla+"' AND "
				+ "resolucion='"+resolucion+"' AND sisOperativo='"+sisOperativo+"'";
				
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila actualizada " + val + " fila\t" , null );
			}else{
				//El producto NO está repetido
				query = "INSERT INTO Movil VALUES('"+pantalla+"','"+resolucion+"','"
						+ sisOperativo +"',1)";
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila añadida " + val + " fila\t" , null );
			}
			rs.close();
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + query, e );
			lastError = e;
			e.printStackTrace();
			
		}
	
				
	}
	
	public static void insertarNuevoElectrodomestico(Statement st, String tipo, int peso, double tamaño){
		String query = "SELECT * FROM Electrodomestico WHERE tipo='"+tipo+"' AND "
				+ "peso='"+peso+"' AND tamaño='"+tamaño+"'";
		
		try {
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				//El producto SÍ está repetido
				query = "UPDATE Electrodomestico SET Unidades = Unidades + 1 WHERE tipo='"+tipo+"' AND "
				+ "peso='"+peso+"' AND tamaño='"+tamaño+"'";
				
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila actualizada " + val + " fila\t" , null );
			}else{
				//El producto NO está repetido
				query = "INSERT INTO Electrodomestico VALUES('"+tipo+"','"+peso+"','"
						+ tamaño +"',1)";
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila añadida " + val + " fila\t" , null );
			}
			rs.close();
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + query, e );
			lastError = e;
			e.printStackTrace();
			
		}
	
				
	}
	
	public static void insertarNuevoOrdenador(Statement st, String procesador, String grafica, double pantalla){
		String query = "SELECT * FROM Ordenador WHERE procesador='"+procesador+"' AND "
				+ "grafica='"+grafica+"' AND pantalla='"+pantalla+"'";
		
		try {
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				//El producto SÍ está repetido
				query = "UPDATE Ordenador SET Unidades = Unidades + 1 WHERE procesador='"+procesador+"' AND "
				+ "grafica='"+grafica+"' AND pantalla='"+pantalla+"'";
				
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila actualizada " + val + " fila\t" , null );
			}else{
				//El producto NO está repetido
				query = "INSERT INTO Ordenador VALUES('"+procesador+"','"+grafica+"','"
						+ pantalla +"',1)";
				int val = st.executeUpdate(query);
				log( Level.INFO, "BD fila añadida " + val + " fila\t" , null );
			}
			rs.close();
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + query, e );
			lastError = e;
			e.printStackTrace();
			
		}
	
				
	}**/
	
	/*Select De Articulo*/
	
	/**public static int codArtSelect( Statement st, String nombre, String descripcion, double importe, String marca, String imagen) {
		String sentSQL = "";
		int codArt = 0;
		try {
			sentSQL = "select codArt from Articulo where nombre='"+nombre+"' AND descripcion='"+ descripcion + "AND importe="+importe+" AND marca='"+marca+" AND imagen='"+imagen+"'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				codArt= rs.getInt("codArt");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return codArt;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return 0;
		}
	}
	
	public static double importeSelect( Statement st, String nombre, String descripcion, int codArt, String marca, String imagen) {
		String sentSQL = "";
		double importe = 0;
		try {
			sentSQL = "select importe from Articulo where nombre='"+nombre+"' AND descripcion='"+ descripcion + "AND codArt="+codArt+" AND marca='"+marca+" AND imagen='"+imagen+"'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				importe= rs.getDouble("importe");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return importe;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return 0;
		}
	}**/
	
	/*Select de Movil*/
	/**public static String sisOperativoSelect(Statement st, double pantalla, double resolucion) {
		String sentSQL = "";
		String sisOperativo = "";
		try {
			sentSQL = "select sisOperativo from Movil where pantalla='"+pantalla+"' AND resolucion='"+ resolucion +"'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				sisOperativo= rs.getString("sisOperativo");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return sisOperativo;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return null;
		}
	}**/
	
	/*Select de Electrodomestico*/
	
	/**public static String tipoSelect(Statement st, int peso, double tamaño) {
		String sentSQL = "";
		String tipo= "";
		try {
			sentSQL = "select tipo from Movil where peso='"+peso+"' AND tamaño='"+ tamaño +"'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				tipo= rs.getString("tipo");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return tipo;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return null;
		}		
	}**/
	
	/*Select de Ordenador*/
	
	/**public static String procesadorSelect(Statement st, String grafica, double pantalla) {
		String sentSQL = "";
		String procesador = "";
		try {
			sentSQL = "select procesador from Movil where grafica='"+grafica+"' AND pantalla='"+ pantalla +"'";
			ResultSet rs = st.executeQuery( sentSQL );
			while(rs.next()) {
				procesador= rs.getString("procesador");
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return procesador;
		} catch (Exception e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			e.printStackTrace();
			return null;
		}
	}**/	
}
	

