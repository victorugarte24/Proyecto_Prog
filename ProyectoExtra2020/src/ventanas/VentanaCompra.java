package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import articulo.Articulo;

public class VentanaCompra extends JFrame {

	JList<Articulo> list;
	double valor;
	public static DefaultListModel<Articulo> modelo;
	public static JLabel lblNewLabel_1;
	private JTextField textField;
	double descuentoAplicado;

	public VentanaCompra(double total) {

		setDefaultCloseOperation(VentanaCompra.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 600);
		getContentPane().setLayout(null);
		setTitle("eShop");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JButton btnPagarYFinalizar = new JButton("Pagar y finalizar");
		btnPagarYFinalizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPagarYFinalizar.setBounds(343, 477, 160, 38);
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
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(70, 477, 160, 38);
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
		
		descuentoAplicado = total;
		
		JLabel lblPrecioTotal = new JLabel("Precio Total:" + " " + descuentoAplicado + " $");
		lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioTotal.setBounds(70, 317, 236, 27);
		getContentPane().add(lblPrecioTotal);
		
		JLabel label = new JLabel("Código de descuento:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(70, 371, 160, 27);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(253, 372, 147, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(439, 376, 85, 21);
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(textField.getText().equals("descuento30")) {
					double descuento = descuentoAplicado * 0.3;
					descuentoAplicado = descuentoAplicado - descuento;
					lblPrecioTotal.setText("Precio Total:" + " " + descuentoAplicado + " $");
					btnAplicar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Descuento Aplicado, ahorro total: " + descuento + " $");
				}
				else {
					JOptionPane.showMessageDialog(null, "Código de descuento no existente");
				}
			}
		});
		getContentPane().add(btnAplicar);

		

	}

	public void factura() throws IOException {
		File file = new File("factura");
		FileOutputStream fos = new FileOutputStream("data/" + file + ".txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int i = 0; i < modelo.getSize(); i++) {
			oos.writeObject(modelo.get(i).toString2());
			oos.write('\n');
		}
		
		oos.close();

	}
	
}

