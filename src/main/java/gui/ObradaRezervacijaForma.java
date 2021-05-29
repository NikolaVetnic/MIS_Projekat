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
import javax.swing.border.EmptyBorder;
import crud.StoCrud;
import model.Rezervacija;
import model.Sto;

public class ObradaRezervacijaForma extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel frmObrada = new JPanel();

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
		frmObrada.setLayout(null);
		frmObrada.setLayout(null);
		
		 StoCrud sc = new StoCrud();
		 List<Sto> stolovi = sc.listaStolova();
		{
			JLabel lblIzaberiRezervaciju = new JLabel("Izaberi Rez:");
			lblIzaberiRezervaciju.setBounds(12, 28, 180, 15);
			frmObrada.add(lblIzaberiRezervaciju);
		}
		
		{
		
				JComboBox<Rezervacija> rezervacija = new JComboBox<Rezervacija>();
				for(Sto s: stolovi) {
					List<Rezervacija> rezervacije = sc.listaRezervacijaZaSto(s.getIdSto());
					for(Rezervacija r: rezervacije)
					rezervacija.addItem(r);
				}
				rezervacija.setBounds(104, 23, 484, 24);
				frmObrada.add(rezervacija);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRezervisi = new JButton("Obradi");
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
