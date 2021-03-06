package ViewCucina;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import ControlCucina.ControlCucina;
import Model.Cibo;
import Model.Comanda;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ViewCucina {

	private JFrame frame;
	
	private JPanel elenco;
	private DefaultListModel<Comanda> listmodel;
	private JList<Comanda> comande;
	private JScrollPane comande_scroll;
	private JButton select;
	private JButton refresh;

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
		frame.setTitle("al Cane Blu - Cucina");
		ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("Model/imgRistorante.jpg"));
		frame.setIconImage(ico.getImage());
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		elenco = new JPanel();
		elenco.setBounds(0, 0, 794, 565);
		elenco.setBackground(new Color(225,235,255));
		elenco.setLayout(null);
		elenco.setVisible(true);
		frame.getContentPane().add(elenco);
		
		comanda = new JPanel();
		comanda.setBounds(0, 0, 794, 565);
		comanda.setBackground(new Color(225,235,255));
		comanda.setLayout(null);
		comanda.setVisible(false);
		frame.getContentPane().add(comanda);

		JLabel lblNewLabel = new JLabel("Gestione Comande");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 400, 45);
		elenco.add(lblNewLabel);
		
		listmodel=new DefaultListModel<>();
		
		comande=new JList<>();
		comande.setBorder(new LineBorder(new Color(0, 0, 0)));
		comande.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
		comande.setBounds(10, 10, 600, 400);
		comande.setModel(listmodel);
			
		comande_scroll=new JScrollPane(comande);
		comande_scroll.setBounds(20, 70, 650, 470);
		elenco.add(comande_scroll);
		
		select=new JButton("Apri");
		select.setFont(new Font("Tahoma", Font.PLAIN, 22));
		select.setBounds(690, 340, 80, 200);
		elenco.add(select);

		ImageIcon ref = new ImageIcon(getClass().getClassLoader().getResource("Model/refresh80.jpg"));
		refresh=new JButton("");
		refresh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		refresh.setIcon(ref);
		refresh.setBounds(690, 70, 80, 80);
		elenco.add(refresh);
		
		
		
		tavolo=new JTextArea("");
		tavolo.setBackground(new Color(225,235,255));
		tavolo.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		tavolo.setBounds(20, 20, 700, 20);
		comanda.add(tavolo);
		
		elencocibi=new JTextArea("Lista Cibi: ");
		elencocibi.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		elencocibi.setBackground(new Color(225,235,255));
		elencocibi.setBounds(20, 60, 700, 20);
		comanda.add(elencocibi);
		
		listmodelCibi=new DefaultListModel<>();
		
		cibi=new JList<>();	
		cibi.setBounds(20, 80, 700, 250);
		cibi.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		cibi.setModel(listmodelCibi);
			
		cibi_scroll=new JScrollPane(cibi);
		cibi_scroll.setBounds(20, 85, 700, 350);
		comanda.add(cibi_scroll);
		
		esegui=new JButton("Pronto");
		esegui.setFont(new Font("Tahoma", Font.PLAIN, 22));
		esegui.setBounds(20, 450, 150, 50);
		comanda.add(esegui);
		
		exit=new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		exit.setBounds(570, 450, 150, 50);
		comanda.add(exit);
	}

	public void mostra() {
		frame.setVisible(true);
	}

	public void registraController(ControlCucina c) {
		select.addActionListener(c);
		esegui.addActionListener(c);
		exit.addActionListener(c);
		refresh.addActionListener(c);
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
