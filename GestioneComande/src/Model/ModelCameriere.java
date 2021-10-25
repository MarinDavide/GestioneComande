package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import Model.File;

public class ModelCameriere {
	private ArrayList <Comanda> comande;
	private File f;
	
	public ModelCameriere() {
		comande=new ArrayList<Comanda>();
		f = new File();
	}
	public void aggiungiComanda(Comanda c) {
		comande.add(c);
	}
	public ArrayList<Comanda> getComande() {
		//comande=f.getComande();
		for(int i = 0; i < comande.size(); i++) {
            System.out.println("comanda: "+comande.get(i).toString());
        }
		return comande;
	}
	public void clear() {
		comande.clear();
	}
	public void setComande(ArrayList<Comanda> comande){
		comande.addAll(comande);
	}
}
