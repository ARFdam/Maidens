package Vista;


import java.awt.Color;
import java.awt.GridLayout;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;



public class Tablero extends JFrame {
	
	JButton[][] Base = new JButton[8][8];
		public Tablero() throws MalformedURLException {
			super("DAMAS");
			Modelo.Tablero t=new Modelo.Tablero();
			setLayout(new GridLayout(8,8));
			setSize(600,600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			for(int x=0;x<8;x++) {
				for(int y=0;y<8;y++) {
					if(esPar(x+y)) {
						if(x<3) {
							JButton boton=new JButton();
							editar(boton,x,y);
							Base[x][y]=boton;
							getContentPane().add(Base[x][y]);
							
						}
						else if(x>4) {
							JButton boton=new JButton();
							editar(boton,x,y);
							Base[x][y]=boton;
							getContentPane().add(Base[x][y]);	
						}
						else if(x>=3&&x<=4) {
						JButton boton=new JButton();
						editar(boton,x, y);
						boton.setBackground(Color.YELLOW);
						boton.setEnabled(false);
						boton.setVisible(true);
						Base[x][y]=boton;
						getContentPane().add(Base[x][y]);
						}
					}
					
					if(!esPar(x+y)) {
						JButton boton=new JButton();
						editar(boton,x, y);
						boton.setBackground(Color.CYAN);
						boton.setEnabled(false);
						boton.setVisible(true);
						Base[x][y]=boton;
						getContentPane().add(Base[x][y]);
						
					}	
				}
			}
			setLocationRelativeTo(null);
			setVisible(true);
}		

		public static void editar(JButton boton,int x, int y) throws MalformedURLException {
			ImageIcon gatete=new ImageIcon("imagenes\\modgato.png");
			ImageIcon perrete=new ImageIcon("imagenes\\modperro.png");
			ImageIcon perreted=new ImageIcon("imagenes\\modperrod.png");
			ImageIcon gateted=new ImageIcon("imagenes\\modgatod.png");
			boton.setToolTipText(Integer.toString(x)+" "+Integer.toString(y)); //metemos en tool tip coordenadas
			boton.setActionCommand(Integer.toString(Modelo.Tablero.GetTipo(x,y))); //tipo de ficha que es 
			int c=Modelo.Tablero.GetTipo(x, y);
			if(c==1) {
			boton.setIcon(gatete);
			boton.setBackground(Color.YELLOW);
			}
			if(c==2) {
			boton.setBackground(Color.YELLOW);
			boton.setIcon(perrete);
			}
			if(c==4) {
				boton.setBackground(Color.YELLOW);
				boton.setIcon(perreted);
			}
			if(c==3) {
				boton.setBackground(Color.YELLOW);
				boton.setIcon(gateted);
				
			}
		}
		
		public int getColor(JButton boton) {
			return Integer.parseInt(boton.getActionCommand());
		}
		
		public static  int getX(JButton boton) {
			String[] datos;
			datos=boton.getToolTipText().split(" ");
			return Integer.parseInt(datos[0]);
		}
		
		public static int getY(JButton boton) {
			String[] datos;
			datos=boton.getToolTipText().split(" ");
			 return Integer.parseInt(datos[1]);
		}
		
		public boolean esPar(int n) {
			if(n%2!=0) {
				return false;
			}
			return true;
		}
		
		
		
}