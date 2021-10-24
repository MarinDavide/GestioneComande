package Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

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
	
	public String toString() {
		return "Tavolo: "+tavolo+", Prezzo totale: "+prezzoTot;
	}
}
