package ControlCucina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Comanda;
import Model.ModelCucina;
import Model.File;
import ViewCucina.ViewCucina;

public class ControlCucina implements ActionListener{
	
	private ViewCucina v;
	private ModelCucina m;
	private File fc;

	public ControlCucina(ModelCucina m,ViewCucina v, File fc) {
		this.v=v;
		this.m=m;
		this.fc=fc;
		v.registraController(this);
		addListaComande();
	}

	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getActionCommand().equalsIgnoreCase("Apri")) {
			Comanda c=null;
			c=v.getComanda();
			if(c!=null) {
				m.setComanda(c);
				v.openComanda(c);
			}
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("Exit")){
			v.openLista();
			addListaComande();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("Pronto")){
			m.setCucinato();
			fc.setComande(m.getComande());
			v.openLista();
			addListaComande();
		}
		else {
			v.openLista();
			addListaComande();
		}
	}
	
	private void addListaComande() {
		ArrayList<Comanda> ce=fc.getComande();
		for(int i=0;i<ce.size();i++)
			if(ce.get(i).getCucinato()==false)
				v.addComanda(ce.get(i));
		m.setComande(ce);
	}
}
