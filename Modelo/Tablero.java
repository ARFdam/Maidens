package Modelo;

public class Tablero {
	
	private static Ficha fichas[][]=new Ficha[8][8];
	
	public Tablero() {
	for(int x=0;x<8;x++) {
		for(int y=0;y<8;y++) {
			if(esPar(x+y)&&x>4) {
				
				if(x==5) {
				fichas[x][y]=new Ficha(true,false,x,y,2);
				}
				else
				fichas[x][y]=new Ficha(false,false,x,y,2);
			}
			else if(esPar(x+y)&&x<3) {
			
				if(x==2) {
					fichas[x][y]=new Ficha(true,false,x,y,1);
				}
				else
					fichas[x][y]=new Ficha(false,false,x,y,1);
				
			}
			else
			
				fichas[x][y]=new Ficha(false,false,x,y,0);
			
		}
	}
	}
	
	public boolean esPar(int n) {
		if(n%2!=0) {
			return false;
		}
		return true;
	}
	public static int GetTipo(int x,int y) {
		return fichas[x][y].getN();
	}
	
	public static int GetBase() {
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				return fichas[i][j].getN();
			}
		}
		return 0;
		}
	}
