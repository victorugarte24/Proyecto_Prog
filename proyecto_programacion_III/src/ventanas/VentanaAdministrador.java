package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.BD;
import electrodomesticos.Electrodomesticos;
import moviles.Moviles;
import ordenadores.Ordenadores;
import usuario.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VentanaAdministrador extends JFrame{
	
	public VentanaAdministrador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaAdministrador.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pNorth = new JPanel();
		pNorth.setBackground(new Color(51-204-255));
		pNorth.setBorder(new EmptyBorder(20, 10, 10, 10));
		getContentPane().add(pNorth, new BorderLayout().NORTH);
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(51-204-255));
		pSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(pSouth, new BorderLayout().SOUTH);
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(51-204-255));
		getContentPane().add(pCenter, new BorderLayout().CENTER);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdministrador.setSize(171, 20);
		pNorth.add(lblAdministrador);
		
		JPanel pMoviles = new JPanel(new GridLayout(9,9));
		pMoviles.setBackground(new Color(51-204-255));
		pMoviles.setBorder(new EmptyBorder(20, 10, 5, 10));
		pCenter.add(pMoviles);
		
		JLabel nombreMovil = new JLabel("Nombre: ");
		nombreMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreMovil.setSize(171, 20);
		pMoviles.add(nombreMovil);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setSize(375, 22);
		pMoviles.add(textField);
		textField.setColumns(10);
		
		JLabel codMovil = new JLabel("Código Artículo: ");
		codMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		codMovil.setSize(171, 20);
		pMoviles.add(codMovil);
		
		JTextField textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField1.setSize(375, 22);
		pMoviles.add(textField1);
		textField1.setColumns(10);
		
		JLabel descripcionMovil = new JLabel("Descripción: ");
		descripcionMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		descripcionMovil.setSize(171, 20);
		pMoviles.add(descripcionMovil);
		
		JTextField textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField2.setSize(375, 22);
		pMoviles.add(textField2);
		textField2.setColumns(10);
		
		JLabel importeMovil = new JLabel("Importe: ");
		importeMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		importeMovil.setSize(171, 20);
		pMoviles.add(importeMovil);
		
		JTextField textField3 = new JTextField();
		textField3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField3.setSize(375, 22);
		pMoviles.add(textField3);
		textField3.setColumns(10);
		
		JLabel marcaMovil = new JLabel("Marca: ");
		marcaMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		marcaMovil.setSize(171, 20);
		pMoviles.add(marcaMovil);
		
		JTextField textField4 = new JTextField();
		textField4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField4.setSize(375, 22);
		pMoviles.add(textField4);
		textField4.setColumns(10);
		
		JLabel pantallaMovil = new JLabel("Pantalla: ");
		pantallaMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		pantallaMovil.setSize(171, 20);
		pMoviles.add(pantallaMovil);
		
		JTextField textField5 = new JTextField();
		textField5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField5.setSize(375, 22);
		pMoviles.add(textField5);
		textField5.setColumns(10);
		
		JLabel imagenMovil = new JLabel("Imagen: ");
		imagenMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		imagenMovil.setSize(171, 20);
		pMoviles.add(imagenMovil);
		
		JTextField textField6 = new JTextField();
		textField6.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField6.setSize(375, 22);
		pMoviles.add(textField6);
		textField6.setColumns(10);
		
		JLabel resolucionMovil = new JLabel("Resolución: ");
		resolucionMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		resolucionMovil.setSize(171, 20);
		pMoviles.add(resolucionMovil);
		
		JTextField textField7 = new JTextField();
		textField7.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField7.setSize(375, 22);
		pMoviles.add(textField7);
		textField7.setColumns(10);
		
		JLabel soMovil = new JLabel("Sistema Operativo: ");
		soMovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		soMovil.setSize(171, 20);
		pMoviles.add(soMovil);
		
		JTextField textField8 = new JTextField();
		textField8.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField8.setSize(375, 22);
		pMoviles.add(textField8);
		textField8.setColumns(10);
		
		
		JPanel pOrdenadores = new JPanel(new GridLayout(9,9));
		pOrdenadores.setBorder(new EmptyBorder(20, 10, 5, 10));
		pOrdenadores.setBackground(new Color(51-204-255));
		
		JLabel nombreOrdenador = new JLabel("Nombre: ");
		nombreOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreOrdenador.setSize(171, 20);
		pOrdenadores.add(nombreOrdenador);
		
		JTextField textField9 = new JTextField();
		textField9.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField9.setSize(375, 22);
		pOrdenadores.add(textField9);
		textField9.setColumns(10);
		
		JLabel codOrdenador = new JLabel("Código Artículo: ");
		codOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		codOrdenador.setSize(171, 20);
		pOrdenadores.add(codOrdenador);
		
		JTextField textField10 = new JTextField();
		textField10.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField10.setSize(375, 22);
		pOrdenadores.add(textField10);
		textField10.setColumns(10);
		
		JLabel descripcionOrdenador = new JLabel("Descripción: ");
		descripcionOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		descripcionOrdenador.setSize(171, 20);
		pOrdenadores.add(descripcionOrdenador);
		
		JTextField textField11 = new JTextField();
		textField11.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField11.setSize(375, 22);
		pOrdenadores.add(textField11);
		textField11.setColumns(10);
		
		JLabel importeOrdenador = new JLabel("Importe: ");
		importeOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		importeOrdenador.setSize(171, 20);
		pOrdenadores.add(importeOrdenador);
		
		JTextField textField12 = new JTextField();
		textField12.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField12.setSize(375, 22);
		pOrdenadores.add(textField12);
		textField12.setColumns(10);
		
		JLabel marcaOrdenador = new JLabel("Marca: ");
		marcaOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		marcaOrdenador.setSize(171, 20);
		pOrdenadores.add(marcaOrdenador);
		
		JTextField textField13 = new JTextField();
		textField13.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField13.setSize(375, 22);
		pOrdenadores.add(textField13);
		textField13.setColumns(10);
		
		JLabel imagenOrdenador = new JLabel("Imagen: ");
		imagenOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		imagenOrdenador.setSize(171, 20);
		pOrdenadores.add(imagenOrdenador);
		
		JTextField textField14 = new JTextField();
		textField14.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField14.setSize(375, 22);
		pOrdenadores.add(textField14);
		textField14.setColumns(10);
		
		JLabel procesadorOrdenador = new JLabel("Procesador: ");
		procesadorOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		procesadorOrdenador.setSize(171, 20);
		pOrdenadores.add(procesadorOrdenador);
		
		JTextField textField15 = new JTextField();
		textField15.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField15.setSize(375, 22);
		pOrdenadores.add(textField15);
		textField15.setColumns(10);

		JLabel graficaOrdenador = new JLabel("Gráfica: ");
		graficaOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		graficaOrdenador.setSize(171, 20);
		pOrdenadores.add(graficaOrdenador);
		
		JTextField textField16 = new JTextField();
		textField16.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField16.setSize(375, 22);
		pOrdenadores.add(textField16);
		textField16.setColumns(10);
		
		JLabel pantallaOrdenador = new JLabel("Pantalla: ");
		pantallaOrdenador.setFont(new Font("Tahoma", Font.BOLD, 14));
		pantallaOrdenador.setSize(171, 20);
		pOrdenadores.add(pantallaOrdenador);
		
		JTextField textField17 = new JTextField();
		textField17.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField17.setSize(375, 22);
		pOrdenadores.add(textField17);
		textField15.setColumns(10);

		
		JPanel pElectrodomesticos = new JPanel(new GridLayout(9,9));
		pElectrodomesticos.setBackground(new Color(51-204-255));
		pElectrodomesticos.setBorder(new EmptyBorder(20, 10, 5, 10));
		
		JLabel nombreElectrodomestico = new JLabel("Nombre: ");
		nombreElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(nombreElectrodomestico);
		
		JTextField textField18 = new JTextField();
		textField18.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField18.setSize(375, 22);
		pElectrodomesticos.add(textField18);
		textField18.setColumns(10);
		
		JLabel codElectrodomestico = new JLabel("Código Artículo: ");
		codElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		codElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(codElectrodomestico);
		
		JTextField textField19 = new JTextField();
		textField19.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField19.setSize(375, 22);
		pElectrodomesticos.add(textField19);
		textField19.setColumns(10);
		
		JLabel descripcionElectrodomestico = new JLabel("Descripción: ");
		descripcionElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		descripcionElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(descripcionElectrodomestico);
		
		JTextField textField20 = new JTextField();
		textField20.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField20.setSize(375, 22);
		pElectrodomesticos.add(textField20);
		textField20.setColumns(10);
		
		JLabel importeElectrodomestico = new JLabel("Importe: ");
		importeElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		importeElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(importeElectrodomestico);
		
		JTextField textField21 = new JTextField();
		textField21.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField21.setSize(375, 22);
		pElectrodomesticos.add(textField21);
		textField21.setColumns(10);
		
		
		JLabel marcaElectrodomestico = new JLabel("Marca: ");
		marcaElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		marcaElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(marcaElectrodomestico);
		
		JTextField textField22 = new JTextField();
		textField22.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField22.setSize(375, 22);
		pElectrodomesticos.add(textField22);
		textField22.setColumns(10);
		
		JLabel imagenElectrodomestico = new JLabel("Imagen: ");
		imagenElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		imagenElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(imagenElectrodomestico);
		
		JTextField textField23 = new JTextField();
		textField23.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField23.setSize(375, 22);
		pElectrodomesticos.add(textField23);
		textField23.setColumns(10);
		
		JLabel tipoElectrodomestico = new JLabel("Tipo: ");
		tipoElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		tipoElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(tipoElectrodomestico);
		
		JTextField textField24 = new JTextField();
		textField24.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField24.setSize(375, 22);
		pElectrodomesticos.add(textField24);
		textField24.setColumns(10);
		
		JLabel pesoElectrodomestico = new JLabel("Peso: ");
		pesoElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		pesoElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(pesoElectrodomestico);
		
		JTextField textField25 = new JTextField();
		textField25.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField25.setSize(375, 22);
		pElectrodomesticos.add(textField25);
		textField25.setColumns(10);
		
		JLabel tamañoElectrodomestico = new JLabel("Tamaño: ");
		tamañoElectrodomestico.setFont(new Font("Tahoma", Font.BOLD, 14));
		tamañoElectrodomestico.setSize(171, 20);
		pElectrodomesticos.add(tamañoElectrodomestico);
		
		JTextField textField26 = new JTextField();
		textField26.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField26.setSize(375, 22);
		pElectrodomesticos.add(textField26);
		textField26.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setSize(137, 21);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {" Móviles ", " Ordenadores ", " Electrodomésticos "}));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				int selectionP = comboBox.getSelectedIndex();
				switch (selectionP){
				case 0:
					pCenter.removeAll();
					pCenter.add(pMoviles);
					pCenter.updateUI();
				break;
				case 1:
					pCenter.removeAll();
					pCenter.add(pOrdenadores);
					pCenter.updateUI();
				break;
				case 2:
					pCenter.removeAll();
					pCenter.add(pElectrodomesticos);
					pCenter.updateUI();
				break;
				}

			}
		});
		pNorth.add(comboBox);
		comboBox.setFocusable(false);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setFocusable(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = BD.initBD("data/Database");
				if(comboBox.getSelectedIndex() == 0) {
					Statement st = BD.usarCrearTablaMovil(con);
					Moviles m = new Moviles(textField.getText(), Integer.parseInt(textField1.getText()), textField2.getText(), Double. parseDouble(textField3.getText()), textField4.getText(), Double. parseDouble(textField5.getText()), textField6.getText(), Integer.parseInt(textField7.getText()), textField8.getText());
					BD.movilInsert(st, m);
				}
				if(comboBox.getSelectedIndex() == 1) {
					Statement st = BD.usarCrearTablaOrdenador(con);
					Ordenadores o = new Ordenadores(textField9.getText(), Integer.parseInt(textField10.getText()), textField11.getText(), Double. parseDouble(textField12.getText()), textField13.getText(), textField14.getText(), textField15.getText(), textField16.getText(), Double. parseDouble(textField17.getText()));
					BD.ordenadorInsert(st, o);
				}
				if(comboBox.getSelectedIndex() == 2) {
					Statement st = BD.usarCrearTablaElectrodomestico(con);
					Electrodomesticos el = new Electrodomesticos(textField18.getText(), Integer.parseInt(textField19.getText()), textField20.getText(), Double. parseDouble(textField21.getText()), textField22.getText(), textField23.getText(), textField24.getText(), Integer.parseInt(textField25.getText()), Double. parseDouble(textField26.getText()));
					BD.electrodomesticoInsert(st, el);
				}
			}
		});
		btnGuardar.setSize(129, 28);
		pSouth.add(btnGuardar);
		getContentPane().add(pSouth, new BorderLayout().SOUTH);
		
		
	}
	
	public static void main(String[] args) {
		VentanaAdministrador v = new VentanaAdministrador();
		v.setVisible(true);

	}
}
