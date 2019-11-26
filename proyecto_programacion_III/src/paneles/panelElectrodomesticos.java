package paneles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import electrodomesticos.Electrodomesticos;

public class panelElectrodomesticos extends JFrame{

	private static final long serialVersionUID = 1L;

	panelElectrodomesticos() {
		
		JPanel panelElectrodomesticos = new JPanel();
		panelElectrodomesticos.setLayout(new GridLayout(3,3));
		
		JScrollPane scrollPane = new JScrollPane(panelElectrodomesticos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		//ArrayList<Electrodomesticos> a = new ArrayList<Electrodomesticos>();
		
		//for(int c = 0; c < a.size(); c++) {	};

	}
	
	public static void main(String[] args) {
		panelElectrodomesticos v = new panelElectrodomesticos();
		v.setVisible(true);

	}

}
