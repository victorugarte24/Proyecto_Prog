package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Terminos extends JFrame {

	private JPanel contentPane;

	
	public Ventana_Terminos() {
		setDefaultCloseOperation(Ventana_Terminos.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.ORANGE);
		contentPane.setForeground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setTitle("eShop");
		this.setLocationRelativeTo(null);
		setResizable(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAceptar.setBounds(267, 372, 115, 29);
		contentPane.add(btnAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 33, 549, 307);
		contentPane.add(scrollPane);
		
		JTextArea txtrBienvenidoAAmazones = new JTextArea(" Bienvenido a Amazon.es.\r\n\r\n Amazon EU Sarl, Amazon Europe Core SARL y las sociedades de su grupo (\"Amazon\") te ofrecen\r\n funciones de sitio web y otros productos y servicios cuando visitas o compras en Amazon.es (el \"sitio \r\n web\"), utilizas los dispositivos, productos o servicios de Amazon, usas las aplicaciones de Amazon\r\n para dispositivos móviles o empleas software puesto a disposición por Amazon en relación con lo \r\n anterior (los \"Servicios de Amazon\" e individuamente, cada uno de ellos, el \"Servicio de Amazon\"). " + "\r\n" + " Consulta nuestro Aviso de privacidad, nuestro Aviso de Cookies y nuestro Aviso sobre publicidad basada" + " en los intereses del usuario. Amazon te presta los Servicios de Amazon bajo las condiciones establecidas en esta página. Amazon.es es el nombre comercial de Amazon. ");
		txtrBienvenidoAAmazones.setBounds(83, 33, 490, 266);
		txtrBienvenidoAAmazones.setEditable(false);
		scrollPane.setViewportView(txtrBienvenidoAAmazones);
		
	}
	
	public static void main(String[] args) {
		Ventana_Terminos v = new Ventana_Terminos();
		v.setVisible(true);

	}
	
}
