package arrays;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import bd.BD;
import ordenadores.Ordenadores;


public class ArrayOrdenadores {

	public ArrayList<Ordenadores> arrayOrdenadores = new ArrayList<Ordenadores>();
	private Connection con;
	private Statement st;

	public ArrayOrdenadores(){

		Ordenadores hpPavilion200 = new Ordenadores("HP Pavilion 200", 11343, "", 1200, "Hp", "src/img/OrdenadorHPPavilion.jpg", "I7-7300HQ", "Nvidia 1050", 12.5);
		Ordenadores AcerAspire5 = new Ordenadores("Acer Aspire5", 12343, "", 1300, "Acer", "src/img/OrdenadorAcerAspire5.jpg", "I7-6700HQ", "Nvidia 1050Ti", 15.9);
		Ordenadores AsusP541NA = new Ordenadores("Asus P541 NA", 64433, "", 900, "Asus", "src/img/OrdenadorAsusP541NA.jpg", "I7-7100HQ", "Nvidia GeForce 1300", 12.5);
		Ordenadores AppleMacbook = new Ordenadores("Apple Macbook", 565414, "", 2500, "Apple", "src/img/OrdenadoAppleMacBook.jpg", "MacOs", "Nvidia 1080", 12.5);
		Ordenadores LenovoIdeaPad = new Ordenadores("Lenovo IdeaPad", 77615, "", 1300, "Lenovo", "src/img/OrdenadorLenovoIdeapad.jpg", "I7-6700HQ", "Nvidia 1050T", 15.9);	

		arrayOrdenadores.add(hpPavilion200);
		arrayOrdenadores.add(AcerAspire5);
		arrayOrdenadores.add(AsusP541NA);
		arrayOrdenadores.add(AppleMacbook);
		arrayOrdenadores.add(LenovoIdeaPad);
		
		con = BD.initBD("data/Database");
		st = BD.usarCrearTablaOrdenador(con);
		BD.ordenadorInsert(st, hpPavilion200);
		BD.ordenadorInsert(st, AcerAspire5);
		BD.ordenadorInsert(st, AsusP541NA);
		BD.ordenadorInsert(st, AppleMacbook);
		BD.ordenadorInsert(st, LenovoIdeaPad);
		BD.cerrarBD(con, st);
	}

	public ArrayList<Ordenadores> devolverArrayOrdenadores() {
		return arrayOrdenadores;

	}

}
