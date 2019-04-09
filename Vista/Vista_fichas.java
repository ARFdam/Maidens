package Vista;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import Modelo.Fichas;
import Modelo.Tablero;

@SuppressWarnings("serial")
public class Vista_fichas extends JLabel {
	private ArrayList<Fichas> fichas;
	private Tablero tab;

	public Vista_fichas() {
		fichas = new ArrayList<>();
	}

	public void generatefichas() {
		for (int x = 0; x < tab.getBase().length; x++) {
			for (int y = 0; y < tab.getBase().length; y++) {
				if (tab.getBase()[x][y] == 1) {
					fichas.add(new Fichas(1, x, y));
				} else if (tab.getBase()[x][y] == 2) {
					fichas.add(new Fichas(2, x, y));
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Fichas f : fichas) {
			if (f.getColor() == 1)
				g.drawImage(f.getpImg(), 75, 75, this);
			else if (f.getColor() == 2)
				g.drawImage(f.getgImg(), 75, 75, this);
		}
	}

	public ArrayList<Fichas> getFichas() {
		return fichas;
	}
}
