package Vista;


import java.awt.FlowLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ventana extends JFrame {
	private Vista_Tablero tab;

	public ventana() {
		super("DAMAS");
		tab=new Vista_Tablero();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setPreferredSize(tab.getSize());
		add(tab);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
