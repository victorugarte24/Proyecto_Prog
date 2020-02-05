package ordenadores;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrdenadoresTest {
	
	Ordenadores o = new Ordenadores("Pavilion", 1234, "Desc", 1234, "Hp", "imag", "Intel", "1080", 23);
	
	
	@Test
	public void test() {
		assertEquals(o.getNombre(), "Pavilion");
		o.setNombre("Pavilion Gaming");
		assertEquals(o.getNombre(), "Pavilion Gaming");
	}	
	
}