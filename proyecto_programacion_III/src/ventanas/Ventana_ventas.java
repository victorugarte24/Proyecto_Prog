package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Ventana_ventas extends JFrame {

	Ventana_ventas() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( Ventana_Inicio.DISPOSE_ON_CLOSE );
		setTitle("");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.orange);
		
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());

		JPanel pCenterNorth = new JPanel();
		pCenterNorth.setLayout(new BorderLayout());

		JPanel pWest = new JPanel();
		pWest.setLayout(new BorderLayout());

		JPanel pEast = new JPanel();
		pEast.setLayout(new BorderLayout());

		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());

		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		
		JPanel pMoviles = new JPanel();
		pMoviles.setLayout(new BorderLayout());
		pMoviles.setBackground(Color.RED);

		JPanel pOrdenadores = new JPanel();
		pOrdenadores.setLayout(new BorderLayout());
		pOrdenadores.setBackground(Color.BLUE);

		JPanel pElectrodomesticos = new JPanel();
		pElectrodomesticos.setLayout(new BorderLayout());
		pElectrodomesticos.setBackground(Color.YELLOW);

		JTabbedPane pestañas = new JTabbedPane();
		pestañas.setFont(new Font("Tahoma", Font.BOLD, 26));

		pestañas.addTab("Moviles", pMoviles);

		pestañas.addTab("Ordenadores", pOrdenadores);

		pestañas.addTab("Electrodomesticos", pElectrodomesticos);

		int index1 = pestañas.getTabCount() - 3;

		pestañas.setForegroundAt(index1, Color.BLACK);
		pestañas.setBackgroundAt(index1, new Color(255,0,0));

		int index2 = pestañas.getTabCount() - 2;

		pestañas.setForegroundAt(index2, Color.BLACK);
		pestañas.setBackgroundAt(index2, new Color(30,144,255));

		int index3 = pestañas.getTabCount() - 1;

		pestañas.setForegroundAt(index3, Color.BLACK);
		pestañas.setBackgroundAt(index3, Color.YELLOW);
		
		getContentPane().add(pNorth);
		getContentPane().add(pCenterNorth);
		getContentPane().add(pWest);
		getContentPane().add(pEast);
		getContentPane().add(pSouth);
		getContentPane().add(pCenter);
		pCenter.add(pestañas);

	}

	public static void main(String[] args) {
		Ventana_ventas v = new Ventana_ventas();
		v.setVisible(true);

	}

}
