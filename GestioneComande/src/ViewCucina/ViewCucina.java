package ViewCucina;

import java.awt.EventQueue;
import java.util.ArrayList;

import Model.Menu;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ControlCucina.ControlCucina;
import Model.Cibo;
import Model.Comanda;

import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class ViewCucina {

	private JFrame frame;
	
	private JPanel elenco;
	private DefaultListModel<Comanda> listmodel;
	private JList<Comanda> comande;
	private JScrollPane comande_scroll;
	private JButton select;

	private JPanel comanda;
	private JTextArea tavolo;
	private JTextArea elencocibi;
	private DefaultListModel<Cibo> listmodelCibi;
	private JList<Cibo> cibi;
	private JScrollPane cibi_scroll;
	private JButton esegui;
	private JButton exit;
	
	
	
	public ViewCucina() {
		frame = new JFrame();
		frame.setTitle("Cucina");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		elenco = new JPanel();
		elenco.setBounds(0, 0, 794, 565);
		elenco.setLayout(null);
		elenco.setVisible(true);
		frame.getContentPane().add(elenco);
		
		comanda = new JPanel();
		comanda.setBounds(0, 0, 794, 565);
		comanda.setLayout(null);
		comanda.setVisible(false);
		frame.getContentPane().add(comanda);
		
		listmodel=new DefaultListModel<>();
		
		comande=new JList<>();
		comande.setBounds(10, 10, 600, 400);
		comande.setModel(listmodel);
			
		comande_scroll=new JScrollPane(comande);
		comande_scroll.setBounds(20, 20, 650, 520);
		elenco.add(comande_scroll);
		
		select=new JButton("CUCINA");
		select.setBounds(690, 200, 80, 200);
		elenco.add(select);
		
		
		
		tavolo=new JTextArea("");
		tavolo.setBounds(20, 20, 700, 20);
		comanda.add(tavolo);
		
		elencocibi=new JTextArea("Lista Cibi: ");
		elencocibi.setBounds(20, 60, 700, 20);
		comanda.add(elencocibi);
		
		listmodelCibi=new DefaultListModel<>();
		
		cibi=new JList<>();	
		cibi.setBounds(20, 80, 700, 250);
		cibi.setModel(listmodelCibi);
			
		cibi_scroll=new JScrollPane(cibi);
		cibi_scroll.setBounds(20, 80, 700, 350);
		comanda.add(cibi_scroll);
		
		esegui=new JButton("CUCINATO");
		esegui.setBounds(20, 450, 100, 50);
		comanda.add(esegui);
		
		exit=new JButton("exit");
		exit.setBounds(620, 450, 100, 50);
		comanda.add(exit);
	}

	public void mostra() {
		frame.setVisible(true);
	}

	public void registraController(ControlCucina c) {
		select.addActionListener(c);
		esegui.addActionListener(c);
		exit.addActionListener(c);
	}
	
	public void addComanda(Comanda c) {
		listmodel.addElement(c);
		comande.setModel(listmodel);
	}
	
	public Comanda getComanda() {
		return comande.getSelectedValue();
	}

	public void openComanda(Comanda c) {
		elenco.setVisible(false);
		comanda.setVisible(true);
		tavolo.setText("Tavolo: "+c.getTavolo());
		ArrayList<Cibo> pietanze=c.leggiPietanze();
		for(int i=0; i<pietanze.size();i++) 
			listmodelCibi.addElement(pietanze.get(i));
	}

	public void openLista() {
		comanda.setVisible(false);
		elenco.setVisible(true);
		listmodelCibi.clear();
		listmodel.clear();
	}
}
