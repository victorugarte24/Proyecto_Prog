package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.JLabelGraficoAjustado;

public class VentanaPago extends JFrame{
	
	private JTextField textField;
	private JTextField textField_1;
	String Usuario;
	private JTextField textField_3;
	private JPasswordField passwordField;
	int key;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	
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
		lblNumeroDeTarjeta.setBounds(75, 111, 148, 27);
		getContentPane().add(lblNumeroDeTarjeta);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFecha.setBounds(75, 176, 64, 21);
		getContentPane().add(lblFecha);
		
		JLabel lblNmeroSecreto = new JLabel("Número secreto:");
		lblNmeroSecreto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNmeroSecreto.setBounds(75, 241, 148, 27);
		getContentPane().add(lblNmeroSecreto);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(248, 114, 45, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(248, 176, 28, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(235, 318, 110, 30);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || passwordField.getText().equals("") || textField_3.getText().equals("")) {
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
		label.setBounds(286, 177, 19, 15);
		getContentPane().add(label);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(306, 176, 28, 20);
		getContentPane().add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(248, 244, 80, 21);
		getContentPane().add(passwordField);
		
		JLabelGraficoAjustado logo = new JLabelGraficoAjustado("src/img/eShop.png", 130, 90);
		logo.setLocation(10, 10);
		getContentPane().add(logo);

		JLabelGraficoAjustado logo2 = new JLabelGraficoAjustado("src/img/Safetypay.png", 320, 135);
		logo2.setLocation(255, -15);
		getContentPane().add(logo2);

		JLabelGraficoAjustado logo3 = new JLabelGraficoAjustado("src/img/pay.png", 160, 145);
		logo3.setLocation(380, 165);
		getContentPane().add(logo3);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(326, 114, 45, 21);
		getContentPane().add(textField_2);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(405, 114, 45, 21);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(484, 114, 45, 21);
		getContentPane().add(textField_5);
		
		JLabel label_1 = new JLabel("-");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(304, 118, 45, 13);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("-");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(380, 118, 45, 13);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("-");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(460, 118, 45, 13);
		getContentPane().add(label_3);


	}
	

	public static void main(String[] args) {
		VentanaPago v = new VentanaPago();
		v.setVisible(true);

	}
}
