package ventanas;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bd.BD;
import usuario.Usuario;
import utils.JLabelGraficoAjustado;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {
	private JPasswordField passwordField;
	public static JTextField textField;
	private Logger logger;
	private Connection con;
	private Statement st;
	public static Properties properties;
	public static Usuario u = new Usuario("");
	public VentanaVentas vv;


	public VentanaInicio (){
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaInicio.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		setSize(650, 450);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(new Color(51-204-255));
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

		JCheckBox chckbxRecuerdame = new JCheckBox("Recúerdame");
		chckbxRecuerdame.setBounds(504, 363, 101, 25);
		chckbxRecuerdame.setBackground(new Color(51-204-255));
		getContentPane().add(chckbxRecuerdame);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "Botón Iniciar Sesión ");
				con = BD.initBD("data/Database");
				st = BD.usarCrearTablasBD(con);
				String valorPass = new String(passwordField.getPassword());
				String nombre = textField.getText();
				
				String contraseña = BD.usuariosSelect2(st, nombre); //contraseña
				
				if(valorPass.equals("password") && nombre.equals("admin")) {
					VentanaAdministrador v = new VentanaAdministrador();
					v.setVisible(true);

				}
				else {
					if(contraseña.equals(valorPass)) {
						JOptionPane.showMessageDialog(null, "Usuario correcto");
						if(chckbxRecuerdame.isSelected()) {
							properties.setProperty("Usuario", textField.getText());
							guardarProperties();
							u.setEmail(textField.getText());
						} 
						vv = new VentanaVentas();
						vv.setVisible(true);
						dispose();

					}

					else {
						JOptionPane.showMessageDialog(null, "Usuario incorrecto");
					}

				}
				BD.cerrarBD(con, st);
			}
		});
		btnNewButton.setBounds(112, 301, 152, 26);
		btnNewButton.setFocusable(false);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro v = new VentanaRegistro();
				v.setVisible(true);
				logger.log(Level.INFO, "Botón Registrarse ");

			}
		});
		btnNewButton_1.setBounds(362, 301, 145, 26);
		btnNewButton_1.setFocusable(false);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(112, 143, 105, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(112, 218, 96, 31);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(347, 222, 160, 23);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(347, 149, 160, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabelGraficoAjustado logo = new JLabelGraficoAjustado("src/img/eShop.png", 120, 100);
		logo.setLocation(90, 10);
		getContentPane().add(logo);

		cargarProperties();

	}
	
	//guardamos las properties
	public void guardarProperties() {
		try {
			properties.storeToXML(new PrintStream("data/propiedades.xml"), "Properties de inicio de sesion");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//cargamos las properties
	public void cargarProperties() {
		properties = new Properties();
		try {
			properties.loadFromXML(new FileInputStream("data/propiedades.xml"));
			try {
				textField.setText(properties.getProperty("Usuario"));
			}catch (Exception e) {

			}
		} catch (Exception e) {

		}

	}
	

	public static void main(String[] args) {
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);

	}
}
