package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import electrodomesticos.Electrodomesticos;
import moviles.Moviles;
import ordenadores.Ordenadores;
import usuario.Usuario;
import ventanas.VentanaInicio;

public class BD {

	private static Exception lastError = null;  // Informacion de ultimo error SQL ocurrido
	
	private static final String NOMBRETABLA = "Usuario";
	private static final String COLUMNAS_TABLA = "(nombre string, contraseña string)";
	
	private static final String TABLAORDENADOR = "Ordenador";
	private static final String COLUMNAS_ORDENADOR = "(nombre string, codigo string, descripcion string, importe string, marca string, imagen string, procesador string, grafica string, pantalla string)";
															
	private static final String TABLAELECTRODOMESTICO = "Electrodomestico";
	private static final String COLUMNAS_ELECTRODOMESTICO = "(nombre string, codigo string, descripcion string, importe string, marca string, imagen string, tipo string, peso string, tamaño string)";
	
	private static final String TABLAMOVIL = "Movil";
	private static final String COLUMNAS_MOVIL = "(nombre string, codigo string, descripcion string, importe string, marca string, imagen string, pantalla string, resolucion string, sisOperativo string)";
	
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
		}
		catch (ClassNotFoundException | SQLException e) {
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

	public static Statement usarCrearTablaOrdenador( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table "+ TABLAORDENADOR + COLUMNAS_ORDENADOR);
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
	
	public static Statement usarCrearTablaElectrodomestico( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table "+ TABLAELECTRODOMESTICO + COLUMNAS_ELECTRODOMESTICO);
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
	
	public static Statement usarCrearTablaMovil( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table "+ TABLAMOVIL + COLUMNAS_MOVIL);
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
	
	public static boolean electrodomesticoInsert( Statement st, Electrodomesticos e ) {
		String sentSQL = "";
		try {
			sentSQL = "insert into Electrodomestico values('" + secu(e.getNombre()) + "', '"+ secu(String.valueOf(e.getCodArt())) + "', '"+ secu(e.getDescripcion()) 
			+ "', '"+ secu(Double. toString(e.getImporte())) + "', '"+ secu(e.getMarca() + "', '"+ secu(e.getImagen()))+ "', '"+ secu(e.getTipo()) + "', '"
			+ secu(String.valueOf(e.getPeso())) + "', '"+ secu(Double. toString(e.getTamaño())) + "')";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException z) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, z );
			lastError = z;
			z.printStackTrace();
			return false;
		}
	}

	public static boolean ordenadorInsert( Statement st, Ordenadores o ) {
		String sentSQL = "";
		try {
			sentSQL = "insert into Ordenador values('" + secu(o.getNombre()) + "', '"+ secu(String.valueOf(o.getCodArt())) + "', '"+ secu(o.getDescripcion()) 
			+ "', '"+ secu(Double. toString(o.getImporte())) + "', '"+ secu(o.getMarca() + "', '"+ secu(o.getImagen()))+ "', '"+ secu(o.getProcesador()) + "', '"
			+ secu(o.getGrafica()) + "', '"+ secu(Double. toString(o.getPantalla())) + "')";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException z) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, z );
			lastError = z;
			z.printStackTrace();
			return false;
		}
	}

	public static boolean movilInsert( Statement st, Moviles m) {
		String sentSQL = "";
		try {
			sentSQL = "insert into Movil values('" + secu(m.getNombre()) + "', '"+ secu(String.valueOf(m.getCodArt())) + "', '"+ secu(m.getDescripcion()) 
			+ "', '"+ secu(Double. toString(m.getImporte())) + "', '"+ secu(m.getMarca() + "', '"+ secu(m.getImagen()))+ "', '"+ secu(Double. toString(m.getPantalla())) + "', '"
			+ secu(String.valueOf(m.getResolucion())) + "', '"+ secu(m.getSisOperativo()) + "')";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD fila añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException z) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, z );
			lastError = z;
			z.printStackTrace();
			return false;
		}
	}
	
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
	
	public static String electrodomesticoSelect( Statement st, String codArt) {
		String sentSQL = "";
		String nombre = "";
		try {
			
			sentSQL = "select nombre from Electrodomestico where codigo ='" + codArt + "'";
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
	
	public static String movilSelect( Statement st, String codArt) {
		String sentSQL = "";
		String nombre = "";
		try {
			
			sentSQL = "select nombre from Movil where codigo ='" + codArt + "'";
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
	
}
	

