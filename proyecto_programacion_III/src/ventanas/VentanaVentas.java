package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import articulo.Articulo;
import utils.JLabelGraficoAjustado;

public class VentanaVentas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JScrollPane scrollPaneO;
	JScrollPane scrollPaneE;
	JScrollPane scrollPaneM;
	Logger logger;
	JPanel pNorth;
	JPanel pCenterNorth;
	JPanel pWest;
	JPanel pEast;
	JPanel pSouth;
	JPanel pCenter;
	JPanel pMoviles;
	JPanel pOrdenadores;
	JPanel pElectrodomesticos;
	JTabbedPane pestañas;
	
	VentanaVentas() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setDefaultCloseOperation( VentanaInicio.DISPOSE_ON_CLOSE );
		setTitle("eShop");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.orange);
		
		/////////////////////////////////////////////////////////////////////
		
		//Log
		
		logger = Logger.getLogger( VentanaVentas.class.getName() ); 
		try {
			FileHandler fh = new FileHandler("src/logger.log");
			logger.addHandler(fh);
		} catch (SecurityException e11) {
			e11.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		/////////////////////////////////////////////////////////////////////////////////
		
		//Paneles
		
		pNorth = new JPanel();
		pNorth.setLayout(new BorderLayout());

		pCenterNorth = new JPanel();
		pCenterNorth.setLayout(new BorderLayout());

		pWest = new JPanel();
		pWest.setLayout(new BorderLayout());

		pEast = new JPanel();
		pEast.setLayout(new BorderLayout());
		GridBagLayout gbl_pEast = new GridBagLayout();
		gbl_pEast.columnWeights = new double[]{0.5, 0.5};
		gbl_pEast.rowWeights = new double[]{0.0, 0.9, 0.1};
		pEast.setLayout(gbl_pEast);
		pEast.setBackground(Color.LIGHT_GRAY);

		pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());

		pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		
		pMoviles = new JPanel();
		pMoviles.setLayout(new GridLayout(3,3));
		scrollPaneM = new JScrollPane(pMoviles, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pOrdenadores = new JPanel();
		pOrdenadores.setLayout(new GridLayout(3,3));
		scrollPaneO = new JScrollPane(pOrdenadores, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pElectrodomesticos = new JPanel();
		pElectrodomesticos.setLayout(new GridLayout(3,3));
		scrollPaneE = new JScrollPane(pElectrodomesticos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pestañas = new JTabbedPane();
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

		JLabelGraficoAjustado logo = new JLabelGraficoAjustado("src/img/eShop.png", 120, 100);
		JLabelGraficoAjustado sale = new JLabelGraficoAjustado("src/img/sale.png", 150, 668);
		JLabelGraficoAjustado copyright = new JLabelGraficoAjustado("src/img/Copyright.png", 100, 85);

		pestañas.setForegroundAt(index3, Color.BLACK);
		pestañas.setBackgroundAt(index3, Color.YELLOW);
		
		getContentPane().add(pCenter, BorderLayout.CENTER);

		getContentPane().add(pNorth, BorderLayout.NORTH);

		getContentPane().add(pWest, BorderLayout.WEST);

		getContentPane().add(pEast, BorderLayout.EAST);

		getContentPane().add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo, BorderLayout.WEST);
		//pNorth.add(carrito, BorderLayout.EAST);
		pCenter.add(pestañas);
		pNorth.setBackground(Color.LIGHT_GRAY);
		pCenter.setBackground(Color.LIGHT_GRAY);
		pWest.add(sale, BorderLayout.SOUTH);
		pWest.setBackground(Color.LIGHT_GRAY);
		pSouth.setBackground(Color.LIGHT_GRAY);
		pSouth.add(copyright);
		
		pestañas.addChangeListener(new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		    	String pestaña_actual = "";
		    	if(pestañas.getSelectedIndex() == 0) {
		    		pestaña_actual = "Moviles";
		    	}
		    	if(pestañas.getSelectedIndex() == 1) {
		    		pestaña_actual = "Ordenadores";
		    	}
		    	if(pestañas.getSelectedIndex() == 2) {
		    		pestaña_actual = "Electrodomesticos";
		    	}
		        logger.log(Level.INFO, "Tab: " + pestaña_actual);
		    }
		});
		/////////////////////////////////////////////////////////////////////
		
		//Cesta
		
		DefaultListModel<Articulo> modelo = new DefaultListModel<Articulo>();
		
		JList<Articulo> lista = new JList<Articulo>();
		lista.setFont(new Font("Tahoma", Font.BOLD, 12));
		JScrollPane scrollPaneLista = new JScrollPane(lista);
		scrollPaneLista.setBackground(Color.ORANGE);
		scrollPaneLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Dimension listSize = new Dimension(300, 200);
		scrollPaneLista.setSize(listSize);
		scrollPaneLista.setMaximumSize(listSize);
		scrollPaneLista.setPreferredSize(listSize);
		scrollPaneLista.setMaximumSize(listSize);

		lista.setModel(modelo);
		GridBagConstraints gbc_lista = new GridBagConstraints();
		gbc_lista.gridwidth = 2;
		gbc_lista.fill = GridBagConstraints.BOTH;
		gbc_lista.insets = new Insets(37, 0, 5, 0);
		gbc_lista.gridx = 0;
		gbc_lista.gridy = 1;
		pEast.add(scrollPaneLista, gbc_lista);
		
		Articulo articulo = new Articulo("Pavilion 2500", 22012, "Ordenador", 200, "Hp");
		modelo.add(0, articulo);
		
		/////////////////////////////////////////////////////////////////////
		
	}

	public static void main(String[] args) {
		VentanaVentas v = new VentanaVentas();
		v.setVisible(true);

	}

}
