package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
		return comande;
	}
	public void setComande(ArrayList<Comanda> comande){
		comande.addAll(comande);
		for(int i = 0; i < comande.size(); i++) {
            System.out.println("comanda: "+comande.get(i).toString());
        }
	}
}
