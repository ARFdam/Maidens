package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.Fichas;
import Modelo.Tablero;

@SuppressWarnings("serial")
public class Vista_Tablero extends JPanel {

	private Tablero tab;
	private JLabel[][] casillas;

	public Vista_Tablero() {
		tab = new Tablero();
		casillas = new JLabel[tab.getBase().length][tab.getBase().length];
		setLayout(new GridLayout(8, 8));
		setSize(600, 600);
		Añadircasillas();
		for (int x = 0; x < casillas.length; x++)
			for (int y = 0; y < casillas.length; y++)
				add(casillas[x][y]);
		setVisible(true);
	}

	public void Añadircasillas() {
		for (int x = 0; x < casillas.length; x++)
			for (int y = 0; y < casillas.length; y++) {
				casillas[x][y] = new JLabel();
				if ((x + y) % 2 == 0) {
					casillas[x][y].setBackground(Color.BLACK);
				} else {
					casillas[x][y].setBackground(Color.WHITE);

				}
			}
	}

//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//			}
//		}
//	}
}
