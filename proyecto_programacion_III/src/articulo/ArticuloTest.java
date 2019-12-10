package articulo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArticuloTest {
	
	Articulo a = new Articulo("Articulo", 1233, "", 1234, "", "");
	
	
	@Test
	public void test() {
		assertEquals(a.getNombre(), "Articulo");
		a.setNombre("Articulo Gaming");
		assertEquals(a.getNombre(), "Articulo Gaming");
	}

}
