package ventanas;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.JLabelGraficoAjustado;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {
	private JPasswordField passwordField;
	private JTextField textField;
	private Logger logger;


	public VentanaInicio (){
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaInicio.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		setSize(600, 400);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.orange);
		getContentPane().setLayout(null);
		
		logger = Logger.getLogger( VentanaVentas.class.getName() ); 
		try {
			FileHandler fh = new FileHandler("src/logger.log");
			logger.addHandler(fh);
		} catch (SecurityException e11) {
			e11.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//usar bd
				 logger.log(Level.INFO, "Botón Iniciar Sesión ");
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
		logo.setLocation(230, 10);
		getContentPane().add(logo);

	}
	

	public static void main(String[] args) {
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);

	}
}
