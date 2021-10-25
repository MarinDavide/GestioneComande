import Model.Menu;
import Model.ModelCucina;
import Model.File;

import java.util.ArrayList;

import ControlCucina.ControlCucina;
import Model.Cibo;
import Model.Comanda;
import ViewCucina.ViewCucina;

public class mainCucina {

	public static void main(String[] args) {
		
		ViewCucina v = new ViewCucina();
		ModelCucina m = new ModelCucina();
		File fc = new File();
		/*
		Menu me=new Menu();
		Cibo[] menu = me.getMenu();
		ArrayList<Comanda> cc = new ArrayList<>();
		Comanda co=new Comanda();
		co.setTavolo(4);
		co.aggiungiPietanza(menu[1]);
		cc.add(co);
		co=new Comanda();
		co.setTavolo(6);
		co.aggiungiPietanza(menu[2]);
		co.aggiungiPietanza(menu[5]);
		cc.add(co);
		co=new Comanda();
		co.setTavolo(8);
		co.aggiungiPietanza(menu[3]);
		co.aggiungiPietanza(menu[6]);
		co.aggiungiPietanza(menu[7]);
		cc.add(co);
		co=new Comanda();
		co.setTavolo(7);
		co.aggiungiPietanza(menu[4]);
		co.aggiungiPietanza(menu[8]);
		cc.add(co);
		fc.setComande(cc);
		*/

		ControlCucina c = new ControlCucina(m, v,fc);
		v.mostra();
	}

}
