package arrays;

import java.util.ArrayList;

import electrodomesticos.Electrodomesticos;

public class arrayElectrodomesticos {
	
	public ArrayList<Electrodomesticos> arrayElectrodomesticos = new ArrayList<Electrodomesticos>();;
	
	public arrayElectrodomesticos(){
				
		Electrodomesticos lavadoraLgB5 = new Electrodomesticos("Lavadora LG B5", 0, "", 500, "LG", "", "Lavadora", 100, 200);
		Electrodomesticos cafeteraEspresso = new Electrodomesticos("Cafetera Espresso", 1, "", 89, "Cecotec", "", "Cafetera", 2, 20);
		Electrodomesticos frigorificoSiemens = new Electrodomesticos("Frigorífico Siemens", 2, "", 600, "Siemens", "", "Frigorífico", 250, 400);
		Electrodomesticos batidoraPhilips = new Electrodomesticos("Batidora Philips", 3, "", 80, "Philips", "", "Batidora", 1, 25);
		Electrodomesticos microPanasonic = new Electrodomesticos("Microondas Panasonic", 4, "", 150, "Panasonic", "", "Microondas", 4, 30);
		
		arrayElectrodomesticos.add(lavadoraLgB5);
		arrayElectrodomesticos.add(cafeteraEspresso);
		arrayElectrodomesticos.add(frigorificoSiemens);
		arrayElectrodomesticos.add(batidoraPhilips);
		arrayElectrodomesticos.add(microPanasonic);
	}

	public ArrayList<Electrodomesticos> devolverArrayElectrodomesticos() {
		return arrayElectrodomesticos;

	}

}
