package ViewCameriere;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ControlCameriere.ControlCameriere;
import Model.Cibo;
import Model.Comanda;
import Model.Menu;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
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
	private JButton btnHome;
	private JButton btnConsegna;
	private JTextArea textRiepOrdine;
	private JComboBox<Cibo> comboBox;
	private Cibo[] menu;
	private Cibo[] ordine;
	private int piattiOrdinati=0;
	private String riepOrdine = "";
	private JList<Comanda> list;
	private DefaultListModel<Comanda> listmodel;

	public ViewCameriere() {
		m = new Menu();
		menu = m.getMenu();
		ordine = new Cibo[100];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Ristorante - Cameriere");
		ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("Model/imgRistorante.jpg"));
		frame.setIconImage(ico.getImage());
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelHome = new JPanel();
		panelHome.setBackground(new Color(255,245,100));
		frame.getContentPane().add(panelHome, "name_473329837800");
		panelHome.setLayout(null);

		btnRicComande = new JButton("Nuova Comanda");
		btnRicComande.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRicComande.setBackground(new Color(255, 180, 130));
		btnRicComande.setBounds(75, 150, 250, 50);
		panelHome.add(btnRicComande);

		btnConsComande = new JButton("Consegna Comanda");
		btnConsComande.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnConsComande.setBackground(new Color(255, 180, 130));
		btnConsComande.setBounds(75, 300, 250, 50);
		panelHome.add(btnConsComande);

		JLabel lblNewLabel = new JLabel("Gestione Comande");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 400, 45);
		panelHome.add(lblNewLabel);

		panelRicComande = new JPanel();
		panelRicComande.setBackground(new Color(255,245,100));
		frame.getContentPane().add(panelRicComande, "name_494704258300");
		panelRicComande.setLayout(null);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(125, 90, 150, 30);
		panelRicComande.add(btnAggiungi);

		JLabel lblNewLabel_1 = new JLabel("Riepilogo ordine:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 10, 200, 25);
		panelRicComande.add(lblNewLabel_1);

		btnConfOrdine = new JButton("Conferma Ordine");
		btnConfOrdine.setBounds(125, 575, 150, 30);
		panelRicComande.add(btnConfOrdine);

		comboBox = new JComboBox<Cibo>(menu);
		//comboBox = new JComboBox(menu);
		comboBox.setBounds(20, 50, 350, 25);
		panelRicComande.add(comboBox);

		textRiepOrdine = new JTextArea();
		textRiepOrdine.setEditable(false);
		textRiepOrdine.setBounds(20, 150, 350, 400);
		panelRicComande.add(textRiepOrdine);

		panelConsComande = new JPanel();
		panelConsComande.setBackground(new Color(255,245,100));
		frame.getContentPane().add(panelConsComande, "name_562332202200");
		panelConsComande.setLayout(null);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(100, 525, 200, 30);
		panelConsComande.add(btnHome);
		
		btnConsegna = new JButton("Consegna");
		btnConsegna.setBounds(100, 450, 200, 30);
		panelConsComande.add(btnConsegna);
		
		listmodel=new DefaultListModel<>();
		list = new JList<>();
		list.setBounds(20, 50, 350, 350);
		list.setModel(listmodel);
		panelConsComande.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Comande pronte:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 10, 200, 25);
		panelConsComande.add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	public void registraController(ControlCameriere controller) {
		btnAggiungi.addActionListener(controller);
		btnConfOrdine.addActionListener(controller);
		btnConsComande.addActionListener(controller);
		btnRicComande.addActionListener(controller);
		btnHome.addActionListener(controller);
		btnConsegna.addActionListener(controller);
	}

	public void ricComande() {
		panelRicComande.setVisible(true);
		panelHome.setVisible(false);
	}

	public void consComande(ArrayList<Comanda> comande) {
		listmodel.clear();
		for(int x=0; x<comande.size(); x++) {
			if(!comande.get(x).getConsegnato() && comande.get(x).getCucinato()) {
				listmodel.addElement(comande.get(x));
			}
		}
		list.setModel(listmodel);
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
		//System.out.println("piatti ordinati: "+piattiOrdinati);
		ordine[piattiOrdinati] = (Cibo) (comboBox.getSelectedItem());
		piattiOrdinati++;
	}

	public Comanda confermaOrdine() {
		Comanda c = new Comanda();
		//System.out.println("tavolo: "+c.getTavolo());
		for (int x = 0; x < piattiOrdinati; x++) {
			c.aggiungiPietanza(ordine[x]);
		}
		for(int i = 0; i < piattiOrdinati; i++) {
			ordine[i]=null;
        }
		piattiOrdinati=0;
		riepOrdine = "";
		textRiepOrdine.setText(riepOrdine);
		return c;
	}
	public boolean consegnaAlCliente() {
		Boolean selected=true;
		try {
			list.getSelectedValue().setConsegnato();
		}catch(Exception e) {
			selected=false;
		}
		return selected;
	}
	
	public void aggiornaList(ArrayList<Comanda> comande) {
		listmodel.clear();
		for(int x=0; x<comande.size(); x++) {
			if((comande.get(x).getConsegnato()==false) && (comande.get(x).getCucinato()==true)) {
				listmodel.addElement(comande.get(x));
			}
		}
		list.setModel(listmodel);
	}


	public void setPiattiOrdinati(int piattiOrdinati) {
		this.piattiOrdinati = piattiOrdinati;
	}
}
