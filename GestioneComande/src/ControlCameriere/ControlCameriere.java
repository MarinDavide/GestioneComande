package ControlCameriere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ViewCameriere.ViewCameriere;
import Model.Cibo;
import Model.ModelCameriere;
import Model.File;
import Model.Comanda;
public class ControlCameriere implements ActionListener{

	private ViewCameriere v;
	private ModelCameriere m;
	private Comanda com;
	private File f;
	
	public ControlCameriere(ModelCameriere m, ViewCameriere v, Comanda com, File f) {
		this.m=m;
		this.v=v;
		this.com=com;
		this.f=f;
		f.getComande();
		v.registraController(this);
		//v.loadMenu();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equalsIgnoreCase("Nuova Comanda")) {
			v.ricComande();
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Consegna Comanda")) {
			v.consComande(f.getComande());
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Conferma Ordine")) {
			//salva su file
			v.home();
			m.aggiungiComanda(v.confermaOrdine());
			com.leggiPietanze();
			//m.getComande(f.getComande());
			f.setComande(m.getComande());
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Aggiungi")) {
			v.aggiungiAOrdine();
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Consegna")) {
			System.out.println("consegno");
			
			f.setComande(v.consegnaAlCliente(m.getComande()));
		}
		if (arg0.getActionCommand().equalsIgnoreCase("Home")) {
			v.home();
		}
	}
	
	
}
