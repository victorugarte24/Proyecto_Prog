package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class VentanaAdministrador extends JFrame{
	
	public VentanaAdministrador() {
		
		JPanel pNorth = new JPanel();
		getContentPane().add(pNorth, new BorderLayout().NORTH);
		
		JPanel Pcenter = new JPanel();
		getContentPane().add(Pcenter, new BorderLayout().CENTER);
		
		JLabel lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdministrador.setSize(171, 20);
		
		JPanel pMoviles = new JPanel();
		pMoviles.setBackground(Color.orange);
		Pcenter.add(pMoviles);
		
		JPanel pOrdenadores = new JPanel();
		pMoviles.setBackground(Color.green);
		
		JPanel pElectrodomesticos = new JPanel();
		pMoviles.setBackground(Color.blue);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setSize(137, 21);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {" Móviles ", " Ordenadores ", " Electrodomésticos "}));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				int selectionP = comboBox.getSelectedIndex();
				switch (selectionP){
				case 0:
					getContentPane().add(pMoviles, new BorderLayout().CENTER);
					System.out.println("Moviles");
				break;
				case 1:
					getContentPane().add(pOrdenadores, new BorderLayout().CENTER);
					System.out.println("Ordeandores");
				break;
				case 2:
					getContentPane().add(pElectrodomesticos, new BorderLayout().CENTER);
					System.out.println("Electrodomesticos");
				break;
				}

			}
		});
		getContentPane().add(comboBox);
		comboBox.setFocusable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaAdministrador.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	public static void main(String[] args) {
		VentanaAdministrador v = new VentanaAdministrador();
		v.setVisible(true);

	}
}
