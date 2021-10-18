package ViewCucina;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Cibo;
import Model.Comanda;

import java.awt.BorderLayout;

public class ViewCucina {

	private JFrame frame;
	private JPanel elenco;
	private JPanel comanda;
	private DefaultListModel<Comanda> listmodel;
	private JList<Comanda> comande;
	private JScrollPane comande_scroll;
	private JButton select;
	
	
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
		listmodel.addElement(new Comanda());
		listmodel.addElement(new Comanda());
		listmodel.addElement(new Comanda());
		listmodel.addElement(new Comanda());
		
		comande=new JList<>();
		comande.setBounds(10, 10, 600, 400);
		comande.setModel(listmodel);
			
		comande_scroll=new JScrollPane(comande);
		comande_scroll.setBounds(20, 20, 650, 520);
		elenco.add(comande_scroll);
		
		select=new JButton("CUCINA");
		select.setBounds(690, 200, 80, 200);
		elenco.add(select);
	}

	public void mostra() {
		frame.setVisible(true);
	}

}
