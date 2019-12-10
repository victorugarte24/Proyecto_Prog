package ventanas;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import bd.BD;
import usuario.Usuario;
import utils.JLabelGraficoAjustado;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class VentanaRegistro extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private Logger logger;
	private Connection con;
	private Statement st;

	VentanaRegistro(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaInicio.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		setSize(700, 500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.orange);
		getContentPane().setLayout(null);
		
		logger = Logger.getLogger( VentanaVentas.class.getName() ); 
		try {
			FileHandler fh = new FileHandler("data/logger.log");
			logger.addHandler(fh);
		} catch (SecurityException e11) {
			e11.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(100, 131, 73, 13);
		getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(100, 181, 73, 22);
		getContentPane().add(lblApellido);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(100, 240, 73, 13);
		getContentPane().add(lblEmail);

		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelfono.setBounds(100, 295, 73, 13);
		getContentPane().add(lblTelfono);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(100, 343, 89, 22);
		getContentPane().add(lblContrasea);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(Color.ORANGE);
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.setBounds(432, 408, 21, 21);
		getContentPane().add(chckbxNewCheckBox);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario(textField_2.getText(), new String(passwordField.getPassword()));
				logger.log(Level.INFO, "Botón Registrarse ");
				if(textField.getText().equals("")||textField_1.getText().equals("")|| textField_2.getText().equals("")|| textField_3.getText().equals("")|| passwordField.getText().contentEquals("")){
					JOptionPane.showMessageDialog(null, "Campos incompletos");
				}
				else {
					if(chckbxNewCheckBox.isSelected() == true) {
						con = BD.initBD("data/Database");
						st = BD.usarCrearTablasBD(con);

						if(BD.usuarioExiste(st, textField_2.getText()) == false) {
							BD.usuariosInsert(st, u);
							JOptionPane.showMessageDialog(null, "Nuevo usuario creado");
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Usuario ya existente");
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Acepte los términos y condiciones");
					}
				}
			}
		});
		btnRegistrarse.setBounds(221, 408, 129, 28);
		getContentPane().add(btnRegistrarse);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(221, 126, 375, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(221, 181, 375, 22);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(221, 235, 375, 22);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(221, 290, 375, 22);
		getContentPane().add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(221, 343, 375, 22);
		getContentPane().add(passwordField);
		
		JLabel lblAcepteLosTrminos = new JLabel("Acepte los términos y condiciones");
		lblAcepteLosTrminos.setBounds(459, 410, 202, 13);
		lblAcepteLosTrminos.addMouseListener(new MouseAdapter() {
			 @Override
             public void mouseClicked(MouseEvent e) {
				 logger.log(Level.INFO, "Label Acepte los términos y condiciones ");
				 VentanaTerminos v = new VentanaTerminos();
					v.setVisible(true);
             }
		});
		getContentPane().add(lblAcepteLosTrminos);
		
		JLabelGraficoAjustado logo = new JLabelGraficoAjustado("src/img/eShop.png", 120, 100);
		logo.setLocation(30, 10);
		getContentPane().add(logo);

	}


	public static void main(String[] args) {
		VentanaRegistro v = new VentanaRegistro();
		v.setVisible(true);

	}
}
