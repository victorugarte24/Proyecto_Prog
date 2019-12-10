package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import utils.JLabelGraficoAjustado;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class VentanaTerminos extends JFrame {

	private JPanel contentPane;
	private Logger logger;
	
	public VentanaTerminos() {
		setDefaultCloseOperation(VentanaTerminos.DISPOSE_ON_CLOSE);
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
		
		logger = Logger.getLogger( VentanaVentas.class.getName() ); 
		try {
			FileHandler fh = new FileHandler("data/logger.log");
			logger.addHandler(fh);
		} catch (SecurityException e11) {
			e11.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.log(Level.INFO, "Botón Aceptar ");
				dispose();
			}
		});
		btnAceptar.setBounds(267, 372, 115, 29);
		contentPane.add(btnAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 128, 549, 205);
		contentPane.add(scrollPane);
		
		JTextArea txtrBienvenidoAAmazones = new JTextArea(" Bienvenido a eShop.es.\r\n\r\n eShop EU Sarl, eShop Europe Core SARL y las sociedades de su grupo (\"eShop\") te ofrecen\r\n funciones de sitio web y otros productos y servicios cuando visitas o compras en eShop.es (el \"sitio \r\n web\"), utilizas los dispositivos, productos o servicios de Amazon, usas las aplicaciones de eShop\r\n para dispositivos móviles o empleas software puesto a disposición por eShop en relación con lo \r\n anterior (los \"Servicios de eShop\" e individuamente, cada uno de ellos, el \"Servicio de Amazon\"). " + "\r\n" + " Consulta nuestro Aviso de privacidad, nuestro Aviso de Cookies y nuestro Aviso sobre publicidad" + "\r\n" + " basada  en los intereses del usuario. EShop te presta los Servicios de eShop bajo las condiciones " + "\r\n" + " establecidas en esta página. Amazon.es es el nombre comercial de eShop. ");
		txtrBienvenidoAAmazones.setBounds(83, 33, 490, 266);
		txtrBienvenidoAAmazones.setEditable(false);
		scrollPane.setViewportView(txtrBienvenidoAAmazones);
		
		JLabelGraficoAjustado logo = new JLabelGraficoAjustado("src/img/eShop.png", 120, 100);
		logo.setLocation(25, 10);
		getContentPane().add(logo);
		
	}
	
	public static void main(String[] args) {
		VentanaTerminos v = new VentanaTerminos();
		v.setVisible(true);

	}
	
}
