package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import crud.StoCrud;
import model.Rezervacija;
import model.Sto;
import javax.swing.JTable;

public class ObradaRezervacijaForma extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel frmObrada = new JPanel();
	private JTable table;
	private JComboBox<Sto> cmbStolovi;
	private StoCrud sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ObradaRezervacijaForma dialog = new ObradaRezervacijaForma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ObradaRezervacijaForma() {
		setTitle("Obrada rezervacija");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		frmObrada.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(frmObrada, BorderLayout.CENTER);
		frmObrada.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			frmObrada.add(panel, BorderLayout.NORTH);
			{
				JLabel lblIzaberiSto = new JLabel("Izaberi sto:");
				panel.add(lblIzaberiSto);
			}
			{
				cmbStolovi = new JComboBox<Sto>();
				panel.add(cmbStolovi);
			}
			{
				JButton btnPrikazi = new JButton("Prikaži");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Sto s = (Sto) cmbStolovi.getSelectedItem();
						List<Rezervacija> rezervacije = sc.listaRezervacijaZaSto(s.getIdSto());
						TableModelRezervacije tmr = new TableModelRezervacije(rezervacije);
						table.setModel(tmr);
					}
				});
				panel.add(btnPrikazi);
			}
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 426, 150);
		frmObrada.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 sc = new StoCrud();
		 List<Sto> stolovi = sc.listaStolova();
		
		{
				for(Sto s: stolovi) {
					cmbStolovi.addItem(s);
				}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRezervisi = new JButton("Obradi");
				btnRezervisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRezervisi.setActionCommand("OK");
				buttonPane.add(btnRezervisi);
				getRootPane().setDefaultButton(btnRezervisi);
			}
			{
				JButton btnZatvori = new JButton("Zatvori");
				btnZatvori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnZatvori.setActionCommand("Cancel");
				buttonPane.add(btnZatvori);
			}
		}
	}

}
