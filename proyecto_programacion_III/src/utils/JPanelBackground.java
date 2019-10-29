package utils;

import java.awt.Graphics;
import java.awt.Image;
 
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelBackground extends JPanel {
 
	// Atributo que guardara la imagen de Background que le pasemos.
	private Image background;
	int width;
	int height;
 
	public void getMeasures(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	
	// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
	public void paintComponent(Graphics g) {
 
		// Mandamos que pinte la imagen en el panel
		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
		}
 
		super.paintComponent(g);
	}
 
	// Metodo donde le pasaremos la dirección de la imagen a cargar.
	public void setBackground(String imagePath) {
				
		
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}
 
}