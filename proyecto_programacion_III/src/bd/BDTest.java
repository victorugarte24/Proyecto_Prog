package bd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import usuario.Usuario;

public class BDTest {
	
	private Connection con;
	private Statement st;
	
	@Test
	public void test() {
		con = BD.initBD("data/Database");
		st = BD.usarCrearTablasBD(con);
		Usuario u = new Usuario("b@gmail.com", "4321");
		BD.usuariosInsert(st, u);
		
		assertEquals("4321", BD.usuariosSelect2(st, "b@gmail.com")); //devuelve la contraseña esperada de la BD
		
		assertTrue(BD.usuarioExiste(st, "b@gmail.com")); //El usuario insertado existe en la BD

	}

	//assertNotNull(st);
	//assertEquals("4321", BD.usuariosSelect(st, "victor"));
		
	
}