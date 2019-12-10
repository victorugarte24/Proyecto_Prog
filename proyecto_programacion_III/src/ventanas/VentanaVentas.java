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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import articulo.Articulo;
import electrodomesticos.Electrodomesticos;
import utils.JLabelGraficoAjustado;

public class VentanaVentas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JScrollPane scrollPaneOrdenadores;
	JScrollPane scrollPaneElectrodomesticos;
	JScrollPane scrollPaneMoviles;
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
	JLabelGraficoAjustado jlabelElectrodomesticos;
	JLabelGraficoAjustado jlabelOrdenadores;
	JLabelGraficoAjustado jlabelMoviles;
	int respuesta;
	DefaultListModel<Articulo> modelo;
	
	
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
			FileHandler fh = new FileHandler("data/logger.log");
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
		
		JLabelGraficoAjustado logo1 = new JLabelGraficoAjustado("src/img/eShop.png", 300, 200);
		JLabelGraficoAjustado logo2= new JLabelGraficoAjustado("src/img/Copyright.png", 300, 200);
		JLabelGraficoAjustado logo3 = new JLabelGraficoAjustado("src/img/eShop.png", 300, 200);
		JLabelGraficoAjustado logo4 = new JLabelGraficoAjustado("src/img/eShop.png", 300, 200);
		JLabelGraficoAjustado logo5 = new JLabelGraficoAjustado("src/img/Copyright.png", 300, 200);
		JLabelGraficoAjustado logo6 = new JLabelGraficoAjustado("src/img/eShop.png", 300, 200);
		
		ArrayList<JLabelGraficoAjustado> arrayElectrodomesticos = new ArrayList<JLabelGraficoAjustado>();
		arrayElectrodomesticos.add(logo1);
		arrayElectrodomesticos.add(logo2);
		arrayElectrodomesticos.add(logo3);
		arrayElectrodomesticos.add(logo4);
		arrayElectrodomesticos.add(logo5);
		arrayElectrodomesticos.add(logo6);
		
		ArrayList<JLabelGraficoAjustado> arrayOrdenadores = new ArrayList<JLabelGraficoAjustado>();
		arrayOrdenadores.add(logo1);
		arrayOrdenadores.add(logo2);
		arrayOrdenadores.add(logo3);
		arrayOrdenadores.add(logo4);
		arrayOrdenadores.add(logo5);
		arrayOrdenadores.add(logo6);
		
		ArrayList<JLabelGraficoAjustado> arrayMoviles = new ArrayList<JLabelGraficoAjustado>();
		arrayMoviles.add(logo1);
		arrayMoviles.add(logo2);
		arrayMoviles.add(logo3);
		arrayMoviles.add(logo4);
		arrayMoviles.add(logo5);
		arrayMoviles.add(logo6);
		
		pMoviles = new JPanel();
		pMoviles.setLayout(new GridLayout(3,3));
		scrollPaneMoviles = new JScrollPane(pMoviles, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pOrdenadores = new JPanel();
		pOrdenadores.setLayout(new GridLayout(3,3));
		scrollPaneOrdenadores = new JScrollPane(pOrdenadores, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pElectrodomesticos = new JPanel();
		pElectrodomesticos.setLayout(new GridLayout(3,3));
		scrollPaneElectrodomesticos = new JScrollPane(pElectrodomesticos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pestañas = new JTabbedPane();
		pestañas.setFont(new Font("Tahoma", Font.BOLD, 26));

		pestañas.addTab("Moviles", scrollPaneMoviles);

		pestañas.addTab("Ordenadores", scrollPaneOrdenadores);

		pestañas.addTab("Electrodomesticos", scrollPaneElectrodomesticos);

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
		
		modelo = new DefaultListModel<Articulo>();
		
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
		gbc_lista.insets = new Insets(37, 5, 5, 5);
		gbc_lista.gridx = 0;
		gbc_lista.gridy = 1;
		pEast.add(scrollPaneLista, gbc_lista);
		
		Articulo articulo = new Articulo("Pavilion 2500", 22012, "Ordenador", 200, "Hp", "");
		Electrodomesticos e = new Electrodomesticos("e", 1, "fdf", 123, "qd", "null", "ff", 12, 123);
		modelo.add(0, articulo);
		modelo.add(0, e);
		
		/////////////////////////////////////////////////////////////////////		
		for(int a = 0; a < arrayMoviles.size(); a++){
			jlabelMoviles = new JLabelGraficoAjustado(arrayMoviles.get(a).getName(), 200, 100);
			String nombreJLabel = jlabelMoviles.getName();
			jlabelMoviles.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(nombreJLabel);
					//modelo.add(0, e);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
			});
			pMoviles.add(jlabelMoviles);
		}
		for(int a = 0; a < arrayElectrodomesticos.size(); a++){
			jlabelElectrodomesticos = new JLabelGraficoAjustado(arrayElectrodomesticos.get(a).getName(), 200, 100);
			String nombreJLabel = jlabelElectrodomesticos.getName();
			jlabelElectrodomesticos.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(nombreJLabel);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
			});
			pElectrodomesticos.add(jlabelElectrodomesticos);		
		}
		for(int a = 0; a < arrayOrdenadores.size(); a++){
			jlabelOrdenadores = new JLabelGraficoAjustado(arrayOrdenadores.get(a).getName(), 200, 100);
			String nombreJLabel = jlabelOrdenadores.getName();
			jlabelOrdenadores.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(nombreJLabel);
				}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
			});
			pOrdenadores.add(jlabelOrdenadores);
		}
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnEliminar = new JButton("Eliminar");

		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 5, 0, 5);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 2;
		pEast.add(btnEliminar, gbc_btnEliminar);
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setFocusable(false);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo = ((DefaultListModel<Articulo>)lista.getModel());
				if(!modelo.isEmpty()) {
					respuesta = JOptionPane.showConfirmDialog(null,	"¿Estas seguro de que deseas eliminar este artículo?");

				}
				if(respuesta == 0) {
					int pos = lista.getSelectedIndex();
					modelo.removeElementAt(pos);
				}
			}
		});
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnValidar = new JButton("Comprar");
		GridBagConstraints gbc_btnValidar = new GridBagConstraints();
		gbc_btnValidar.fill = GridBagConstraints.BOTH;
		gbc_btnValidar.insets = new Insets(0, 5, 0, 5);
		gbc_btnValidar.gridx = 0;
		gbc_btnValidar.gridy = 2;
		pEast.add(btnValidar, gbc_btnValidar);
		btnValidar.setBackground(Color.GREEN);
		btnValidar.setFocusable(false);
		btnValidar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		

		
	}

	public static void main(String[] args) {
		VentanaVentas v = new VentanaVentas();
		v.setVisible(true);

	}

}
