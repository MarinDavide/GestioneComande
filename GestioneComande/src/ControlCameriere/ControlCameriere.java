package ControlCameriere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ViewCameriere.ViewCameriere;
import Model.ModelCameriere;
import Model.File;
public class ControlCameriere implements ActionListener{

	private ViewCameriere v;
	private ModelCameriere m;
	private File f;
	
	public ControlCameriere(ModelCameriere m, ViewCameriere v, File f) {
		this.m=m;
		this.v=v;
		this.f=f;
		m.setComande(f.getComande());
		v.registraController(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equalsIgnoreCase("Nuova Comanda")) {
			v.ricComande();
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Consegna Comanda")) {
			v.consComande(m.getComande());
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Conferma Ordine")) {
			//salva su file
			v.home();
			m.aggiungiComanda(v.confermaOrdine());
			//m.getComande(f.getComande());
			f.setComande(m.getComande());
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Aggiungi")) {
			v.aggiungiAOrdine();
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Consegna")) {
			//System.out.println("consegno");
			boolean selezionato = v.consegnaAlCliente();
			if(selezionato) {
				f.setComande(m.getComande());
				v.aggiornaList(m.getComande());
			}
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Home")) {
			v.home();
		}
	}
	
	
}
