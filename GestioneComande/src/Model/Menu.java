package Model;

public class Menu {
	private Cibo menu[];
	public Menu() {
		menu=new Cibo[10];
		menu[0]=new Cibo("Pasta",(float)7.95,"cibo");
		menu[1]=new Cibo("Pizza",(float)8.5,"cibo");
		menu[2]=new Cibo("Pesce",(float)12.35,"cibo");
		menu[3]=new Cibo("Carne",(float)11.9,"cibo");
		menu[4]=new Cibo("Patatine",(float)3.5,"cibo");
		menu[5]=new Cibo("Birra",(float)5,"bevanda");
		menu[6]=new Cibo("Vino",(float)7,"bevanda");
		menu[7]=new Cibo("Acqua",(float)2,"bevanda");
		menu[8]=new Cibo("Caffe",(float)1.3,"bevanda");
		menu[9]=new Cibo("Dolce",(float)3,"cibo");
	}
	
	public Cibo[] getMenu() {
		return menu;
	}
}
