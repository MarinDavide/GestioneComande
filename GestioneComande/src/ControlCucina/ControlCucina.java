package ControlCucina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Comanda;
import Model.ModelCucina;
import Model.file;
import ViewCucina.ViewCucina;

public class ControlCucina implements ActionListener{
	
	private ViewCucina v;
	private ModelCucina m;
	private file fc;

	public ControlCucina(ModelCucina m,ViewCucina v, file fc) {
		this.v=v;
		this.m=m;
		this.fc=fc;
		v.registraController(this);
		addListaComande();
	}

	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getActionCommand().equalsIgnoreCase("CUCINA")) {
			Comanda c=null;
			c=v.getComanda();
			if(c!=null)
				m.setComanda(c);
				v.openComanda(c);
		}
		else {
			m.setCucinato();
			fc.setComande(m.getComande());
			v.openLista();
		}
	}
	
	private void addListaComande() {
		ArrayList<Comanda> ce=fc.getComande();
		for(int i=0;i<ce.size();i++)
			v.addComanda(ce.get(i));
		m.setComande(ce);
	}
}
