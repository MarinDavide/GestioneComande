package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class File { 
	
	private String file;

	public File() {
		file="src/Model/comande.txt";
	}
	
	public ArrayList<Comanda> getComande() {
		ArrayList<Comanda> a= new ArrayList<Comanda>();
		Comanda c;
		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				for(;;) {
					c = (Comanda) ois.readObject();
					a.add(c);
				}
			} catch (Exception e) {
			}
			fis.close();
		} catch (Exception e) {
		}
		return a;
	}
	
	public void setComande(ArrayList<Comanda> a) {
		try {
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int i=0;i<a.size();i++)
				oos.writeObject(a.get(i));
			oos.flush();
			fos.close();
		} catch (IOException e) {
		}
	}
}
