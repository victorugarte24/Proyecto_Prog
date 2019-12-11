package arrays;

import java.util.ArrayList;

import electrodomesticos.Electrodomesticos;
import moviles.Moviles;

public class arrayMoviles {

public ArrayList<Moviles> arrayMoviles = new ArrayList<Moviles>();;
	
	public arrayMoviles(){
				
		Moviles samsungS10 = new Moviles("Samsung S10", 5, "", 989, "Samsung", 6.2,"", 1080, "Android");
		Moviles HuaweiP30 = new Moviles("Huawei P30", 6, "", 567, "Huawei", 9,"", 720, "Android");
		Moviles LgG8 = new Moviles("LG G8", 7, "", 456, "LG", 7.2,"", 1080, "Android");
		Moviles Iphone11 = new Moviles("Iphone 11", 8, "", 1600, "Apple", 6.5,"", 1080, "Android");
		Moviles SonyXperiaZ4 = new Moviles("Sony Xperia Z4", 10, "", 670, "Sony", 7.0,"", 1080, "Android");
		
		
		
		
		arrayMoviles.add(samsungS10);
		arrayMoviles.add(HuaweiP30);
		arrayMoviles.add(LgG8);
		arrayMoviles.add(Iphone11);
		arrayMoviles.add(SonyXperiaZ4);
	}

	public ArrayList<Moviles> devolverArrayElectrodomesticos() {
		return arrayMoviles;

	}

}
