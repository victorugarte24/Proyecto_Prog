package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import articulo.Articulo;
import bd.BD;

public class VentanaCompra extends JFrame {

	JList<Articulo> list;
	double valor;
	public static DefaultListModel<Articulo> modelo;
	public static JLabel lblNewLabel_1;

	public VentanaCompra(double total) {

		setDefaultCloseOperation(VentanaCompra.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 600);
		getContentPane().setLayout(null);
		setTitle("eShop");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JButton btnPagarYFinalizar = new JButton("Pagar y finalizar");
		btnPagarYFinalizar.setBounds(356, 462, 167, 53);
		btnPagarYFinalizar.setFocusable(false);
		getContentPane().add(btnPagarYFinalizar);
		btnPagarYFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				VentanaPago vp = new VentanaPago();
				vp.setVisible(true);
				
				try {
					factura();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				dispose();
			}
		});

		JButton btnCancelar = new JButton("Cancelar compra");
		btnCancelar.setBounds(70, 462, 167, 53);
		getContentPane().add(btnCancelar);
		btnCancelar.setFocusable(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();

			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(12, 46, 561, 222);
		panel.setBackground(new Color(51-204-255));
		getContentPane().add(panel);
		getContentPane().setBackground(new Color(51-204-255));
		modelo = new DefaultListModel<Articulo>();

		list = new JList<Articulo>();
		panel.add(list);
		list.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane(list);
		Dimension listSize = new Dimension(500, 200);
		scrollPane.setSize(listSize);
		scrollPane.setMaximumSize(listSize);
		scrollPane.setPreferredSize(listSize);
		scrollPane.setMaximumSize(listSize);
		panel.add(scrollPane);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total:" + " " + total + " $");
		lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioTotal.setBounds(70, 338, 453, 27);
		getContentPane().add(lblPrecioTotal);


	}

	public void factura() throws IOException {
		FileOutputStream fos = new FileOutputStream("data/factura.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int i = 0; i < modelo.getSize(); i++) {
			oos.writeObject(modelo.get(i).toString2());
			oos.write('\n');
		}
		
		oos.close();

	}
}

