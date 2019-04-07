package Modelo;



public class Fichas {
	private int color, x, y;
	private boolean corona;

	public Fichas(int c, int x, int y) {
		color = c;
		this.x = x;
		this.y = y;
		corona=false;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isCorona() {
		return corona;
	}

	public void setCorona(boolean corona) {
		this.corona = corona;
	}

}
