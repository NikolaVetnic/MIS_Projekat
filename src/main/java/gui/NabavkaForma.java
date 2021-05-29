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
import model.NabavkaArtikal;
import model.Rezervacija;
import model.Sto;

public class NabavkaForma extends JDialog {

	private final JPanel frmNabavka = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NabavkaForma dialog = new NabavkaForma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NabavkaForma() {
		setTitle("Nabavka");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		frmNabavka.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(frmNabavka, BorderLayout.CENTER);
		frmNabavka.setLayout(null);
		
		 ArtikalCrud ac = new ArtikalCrud();
		 List<Artikal> artikli = ac.listaArtikala();
		{
			JLabel lblIzaberiArtikal = new JLabel("Izaberi artikal:");
			lblIzaberiArtikal.setBounds(74, 28, 111, 15);
			frmNabavka.add(lblIzaberiArtikal);
		}
		
		{
		
				JComboBox<Artikal> artikal = new JComboBox<Artikal>();
				for(Artikal a: artikli) {
					artikal.addItem(a);
				}
				artikal.setBounds(203, 23, 154, 24);
				frmNabavka.add(artikal);
		}
		{
			JLabel lblUnesiDatum = new JLabel("Izaberi datum:");
			lblUnesiDatum.setBounds(74, 113, 103, 15);
			frmNabavka.add(lblUnesiDatum);
		}
		JComboBox<Date> combo = new JComboBox<Date>();
		GregorianCalendar calendar = new GregorianCalendar();
        combo.addItem( calendar.getTime() );
        int j = 1;
        while(j<7) {
	        calendar.add( GregorianCalendar.DATE, 1 );
	        combo.addItem( calendar.getTime() );
	        j++;
        }
        combo.setRenderer( new DateComboBoxRenderer() );
		combo.setBounds(203, 108, 154, 24);
		frmNabavka.add(combo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRezervisi = new JButton("Naruči");
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
