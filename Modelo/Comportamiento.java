package Modelo;

import java.util.List;

//en cada turno deberia recorrer el tablero para actualizar los boolean de cada ficha

public class Comportamiento {
	List<Ficha> f1;
	List<Ficha> f2;
	
	Tablero tab=new Tablero();
	int[][] p=tab.getBase();
	
	public void añadirFicha() {
		
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				if(p[x][y]==1) {
					if(x!=2) {
					Ficha f=new Ficha(x, y, 1, false, false);
					f1.add(f); //negras (arriba)
					}else {
						Ficha f=new Ficha(x, y, 1, true, false);
						f1.add(f); //negras (arriba)
					}
				}else if(p[x][y]==2) {
					if(x!=5) {
					Ficha f=new Ficha(x, y, 2, false, false);
					f2.add(f); //blancas (abajo)
					}else {
						Ficha f=new Ficha(x, y, 2, true, false);
						f2.add(f); //blancas (abajo)
					}
				}
			}
		}
	}
	
	public void Mover(List<Ficha> f) { 
		int posx;
		int posy;
		
		if(f.equals(f2)) {
			if(puedeMover(f)) {
				for(int i=0;i<=f.size();i++) {//hablando SOLO de las 2
					posx=f.get(i).getX();
					posy=f.get(i).getY();

					if((posx!=0&&posy!=7)&&(posy!=0)) { //no se tiene en cuenta posy  (habría que distingir entre blancas y negras me da a mi que lo suyo son 2 metodos
						if(p[posx-1][posy-1]==0||p[posx-1][posy+1]==0) {
							//puede mover
							f.get(i).setMover(true);
						}else {
							//entonces tiene fichas delante ya sea 1 (incomible) o 2
							//no puede mover
						}
					}else 
						if(posx==0){ //vamos con las excepciones 0 y 7
							//es coronada no podria haber ninguna ahí
						}else {
							if(posy==7){
								if(p[posx-1][posy-1]==0) {
									 //puede mover
									f.get(i).setMover(true);
								}else {
									//entonces tiene fichas delante ya sea 1 (incomible) o 2
								}
						
							
							}else { //posy==0
								if(p[posx-1][posy+1]==0) {
									//puede mover
									f.get(i).setMover(true);
								}else {
									//entonces tiene fichas delante ya sea 1 (incomible) o 2
								}
						}
						}
				}
			
			
			}else {//puede comer
			
		}
	}else{ //f2
		if(puedeMover(f)) {
			for(int i=0;i<=f.size();i++) {//hablando SOLO de las 1
				posx=f.get(i).getX();
				posy=f.get(i).getY();
			
				if((posx!=7||posy!=0)||(posy!=7)) { 
					if(p[posx+1][posy-1]==0||p[posx+1][posy+1]==0) {
						//puede mover
						f.get(i).setMover(true);
					}else {
						//entonces tiene fichas delante ya sea 2 (incomible) o 1
						//no puede mover
					}
				}else 
					if(posx==7){ 
						//es coronada no podria haber ninguna ahí
					}else {
						if(posy==7){
							if(p[posx+1][posy-1]==0) {
								 //puede mover
								f.get(i).setMover(true);
							}else {
								//entonces tiene fichas delante ya sea 1 (incomible) o 2
							}
					
						
						}else { //posy==0
							if(p[posx+1][posy+1]==0) {
								//puede mover
								f.get(i).setMover(true);
							}else {
								//entonces tiene fichas delante ya sea 1 (incomible) o 2
							}
					}
					}
			}
		
	}
	}
	}
	
	public void turnoNegras(List<Ficha> f){
		int posx;
		int posy;
		//deberia llamar a metodo puede comer
		if(puedeMover(f)) {
			for(int i=0;i<=f.size();i++) {//hablando SOLO de las 1
				posx=f.get(i).getX();
				posy=f.get(i).getY();
			
				if((posx!=7||posy!=0)||(posy!=7)) { 
					if(p[posx+1][posy-1]==0||p[posx+1][posy+1]==0) {
						//puede mover
						f.get(i).setMover(true);
					}else {
						//entonces tiene fichas delante ya sea 2 (incomible) o 1
						//no puede mover
					}
				}else 
					if(posx==7){ 
						//es coronada no podria haber ninguna ahí
					}else {
						if(posy==7){
							if(p[posx+1][posy-1]==0) {
								 //puede mover
								f.get(i).setMover(true);
							}else {
								//entonces tiene fichas delante ya sea 1 (incomible) o 2
							}
					
						
						}else { //posy==0
							if(p[posx+1][posy+1]==0) {
								//puede mover
								f.get(i).setMover(true);
							}else {
								//entonces tiene fichas delante ya sea 1 (incomible) o 2
							}
					}
					}
			}
		}else {
			//comer
		}
	}
	
	public boolean puedeMover(List<Ficha> f) {
		for(Ficha n: f) {
			if(n.isComer()) {
				return false;
			}
		}
		return true;
	}
	
	public void puedeComer(List<Ficha> f) { //no puede en verdad devolver por que solo podria comer una en ese caso
		int posx;
		int posy;
		if(f.equals(f2)) {
		for(int i=0;i<=f.size();i++) {
			posx=f.get(i).getX();
			posy=f.get(i).getY();
			if(posx==1 ||posx==0) {
				//no puede comer

			}else {
				if((posy!=0||posy!=7)||(posy!=1||posy!=6)) {
					if((p[posx-1][posy-1]==1)&&(p[posx-2][posy-2]==0)||(p[posx-1][posy+1]==1)&&(p[posx-2][posy+2]==0)) {
						//puede comer
						f.get(i).setComer(true);

					}else {
						//no puede comer

					}
				}else {
					if(posy==6||posy==7){
						if((p[posx-1][posy-1]==1)&&(p[posx-2][posy-2]==0)) {
							//puede comer
							f.get(i).setComer(true);

						}else {
							//no puede comer

						}
					}else { //posy=0 o posy=1
						if((p[posx-1][posy+1]==1)&&(p[posx-2][posy+2]==0)) {
							//puede comer
							f.get(i).setComer(true);

						}else {
							//no puede comer

						}
					}
				}
			}
			
		}
		}else {
			for(int i=0;i<=f.size();i++) {
				posx=f.get(i).getX();
				posy=f.get(i).getY();
				if(posx==6 ||posx==7) {
					//no puede comer

				}else {
					if((posy!=0||posy!=7)||(posy!=1||posy!=6)) {
						if((p[posx+1][posy-1]==2)&&(p[posx+2][posy-2]==0)||(p[posx+1][posy+1]==2)&&(p[posx+2][posy+2]==0)) {
							//puede comer
							f.get(i).setComer(true);

						}else {
							//no puede comer
						}
					}else {
						if(posy==6||posy==7){
							if((p[posx+1][posy-1]==2)&&(p[posx+2][posy-2]==0)) {
								//puede comer
								f.get(i).setComer(true);

							}else {
								//no puede comer
								

							}
						}else { //posy=0 o posy=1
							if((p[posx+1][posy+1]==2)&&(p[posx+2][posy+2]==0)) {
								//puede comer
								f.get(i).setComer(true);

							}else {
								//no puede comer

							}
						}
					}
				}
				
			}
		}
		
	}
	
	public void Comer(List<Ficha> f) {
		if(f.equals(f2)) {
			if(true) { //se deberia tratar ficha por ficha para ello se podria dividir la matriz o AÑADIR UN BOOLEAN A FICHA 
				//si ficha seleccionada puede moverse a la posicion marcada mover si no no hacer nada!! 
			}
		}
	}
	

	public List<Ficha> getF1() { //devuelve la lista de fichas 1
		return f1;
	}

	public void setF1(List<Ficha> f1) {
		this.f1 = f1;
	}

	public List<Ficha> getF2() { //devuelve la lista de fichas 2
		return f2;
	}

	public void setF2(List<Ficha> f2) {
		this.f2 = f2;
	}

	public Tablero getTab() {
		return tab;
	}

	public void setTab(Tablero tab) { //devuelve el tablero
		this.tab = tab;
	}

	public int[][] getP() {  //devuelve el tablero en el estado actual
		return p;
	}

	public void setP(int[][] p) {
		this.p = p;
	}
	
	
	
	

}
