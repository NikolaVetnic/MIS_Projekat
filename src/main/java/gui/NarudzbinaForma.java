package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.ArtikalCrud;
import crud.StoCrud;
import gui.RezervacijaForma.DateComboBoxRenderer;
import model.Artikal;
import model.RacunArtikal;
import model.Sto;

public class NarudzbinaForma extends JDialog {

	private final JPanel frmNarudzbina = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NarudzbinaForma dialog = new NarudzbinaForma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NarudzbinaForma() {
		setTitle("Narudžbina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		frmNarudzbina.setLayout(new FlowLayout());
		frmNarudzbina.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(frmNarudzbina, BorderLayout.CENTER);
		frmNarudzbina.setLayout(null);
		{
			JLabel lblUnesiDatum = new JLabel("Izaberi datum:");
			lblUnesiDatum.setBounds(74, 113, 103, 15);
			frmNarudzbina.add(lblUnesiDatum);
		}
		{
			JLabel lblIzaberiArtikal = new JLabel("Izaberi artikal:");
			lblIzaberiArtikal.setBounds(74, 47, 108, 15);
			frmNarudzbina.add(lblIzaberiArtikal);
		}
		
		 ArtikalCrud ac = new ArtikalCrud();
		 List<Artikal> artikli = ac.listaArtikala();
		{
			JComboBox<Artikal> artikal = new JComboBox<Artikal>();
			for(Artikal ra: artikli) {
					artikal.addItem(ra);
			}
			artikal.setBounds(200, 42, 152, 24);
			frmNarudzbina.add(artikal);
		} 
		
		JComboBox<Date> combo = new JComboBox<Date>();
		GregorianCalendar calendar = new GregorianCalendar();
        combo.addItem( calendar.getTime() );
        combo.setRenderer( new DateComboBoxRenderer() );
		combo.setBounds(198, 108, 154, 24);
		frmNarudzbina.add(combo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNaruči = new JButton("Naruči");
				btnNaruči.setActionCommand("OK");
				buttonPane.add(btnNaruči);
				getRootPane().setDefaultButton(btnNaruči);
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
