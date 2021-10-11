package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Comanda implements Serializable{

	private ArrayList <Cibo> pietanze;
	private float prezzoTot;
	private boolean cucinato;
	private boolean consegnato;
	
	public Comanda() {
		this.prezzoTot=0;
		this.cucinato=false;
		this.consegnato=false;
	}
	
	public void aggiungiPietanza(Cibo c) {
		pietanze.add(c);
	}
	
	public ArrayList <Cibo> leggiPietanze(){
		return pietanze;
	}
}
