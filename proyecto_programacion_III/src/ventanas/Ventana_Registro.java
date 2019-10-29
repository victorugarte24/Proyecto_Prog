package ventanas;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Ventana_Registro extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	Ventana_Registro(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( Ventana_Inicio.DISPOSE_ON_CLOSE );
		setTitle("");
		setSize(700, 500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.orange);
		getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(100, 107, 73, 13);
		getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(100, 161, 73, 22);
		getContentPane().add(lblApellido);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(100, 224, 73, 13);
		getContentPane().add(lblEmail);

		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelfono.setBounds(100, 279, 73, 13);
		getContentPane().add(lblTelfono);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(100, 330, 89, 22);
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
				if(textField.getText().equals("")||textField_1.getText().equals("")|| textField_2.getText().equals("")|| textField_3.getText().equals("")|| passwordField.getText().contentEquals("")){
					JOptionPane.showMessageDialog(null, "Campos incompletos");
				}else {
					if(chckbxNewCheckBox.isSelected() == true) {
						JOptionPane.showMessageDialog(null, "Usuario registrado");
					}
					else {
						JOptionPane.showMessageDialog(null, "Acepte los términos y condiciones");
					}
				}
			}
		});
		btnRegistrarse.setBounds(221, 408, 129, 21);
		getContentPane().add(btnRegistrarse);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(221, 102, 375, 22);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(221, 161, 375, 22);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(221, 223, 375, 22);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(221, 278, 375, 22);
		getContentPane().add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(221, 330, 375, 22);
		getContentPane().add(passwordField);
		
		JLabel lblAcepteLosTrminos = new JLabel("Acepte los términos y condiciones");
		lblAcepteLosTrminos.setBounds(459, 410, 202, 13);
		getContentPane().add(lblAcepteLosTrminos);

	}


	public static void main(String[] args) {
		Ventana_Registro v = new Ventana_Registro();
		v.setVisible(true);

	}
}
