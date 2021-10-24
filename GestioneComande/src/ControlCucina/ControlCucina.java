package ControlCucina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Comanda;
import Model.ModelCucina;
import ViewCucina.ViewCucina;

public class ControlCucina implements ActionListener{
	
	private ViewCucina v;
	private ModelCucina m;

	public ControlCucina(ModelCucina m,ViewCucina v) {
		this.v=v;
		this.m=m;
		v.registraController(this);
	}

	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getActionCommand().equalsIgnoreCase("CUCINA")) {
			Comanda c=null;
			c=v.getComanda();
			if(c!=null)
				System.out.println("c");
				v.openComanda(c);
		}
		
	}
}
