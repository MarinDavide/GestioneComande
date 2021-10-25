import Model.ModelCucina;
import Model.File;

import ControlCucina.ControlCucina;
import ViewCucina.ViewCucina;

public class mainCucina {

	public static void main(String[] args) {
		
		ViewCucina v = new ViewCucina();
		ModelCucina m = new ModelCucina();
		File fc = new File();
		@SuppressWarnings("unused")
		ControlCucina c = new ControlCucina(m, v,fc);
		v.mostra();
	}

}
