package arrays;

import java.util.ArrayList;

import ordenadores.Ordenadores;


public class arrayOrdenadores {

public ArrayList<Ordenadores> arrayOrdenadores = new ArrayList<Ordenadores>();;
	
	public arrayOrdenadores(){
				
		Ordenadores hpPavilion200 = new Ordenadores("HP Pavilion 200", 11, "", 1200, "Hp", "", "I7-7300HQ", "Nvidia 1050", 12.5);
		Ordenadores AcerAspire5 = new Ordenadores("Acer Aspire5", 12, "", 1300, "Acer", "", "I7-6700HQ", "Nvidia 1050Ti", 15.9);
		Ordenadores AsusP541NA = new Ordenadores("Asus P541 NA", 13, "", 900, "Asus", "", "I7-7100HQ", "Nvidia GeForce 1300", 12.5);
		Ordenadores AppleMacbook = new Ordenadores("Apple Macbook", 14, "", 2500, "Apple", "", "MacOs", "Nvidia 1080", 12.5);
		Ordenadores LenovoIdeaPad = new Ordenadores("Lenovo IdeaPad", 15, "", 1300, "Lenovo", "", "I7-6700HQ", "Nvidia 1050T", 15.9);	
		
		arrayOrdenadores.add(hpPavilion200);
		arrayOrdenadores.add(AcerAspire5);
		arrayOrdenadores.add(AsusP541NA);
		arrayOrdenadores.add(AppleMacbook);
		arrayOrdenadores.add(LenovoIdeaPad);
	}

	public ArrayList<Ordenadores> devolverArrayElectrodomesticos() {
		return arrayOrdenadores;

	}

}
