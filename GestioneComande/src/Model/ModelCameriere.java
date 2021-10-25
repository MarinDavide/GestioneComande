package Model;

import java.util.ArrayList;

public class ModelCameriere {
	private ArrayList <Comanda> comande;
	
	public ModelCameriere() {
		comande=new ArrayList<Comanda>();
	}
	public void aggiungiComanda(Comanda c) {
		comande.add(c);
	}
	public ArrayList<Comanda> getComande() {
		/*
		for(int i = 0; i < comande.size(); i++) {
            System.out.println("comanda: "+comande.get(i).toString());
        }*/
		return comande;
	}
	public void setComande(ArrayList<Comanda> comande){
		this.comande=comande;
	}
}
