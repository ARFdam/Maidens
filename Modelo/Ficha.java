package Modelo;

import javax.swing.JButton;

public class Ficha {
	boolean mover,comer;
	int y,x,n;
	
	public Ficha() {}
	
	public Ficha(boolean mover, boolean comer, int x, int y, int n) {
		super();
		this.mover = mover;
		this.comer = comer;
		this.y = y;
		this.x = x;
		this.n = n;
	}
	public Ficha(int x, int y, int n, boolean mover, boolean comer) {
		this.mover = mover;
		this.comer = comer;
		this.y = y;
		this.x = x;
		this.n = n;
	}



	public boolean isMover() {
		return mover;
	}
	public void setMover(boolean mover) {
		this.mover = mover;
	}
	public boolean isComer() {
		return comer;
	}
	public void setComer(boolean comer) {
		this.comer = comer;
	}
	public int getY(JButton b) {
		return Vista.Tablero.getY(b);
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX(JButton b) {
		return Vista.Tablero.getX(b);
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	
	
}