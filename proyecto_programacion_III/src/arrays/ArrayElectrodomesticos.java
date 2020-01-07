package arrays;

import java.util.ArrayList;

import electrodomesticos.Electrodomesticos;

public class ArrayElectrodomesticos {
	
public ArrayList<Electrodomesticos> arrayElectrodomesticos = new ArrayList<Electrodomesticos>();
	
	public ArrayElectrodomesticos(){
				
		Electrodomesticos lavadoraLgB5 = new Electrodomesticos("Lavadora LG B5", 010065, "", 500, "LG", "src/img/ElectrodomesticoLavadoraLG.jpg", "Lavadora", 100, 200);
		Electrodomesticos cafeteraEspresso = new Electrodomesticos("Cafetera Espresso", 145548, "", 89, "Cecotec", "src/img/ElectrodomesticoCafeteraEspresso.jpg", "Cafetera", 2, 20);
		Electrodomesticos frigorificoSiemens = new Electrodomesticos("Frigorífico Siemens", 25455, "", 600, "Siemens", "src/img/ElectrodomesticoFrigorificoSiemens.jpg", "Frigorífico", 250, 400);
		Electrodomesticos batidoraPhilips = new Electrodomesticos("Batidora Philips", 78853, "", 55, "Philips", "src/img/ElectrodomesticoBatidoraPhilips.jpg", "Batidora", 1, 25);
		Electrodomesticos microPanasonic = new Electrodomesticos("Microondas Panasonic", 445454, "", 150, "Panasonic", "src/img/ElectrodomesticoMicroondasPanasonic.jpg", "Microondas", 4, 30);
		
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