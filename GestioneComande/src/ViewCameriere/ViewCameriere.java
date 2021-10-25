package ViewCameriere;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ControlCameriere.ControlCameriere;
import Model.Cibo;
import Model.Comanda;
import Model.Menu;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class ViewCameriere {
	private Menu m;
	private JFrame frame;
	private JPanel panelHome;
	private JPanel panelRicComande;
	private JPanel panelConsComande;
	private JButton btnConfOrdine;
	private JButton btnRicComande;
	private JButton btnConsComande;
	private JButton btnAggiungi;
	private JTextArea textRiepOrdine;
	private JComboBox<Cibo> comboBox;
	private Cibo[] menu;
	private Cibo[] ordine;
	private int piattiOrdinati=0;
	private int tavolo=1;
	private Comanda c;
	private String riepOrdine = "";

	public ViewCameriere(Comanda com) {
		m = new Menu();
		this.c=com;
		menu = m.getMenu();
		ordine = new Cibo[100];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelHome = new JPanel();
		frame.getContentPane().add(panelHome, "name_473329837800");
		panelHome.setLayout(null);

		btnRicComande = new JButton("Nuova Comanda");
		btnRicComande.setBounds(39, 161, 155, 39);
		panelHome.add(btnRicComande);

		btnConsComande = new JButton("Consegna Comanda");
		btnConsComande.setBounds(242, 161, 155, 39);
		panelHome.add(btnConsComande);

		JLabel lblNewLabel = new JLabel("Gestione Comande");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(51, 11, 329, 45);
		panelHome.add(lblNewLabel);

		panelRicComande = new JPanel();
		frame.getContentPane().add(panelRicComande, "name_494704258300");
		panelRicComande.setLayout(null);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(322, 44, 81, 23);
		panelRicComande.add(btnAggiungi);

		JLabel lblNewLabel_1 = new JLabel("Riepilogo ordine:");
		lblNewLabel_1.setBounds(10, 27, 109, 14);
		panelRicComande.add(lblNewLabel_1);

		btnConfOrdine = new JButton("Conferma Ordine");
		btnConfOrdine.setBounds(228, 202, 122, 23);
		panelRicComande.add(btnConfOrdine);

		comboBox = new JComboBox<Cibo>(menu);
		// comboBox = new JComboBox<>();
		comboBox.setBounds(228, 44, 97, 23);
		panelRicComande.add(comboBox);

		textRiepOrdine = new JTextArea();
		textRiepOrdine.setEditable(false);
		textRiepOrdine.setBounds(10, 43, 193, 207);
		panelRicComande.add(textRiepOrdine);

		panelConsComande = new JPanel();
		frame.getContentPane().add(panelConsComande, "name_562332202200");
		panelConsComande.setLayout(null);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	public void registraController(ControlCameriere controller) {
		btnAggiungi.addActionListener(controller);
		btnConfOrdine.addActionListener(controller);
		btnConsComande.addActionListener(controller);
		btnRicComande.addActionListener(controller);
	}

	public void ricComande() {
		panelRicComande.setVisible(true);
		panelHome.setVisible(false);
	}

	public void ConsComande() {
		panelConsComande.setVisible(true);
		panelHome.setVisible(false);
	}

	public void home() {
		panelHome.setVisible(true);
		panelRicComande.setVisible(false);
		panelConsComande.setVisible(false);
	}

	public void aggiungiAOrdine() {
		riepOrdine = riepOrdine + (comboBox.getSelectedItem().toString()) + "\n";
		textRiepOrdine.setText(riepOrdine);
		System.out.println("piatti ordinati: "+piattiOrdinati);
		ordine[piattiOrdinati] = (Cibo) (comboBox.getSelectedItem());
		piattiOrdinati++;
	}

	public Comanda confermaOrdine() {
		Comanda c = new Comanda();
		c.setTavolo(tavolo);
		System.out.println("tavolo: "+c.getTavolo());
		for (int x = 0; x < piattiOrdinati; x++) {
			c.aggiungiPietanza(ordine[x]);
		}
		for(int i = 0; i < piattiOrdinati; i++) {
			ordine[i]=null;
        }
		piattiOrdinati=0;
		riepOrdine = "";
		textRiepOrdine.setText(riepOrdine);
		tavolo++;
		return c;
	}

	public void setPiattiOrdinati(int piattiOrdinati) {
		this.piattiOrdinati = piattiOrdinati;
	}

	
}
