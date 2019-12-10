package arrays;

import java.util.ArrayList;

import electrodomesticos.Electrodomesticos;

public class arrayElectrodomesticos {
	
	public ArrayList<Electrodomesticos> arrayElectrodomesticos = new ArrayList<Electrodomesticos>();;
	
	public arrayElectrodomesticos(){
				
		Electrodomesticos lavadoraLgB5 = new Electrodomesticos("Lavadora LG B5", 1234, "", 200, "LG", "", "Lavadora", 12, 200);
		
		
		
		
		arrayElectrodomesticos.add(lavadoraLgB5);
	}

	public ArrayList<Electrodomesticos> devolverArrayElectrodomesticos() {
		return arrayElectrodomesticos;

	}

}
