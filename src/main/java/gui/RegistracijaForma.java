package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import crud.KlijentCrud;
import model.Klijent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistracijaForma extends JDialog {

	private final JPanel frmRegistracija = new JPanel();
	private JTextField tfIme;
	private JTextField tfPrez;
	private JTextField tfEmail;
	private JTextField tfAdresa;
	private JTextField tfBroj;
	private JPasswordField pfLozinka;
	private KlijentCrud kc = new KlijentCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistracijaForma dialog = new RegistracijaForma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistracijaForma() {
		setTitle("Registracija");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		frmRegistracija.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(frmRegistracija, BorderLayout.CENTER);
		frmRegistracija.setLayout(null);
		{
			JLabel lblUnesiteIme = new JLabel("Unesite ime:");
			lblUnesiteIme.setBounds(60, 17, 121, 15);
			frmRegistracija.add(lblUnesiteIme);
		}
		{
			tfIme = new JTextField();
			tfIme.setBounds(199, 10, 191, 29);
			frmRegistracija.add(tfIme);
			tfIme.setColumns(10);
		}
		{
			JLabel lblUnesitePrezime = new JLabel("Unesite prezime:");
			lblUnesitePrezime.setBounds(60, 52, 121, 15);
			frmRegistracija.add(lblUnesitePrezime);
		}
		
		tfPrez = new JTextField();
		tfPrez.setBounds(199, 45, 191, 29);
		frmRegistracija.add(tfPrez);
		tfPrez.setColumns(10);
		
		JLabel lblUnesiteEmail = new JLabel("Unesite email:");
		lblUnesiteEmail.setBounds(60, 87, 121, 15);
		frmRegistracija.add(lblUnesiteEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(199, 80, 191, 29);
		frmRegistracija.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblUnesiteAdresu = new JLabel("Unesite adresu:");
		lblUnesiteAdresu.setBounds(60, 122, 121, 15);
		frmRegistracija.add(lblUnesiteAdresu);
		
		JLabel lblUnesiteBroj = new JLabel("Unesite broj:");
		lblUnesiteBroj.setBounds(60, 157, 121, 15);
		frmRegistracija.add(lblUnesiteBroj);
		
		tfAdresa = new JTextField();
		tfAdresa.setBounds(199, 115, 191, 29);
		frmRegistracija.add(tfAdresa);
		tfAdresa.setColumns(10);
		
		tfBroj = new JTextField();
		tfBroj.setBounds(199, 150, 191, 29);
		frmRegistracija.add(tfBroj);
		tfBroj.setColumns(10);
		
		JLabel lblUnesiteLozinku = new JLabel("Unesite lozinku:");
		lblUnesiteLozinku.setBounds(60, 192, 121, 15);
		frmRegistracija.add(lblUnesiteLozinku);
		
		pfLozinka = new JPasswordField();
		pfLozinka.setBounds(199, 185, 191, 29);
		frmRegistracija.add(pfLozinka);
		pfLozinka.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registruj se");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime = tfIme.getText();
						String prezime = tfPrez.getText();
						String email = tfEmail.getText();
						String brojTel = tfBroj.getText();
						String adresa = tfAdresa.getText();
						String lozinka = String.valueOf(pfLozinka.getPassword());
						if(!ime.isEmpty() && !prezime.isEmpty() && !email.isEmpty() && !adresa.isEmpty() && !brojTel.isEmpty() && !lozinka.isEmpty()) {
							Klijent k = new Klijent();
							k.setAdrKli(adresa);
							k.setEmailKli(email);
							k.setImeKli(ime);
							k.setPassKli(lozinka);
							k.setPrzKli(prezime);
							k.setTelKli(brojTel);
							if(kc.dodajKlijenta(k)) {
								Poruka poruka = new Poruka(frmRegistracija, "Uspešno ste se registrovali", 1, false);
								poruka.prikazi();
							} else {
								Poruka poruka = new Poruka(frmRegistracija, "Uneta email adresa nije validna", 1, true);
								poruka.prikazi();
							}
							getContentPane().setVisible(false);
						}
						else {
							Poruka poruka = new Poruka(frmRegistracija, "Nisu popunjena sva polja.", 1, true);
							poruka.prikazi();
						}					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Zatvori");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
