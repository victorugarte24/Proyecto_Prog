package ventanas;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Inicio extends JFrame {
	private JPasswordField passwordField;
	private JTextField textField;


	Ventana_Inicio (){
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( Ventana_Inicio.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		setSize(600, 400);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.orange);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//usar bd
			}
		});
		btnNewButton.setBounds(112, 301, 152, 21);
		btnNewButton.setFocusable(false);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Registro v = new Ventana_Registro();
				v.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(362, 301, 145, 21);
		btnNewButton_1.setFocusable(false);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(112, 124, 105, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(112, 202, 96, 31);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(362, 208, 160, 19);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(362, 132, 160, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
	

	public static void main(String[] args) {
		Ventana_Inicio v = new Ventana_Inicio();
		v.setVisible(true);

	}
}
