import ControlCameriere.ControlCameriere;
import Model.ModelCameriere;
import ViewCameriere.ViewCameriere;
import Model.Comanda;
import Model.File;

public class mainCamerieri {

	public static void main(String[] args) {
		
		
		ModelCameriere m = new ModelCameriere();
		Comanda com = new Comanda();
		ViewCameriere v= new ViewCameriere(com);
		File f = new File();
		ControlCameriere c = new ControlCameriere(m, v, com, f);
		v.setVisible(true);
	}

}
