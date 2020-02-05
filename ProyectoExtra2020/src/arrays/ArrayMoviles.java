package arrays;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import bd.BD;
import moviles.Moviles;

public class ArrayMoviles {

	public ArrayList<Moviles> arrayMoviles = new ArrayList<Moviles>();
	private Connection con;
	private Statement st;

	public ArrayMoviles(){

		Moviles samsungS10 = new Moviles("Samsung S10", 55453, "", 989, "Samsung", 6.2,"src/img/MovilSamsungS10.jpg", 1080, "Android");
		Moviles HuaweiP30 = new Moviles("Huawei P30", 653454, "", 567, "Huawei", 9,"src/img/MovilHuaweiP30.jpg", 720, "Android");
		Moviles LgG8 = new Moviles("LG G8", 74545, "", 456, "LG", 7.2,"src/img/MovilLGG8.jpg", 1080, "Android");
		Moviles Iphone11 = new Moviles("Iphone 11", 45458, "", 1600, "Apple", 6.5,"src/img/MovilIPhone11.jpg", 1080, "Android");
		Moviles SonyXperiaZ4 = new Moviles("Sony Xperia Z4", 154450, "", 670, "Sony", 7.0,"src/img/MovilSoniExperiaZ4.jpg", 1080, "Android");

		arrayMoviles.add(samsungS10);
		arrayMoviles.add(HuaweiP30);
		arrayMoviles.add(LgG8);
		arrayMoviles.add(Iphone11);
		arrayMoviles.add(SonyXperiaZ4);
		
		con = BD.initBD("data/Database");
		st = BD.usarCrearTablaMovil(con);
		BD.movilInsert(st, samsungS10);
		BD.movilInsert(st, HuaweiP30);
		BD.movilInsert(st, LgG8);
		BD.movilInsert(st, Iphone11);
		BD.movilInsert(st, SonyXperiaZ4);
		BD.cerrarBD(con, st);
	}

	public ArrayList<Moviles> devolverArrayMoviles() {
		return arrayMoviles;

	}

}