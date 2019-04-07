package Modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tablero {

	private int[][] Base = new int[8][8];
	private BufferedImage tabImg;
	private BufferedImage pImg;
	private BufferedImage gImg;

	public Tablero() {
		try {
			tabImg = ImageIO.read(getClass().getResource("/resource/Tablero.png"));

			pImg = ImageIO.read(getClass().getResource("/resource/perrete.png"));

			gImg = ImageIO.read(getClass().getResource("/resource/gatete.png"));
		} catch (IOException e) {
			System.out.println(e.toString());
		}

		for (int x = 0; x < Base.length; x++) {
			for (int y = 0; y < Base.length; y++) {

				if (esPar(x + y)) {
					if (x < 3) {
						Base[x][y] = 1;

					} else if (x > 4) {
						Base[x][y] = 2;
					} else {
						Base[x][y] = 0;
					}
				}

				if (!esPar(x + y)) {
					Base[x][y] = 0;
				}
			}
		}
	}

	public int[][] getBase() {
		return Base;
	}

	public void setBase(int[][] base) {
		Base = base;
	}

	public BufferedImage getTabImg() {
		return tabImg;
	}

	public void setTabImg(BufferedImage tabImg) {
		this.tabImg = tabImg;
	}

	public BufferedImage getpImg() {
		return pImg;
	}

	public void setpImg(BufferedImage pImg) {
		this.pImg = pImg;
	}

	public BufferedImage getgImg() {
		return gImg;
	}

	public void setgImg(BufferedImage gImg) {
		this.gImg = gImg;
	}

	public boolean esPar(int n) {
		if (n % 2 != 0) {
			return false;
		}
		return true;
	}
}