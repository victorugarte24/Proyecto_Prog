package arrays;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import bd.BD;
import electrodomesticos.Electrodomesticos;

public class ArrayElectrodomesticos {

	public ArrayList<Electrodomesticos> arrayElectrodomesticos = new ArrayList<Electrodomesticos>();
	private Connection con;
	private Statement st;

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

		con = BD.initBD("data/Database");
		st = BD.usarCrearTablaElectrodomestico(con);
		BD.electrodomesticoInsert(st, lavadoraLgB5);
		BD.electrodomesticoInsert(st, cafeteraEspresso);
		BD.electrodomesticoInsert(st, frigorificoSiemens);
		BD.electrodomesticoInsert(st, batidoraPhilips);
		BD.electrodomesticoInsert(st, microPanasonic);
		BD.cerrarBD(con, st);
	}

	public ArrayList<Electrodomesticos> devolverArrayElectrodomesticos() {
		return arrayElectrodomesticos;

	}

}