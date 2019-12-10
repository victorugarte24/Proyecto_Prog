package arrays;

import java.util.ArrayList;

import electrodomesticos.Electrodomesticos;
import moviles.Moviles;

public class arrayMoviles {

public ArrayList<Moviles> arrayMoviles = new ArrayList<Moviles>();;
	
	public arrayMoviles(){
				
		Moviles samsungS10 = new Moviles("Samsung S10", 1, "", 1000, "Samsung", 6.2,"", 1080, "Android");
		
		
		
		
		arrayMoviles.add(samsungS10);
	}

	public ArrayList<Moviles> devolverArrayElectrodomesticos() {
		return arrayMoviles;

	}

}
