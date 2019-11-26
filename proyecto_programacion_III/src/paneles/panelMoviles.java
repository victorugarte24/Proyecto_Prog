package paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class panelMoviles extends JFrame{

	private static final long serialVersionUID = 1L;

	panelMoviles() {
		
		JPanel panelMoviles = new JPanel();
		panelMoviles.setLayout(new GridLayout(3,3));
		
		JScrollPane scrollPane = new JScrollPane(panelMoviles, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);

	}
	
	public static void main(String[] args) {
		panelMoviles v = new panelMoviles();
		v.setVisible(true);

	}

}