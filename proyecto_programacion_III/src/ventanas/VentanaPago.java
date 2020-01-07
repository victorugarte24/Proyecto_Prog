package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JDialog;

public class VentanaPago extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String Usuario;
	private JTextField textField_3;
	
	VentanaPago(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaInicio.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(51-204-255));
		
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().setLayout(null);
		
		JLabel lblNumeroDeTarjeta = new JLabel("Número de tarjeta:");
		lblNumeroDeTarjeta.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNumeroDeTarjeta.setBounds(75, 71, 148, 27);
		getContentPane().add(lblNumeroDeTarjeta);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFecha.setBounds(75, 146, 64, 21);
		getContentPane().add(lblFecha);
		
		JLabel lblNmeroSecreto = new JLabel("Número secreto:");
		lblNmeroSecreto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNmeroSecreto.setBounds(75, 211, 148, 27);
		getContentPane().add(lblNmeroSecreto);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(248, 74, 268, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(248, 146, 28, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(248, 214, 96, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(215, 288, 138, 36);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") && textField_1.getText().equals("") && textField_2.getText().equals("") && textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Pago Incorrecto");
				}
				else {
					JOptionPane.showMessageDialog(null, "Pago Correcto");
					dispose();

				}
				
			}
		});
		getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(286, 147, 19, 15);
		getContentPane().add(label);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(306, 146, 28, 20);
		getContentPane().add(textField_3);
		
	}
}
