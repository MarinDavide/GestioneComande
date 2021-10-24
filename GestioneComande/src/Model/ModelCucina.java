package Model;

public class ModelCucina {
	Comanda c;
	public ModelCucina() {
		
	}
	
	public void setComanda(Comanda c) {
		this.c = c;
	}
	
	public Comanda getComanda() {
		return c;
	}

	public void setCucinato() {
		c.setCucinato();
	}
}
