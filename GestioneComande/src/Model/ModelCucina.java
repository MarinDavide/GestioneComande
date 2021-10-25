package Model;

import java.util.ArrayList;

public class ModelCucina {
	ArrayList<Comanda> comande;
	Comanda c;
	public ModelCucina() {
		comande=new ArrayList<Comanda>();
	}
	
	public void setComande(ArrayList<Comanda> comande) {
		this.comande=comande;
	}
	
	public ArrayList<Comanda> getComande() {
		return comande;
	}
	
	public void setComanda(Comanda c) {
		this.c = c;
	}
	
	public Comanda getComanda() {
		return c;
	}

	public void setCucinato() {
		c.setCucinato();
	}
}
