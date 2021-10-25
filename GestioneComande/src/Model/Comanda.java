package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Comanda implements Serializable{

	private ArrayList <Cibo> pietanze;
	int tavolo;
	private float prezzoTot;
	private boolean cucinato;
	private boolean consegnato;
	
	
	public Comanda() {
		this.tavolo=0;
		this.prezzoTot=0;
		this.cucinato=false;
		this.consegnato=false;
		pietanze=new ArrayList<Cibo>();
	}
	
	public void setTavolo(int tav) {
		tavolo=tav;
	}
	
	public void aggiungiPietanza(Cibo c) {
		pietanze.add(c);
		prezzoTot+=c.getPrezzo();
	}
	
	public ArrayList <Cibo> leggiPietanze(){
		return pietanze;
	}
	
	public int getTavolo(){
		return tavolo;
	}
	
	public void setCucinato() {
		cucinato=true;
	}
	
	public void setConsegnato() {
		consegnato=true;
	}
	
	public boolean getCucinato() {
		return cucinato;
	}
	
	public boolean getConsegnato() {
		return consegnato;
	}
	
	public boolean equals(Comanda co) {
		if(this.tavolo==co.tavolo) {
			if(this.prezzoTot==co.prezzoTot) {
				if(this.pietanze.size()==co.pietanze.size()) {
					for(int i=0; i<this.pietanze.size(); i++)
						if(this.pietanze.get(i)!=co.pietanze.get(i))
							return false;
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return "Tavolo: "+tavolo+", Prezzo totale: "+prezzoTot;
	}
}
