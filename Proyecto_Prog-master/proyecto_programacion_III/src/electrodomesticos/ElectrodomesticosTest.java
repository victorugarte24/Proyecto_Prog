package electrodomesticos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ElectrodomesticosTest {
	
	Electrodomesticos o = new Electrodomesticos("Electrodomestico", 12345, "", 12345, "marca", "imagen", "tipo", 123, 123);
	
	@Test
	public void test() {
		assertEquals(o.getNombre(), "Electrodomestico");
		o.setNombre("Electrodomestico Bosch");
		assertEquals(o.getNombre(), "Electrodomestico Bosch");
	}
	
}