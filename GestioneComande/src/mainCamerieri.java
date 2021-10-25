import ControlCameriere.ControlCameriere;
import Model.ModelCameriere;
import ViewCameriere.ViewCameriere;
import Model.File;

public class mainCamerieri {

	public static void main(String[] args) {
		
		
		ModelCameriere m = new ModelCameriere();
		ViewCameriere v= new ViewCameriere();
		File f = new File();
		@SuppressWarnings("unused")
		ControlCameriere c = new ControlCameriere(m, v, f);
		v.setVisible(true);
		
	}

}
