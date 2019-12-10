package arrays;

import java.util.ArrayList;

import ordenadores.Ordenadores;


public class arrayOrdenadores {

public ArrayList<Ordenadores> arrayOrdenadores = new ArrayList<Ordenadores>();;
	
	public arrayOrdenadores(){
				
		Ordenadores hpPavilion200 = new Ordenadores("HP Pavilion 200", 1, "", 1200, "Hp", "", "I7-6700HQ", "Nvidia 1080", 12.5);
		
		
		
		
		arrayOrdenadores.add(hpPavilion200);
	}

	public ArrayList<Ordenadores> devolverArrayElectrodomesticos() {
		return arrayOrdenadores;

	}

}
