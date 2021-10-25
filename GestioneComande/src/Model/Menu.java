package Model;

public class Menu {
	private Cibo menu[];
	public Menu() {
		menu=new Cibo[10];
		menu[0]=new Cibo("Pasta alle cozze e gamberetti",(float)12.50,"primo");
		menu[1]=new Cibo("Pasta alla zucca e olive taggiasche",(float)9.50,"primo");
		menu[2]=new Cibo("Tartare di manzo con scaglie di tartufo",(float)10.50,"secondo");
		menu[3]=new Cibo("Cotoletta di maiale alla milanese",(float)8.50,"secondo");
		menu[4]=new Cibo("Peperoni al forno",(float)2.50,"contorno");
		menu[5]=new Cibo("Insalata di rucola",(float)2.50,"contorno");
		menu[6]=new Cibo("Crostata alla marlmellata di pesca",(float)4.50,"dolce");
		menu[7]=new Cibo("Macarons con cioccolato fuso",(float)4.50,"dolce");
		menu[8]=new Cibo("Acqua Naturale",(float)1.00,"bevanda");
		menu[9]=new Cibo("Acqua Frizzante",(float)1.00,"bevanda");
	}
	
	public Cibo[] getMenu() {
		return menu;
	}
}
