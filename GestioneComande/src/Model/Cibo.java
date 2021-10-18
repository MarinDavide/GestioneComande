package Model;

import java.io.Serializable;

public class Cibo implements Serializable {

	private String nome;
	private float prezzo;
	private String tipologia;
	
	public Cibo(String nome, float prezzo, String tipologia) {
		this.nome=nome;
		this.prezzo=prezzo;
		this.tipologia=tipologia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public String getTipologia() {
		return tipologia;
	}
	
	public String toString() {
		return nome+" ("+tipologia+") - "+prezzo+"€";
	}
}
