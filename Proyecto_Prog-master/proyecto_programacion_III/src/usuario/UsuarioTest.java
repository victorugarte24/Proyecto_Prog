package usuario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usuario.Usuario;

public class UsuarioTest {
	
		
		Usuario u1 = new Usuario("Nombre", "Apellido", "Calle Falsa", "Ciudad", 01005, "12345", "342", null, 12345, 12345, "v@gmail.com");
				
		
		@Test
		public void test() {
			assertEquals(u1.getNombre(), "Nombre");
			u1.setNombre("Victor");
			assertEquals(u1.getNombre(), "Victor");
		}
			
		//assertNotNull(st);
		//assertEquals("4321", BD.usuariosSelect(st, "victor"));
		//assertTrue(BD.apuestasInsert(st, nombre, apuestas, gananciaTotal, importeApostado));
	
}