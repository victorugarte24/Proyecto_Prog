package moviles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovilesTest {
	
	Moviles m = new Moviles("S20", 123, "", 1000, "Samsung", 6, "", 123, "Android");
	
	@Test
	public void test() {
		assertEquals(m.getNombre(), "S20");
		m.setNombre("S20 Plus");
		assertEquals(m.getNombre(), "S20 Plus");
	}
	
	
	
}