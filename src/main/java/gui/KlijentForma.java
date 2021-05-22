package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import crud.KlijentCrud;
import model.Klijent;

public class KlijentForma {
	private JFrame frmKlijent;
	private JPasswordField pfNovaLozinkaPonovo;
	private JPasswordField pfNovaLozinka;
	private JPasswordField pfStaraLozinka;
	private JTextField tfKorisničkoIme;
	private JLabel lblTrenutnoKorisničkoIme;
	private Klijent klijent;
	private JLabel lblRestoran;
	
	public KlijentForma(Klijent klijent) {
		initialize(klijent);
	}
	
	private void initialize(Klijent klijent) {
		this.klijent = klijent;
		frmKlijent = new JFrame();
		frmKlijent.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				zatvori();
			}

		});
		frmKlijent.setTitle("Informacioni sistem Restorana VVV - klijent " + klijent.toString());
		frmKlijent.setBounds(100, 100, 1280, 720);
		frmKlijent.setMinimumSize(new Dimension(1280, 720));
		frmKlijent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmKlijent.getContentPane().setLayout(new BorderLayout(0, 0));
		
		lblRestoran = new JLabel("Restoran VVV");
		lblRestoran.setBounds(165, 12, 70, 15);
		frmKlijent.getContentPane().add(lblRestoran);
		lblRestoran.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestoran.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRestoran.setBorder(UIManager.getBorder("Button.border"));
		lblRestoran.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblRestoran.setOpaque(true);
		lblRestoran.setBackground(new Color(0, 128, 128));
		lblRestoran.setForeground(new Color(0, 0, 0));
		frmKlijent.getContentPane().add(lblRestoran, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusable(false);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(new Color(0, 128, 128));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		frmKlijent.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(240, 248, 255));
		tabbedPane.addTab("Početna", null, panel, null);
		tabbedPane.setBackgroundAt(0, new Color(230, 230, 250));
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPočetna = new JLabel("Početna");
		lblPočetna.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPočetna.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPočetna, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(240, 248, 255));
		tabbedPane.addTab("Rezervacije", null, panel_1, null);
		tabbedPane.setBackgroundAt(1, new Color(230, 230, 250));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRezervacije = new JLabel("Rezervacije");
		lblRezervacije.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRezervacije.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblRezervacije, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.CENTER);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JButton btnRezervacija = new JButton("Nova rezervacija");
		btnRezervacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnRezervacija.setFocusable(false);
		btnRezervacija.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnRezervacija = new GridBagConstraints();
		gbc_btnRezervacija.insets = new Insets(0, 0, 5, 5);
		gbc_btnRezervacija.gridx = 1;
		gbc_btnRezervacija.gridy = 1;
		panel_7.add(btnRezervacija, gbc_btnRezervacija);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Porudžbine", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPorudžbine = new JLabel("Porudžbine");
		lblPorudžbine.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPorudžbine.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblPorudžbine, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Podešavanje profila", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPodesavanje = new JLabel("Profil");
		lblPodesavanje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodesavanje.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblPodesavanje, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{90, 337, 90, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblPromenaKorisnickogImena = new JLabel("Promena korisničkog imena:");
		lblPromenaKorisnickogImena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPromenaKorisnickogImena = new GridBagConstraints();
		gbc_lblPromenaKorisnickogImena.insets = new Insets(0, 0, 5, 5);
		gbc_lblPromenaKorisnickogImena.gridx = 1;
		gbc_lblPromenaKorisnickogImena.gridy = 1;
		panel_6.add(lblPromenaKorisnickogImena, gbc_lblPromenaKorisnickogImena);
		
		JLabel lblTrenutnoKorisničko = new JLabel("Vaše trenutno korisničko ime:");
		lblTrenutnoKorisničko.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTrenutnoKorisničko = new GridBagConstraints();
		gbc_lblTrenutnoKorisničko.anchor = GridBagConstraints.EAST;
		gbc_lblTrenutnoKorisničko.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrenutnoKorisničko.gridx = 0;
		gbc_lblTrenutnoKorisničko.gridy = 2;
		panel_6.add(lblTrenutnoKorisničko, gbc_lblTrenutnoKorisničko);
		
		lblTrenutnoKorisničkoIme = klijent.getImeKli() == null ? new JLabel("nije podešeno") : new JLabel(klijent.getImeKli());
		lblTrenutnoKorisničkoIme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTrenutnoKorisničkoIme = new GridBagConstraints();
		gbc_lblTrenutnoKorisničkoIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrenutnoKorisničkoIme.gridx = 1;
		gbc_lblTrenutnoKorisničkoIme.gridy = 2;
		panel_6.add(lblTrenutnoKorisničkoIme, gbc_lblTrenutnoKorisničkoIme);
		
		JLabel lblNovoKorisničko = new JLabel("Unesite novo korisničko ime:");
		lblNovoKorisničko.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNovoKorisničko = new GridBagConstraints();
		gbc_lblNovoKorisničko.anchor = GridBagConstraints.EAST;
		gbc_lblNovoKorisničko.insets = new Insets(0, 0, 5, 5);
		gbc_lblNovoKorisničko.gridx = 0;
		gbc_lblNovoKorisničko.gridy = 3;
		panel_6.add(lblNovoKorisničko, gbc_lblNovoKorisničko);
		
		tfKorisničkoIme = new JTextField();
		tfKorisničkoIme.setHorizontalAlignment(SwingConstants.CENTER);
		tfKorisničkoIme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tfKorisničkoIme = new GridBagConstraints();
		gbc_tfKorisničkoIme.insets = new Insets(0, 0, 5, 5);
		gbc_tfKorisničkoIme.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKorisničkoIme.gridx = 1;
		gbc_tfKorisničkoIme.gridy = 3;
		panel_6.add(tfKorisničkoIme, gbc_tfKorisničkoIme);
		tfKorisničkoIme.setColumns(10);			
		
		JButton btnPromeniKorisnickoIme = new JButton("Promeni korisničko ime");
		btnPromeniKorisnickoIme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				KlijentCrud kCrud = new KlijentCrud();
				String ime = tfKorisničkoIme.getText();
				
				if (!ime.trim().isEmpty()) {
					if (kCrud.promeniIme(klijent, ime)) {
						
						Poruka poruka = new Poruka(frmKlijent, "Uspešno ste promenili korisničko ime.", 1, false);
						poruka.prikazi();
						
						tfKorisničkoIme.setText("");
						lblTrenutnoKorisničkoIme.setText(ime);
						
					} else {
						
						Poruka poruka = new Poruka(frmKlijent, "Greška prilikom promene korisničkog imena.", 1, true);
						poruka.prikazi();
					}
				} else {
					Poruka poruka = new Poruka(frmKlijent, "Polje za novo korisničko ime je prazno", 1, true);
					poruka.prikazi();
				} 
			}
		});
		btnPromeniKorisnickoIme.setFocusable(false);
		btnPromeniKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnPromeniKorisnickoIme = new GridBagConstraints();
		gbc_btnPromeniKorisnickoIme.insets = new Insets(0, 0, 5, 5);
		gbc_btnPromeniKorisnickoIme.gridx = 1;
		gbc_btnPromeniKorisnickoIme.gridy = 4;
		panel_6.add(btnPromeniKorisnickoIme, gbc_btnPromeniKorisnickoIme);
		
		JLabel lblPromenaLozinke = new JLabel("Promena lozinke");
		lblPromenaLozinke.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPromenaLozinke.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPromenaLozinke = new GridBagConstraints();
		gbc_lblPromenaLozinke.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPromenaLozinke.insets = new Insets(0, 0, 5, 5);
		gbc_lblPromenaLozinke.gridx = 1;
		gbc_lblPromenaLozinke.gridy = 6;
		panel_6.add(lblPromenaLozinke, gbc_lblPromenaLozinke);
		
		JLabel lblStaraLozinka = new JLabel("Stara lozinka:");
		lblStaraLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblStaraLozinka = new GridBagConstraints();
		gbc_lblStaraLozinka.anchor = GridBagConstraints.EAST;
		gbc_lblStaraLozinka.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaraLozinka.gridx = 0;
		gbc_lblStaraLozinka.gridy = 7;
		panel_6.add(lblStaraLozinka, gbc_lblStaraLozinka);
		
		pfStaraLozinka = new JPasswordField();
		pfStaraLozinka.setHorizontalAlignment(SwingConstants.CENTER);
		pfStaraLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_pfStaraLozinka = new GridBagConstraints();
		gbc_pfStaraLozinka.insets = new Insets(0, 0, 5, 5);
		gbc_pfStaraLozinka.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfStaraLozinka.gridx = 1;
		gbc_pfStaraLozinka.gridy = 7;
		panel_6.add(pfStaraLozinka, gbc_pfStaraLozinka);
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		lblNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNovaLozinka = new GridBagConstraints();
		gbc_lblNovaLozinka.anchor = GridBagConstraints.EAST;
		gbc_lblNovaLozinka.insets = new Insets(0, 0, 5, 5);
		gbc_lblNovaLozinka.gridx = 0;
		gbc_lblNovaLozinka.gridy = 8;
		panel_6.add(lblNovaLozinka, gbc_lblNovaLozinka);
		
		pfNovaLozinka = new JPasswordField();
		pfNovaLozinka.setHorizontalAlignment(SwingConstants.CENTER);
		pfNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_pfNovaLozinka = new GridBagConstraints();
		gbc_pfNovaLozinka.insets = new Insets(0, 0, 5, 5);
		gbc_pfNovaLozinka.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfNovaLozinka.gridx = 1;
		gbc_pfNovaLozinka.gridy = 8;
		panel_6.add(pfNovaLozinka, gbc_pfNovaLozinka);
		
		JLabel lblNovaLozinkaPonovo = new JLabel("Ponovite novu lozinku:");
		lblNovaLozinkaPonovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNovaLozinkaPonovo = new GridBagConstraints();
		gbc_lblNovaLozinkaPonovo.anchor = GridBagConstraints.EAST;
		gbc_lblNovaLozinkaPonovo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNovaLozinkaPonovo.gridx = 0;
		gbc_lblNovaLozinkaPonovo.gridy = 9;
		panel_6.add(lblNovaLozinkaPonovo, gbc_lblNovaLozinkaPonovo);
		
		pfNovaLozinkaPonovo = new JPasswordField();
		pfNovaLozinkaPonovo.setHorizontalAlignment(SwingConstants.CENTER);
		pfNovaLozinkaPonovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_pfNovaLozinkaPonovo = new GridBagConstraints();
		gbc_pfNovaLozinkaPonovo.insets = new Insets(0, 0, 5, 5);
		gbc_pfNovaLozinkaPonovo.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfNovaLozinkaPonovo.gridx = 1;
		gbc_pfNovaLozinkaPonovo.gridy = 9;
		panel_6.add(pfNovaLozinkaPonovo, gbc_pfNovaLozinkaPonovo);
		
		JButton btnPromeniLozinku = new JButton("Promeni lozinku");
		btnPromeniLozinku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stara 		= String.valueOf(pfStaraLozinka.getPassword());
				String nova 		= String.valueOf(pfNovaLozinka.getPassword());
				String novaPonovo 	= String.valueOf(pfNovaLozinkaPonovo.getPassword());
				
				if (stara.trim().isEmpty() || nova.trim().isEmpty() || novaPonovo.trim().isEmpty()) {
					
					Poruka poruka = new Poruka(frmKlijent, "Nisu popunjena sva polja za promenu lozinke", 1, true);
					poruka.prikazi();
				} else {
					if (stara.equals(klijent.getPassKli()) && nova.equals(novaPonovo)) {
						
						KlijentCrud kCrud = new KlijentCrud();
						
						if (kCrud.promeniPassword(klijent, nova)) {
							
							Poruka poruka = new Poruka(frmKlijent, "Uspešno ste promenili lozinku", 1, false);
							poruka.prikazi();
							
							pfStaraLozinka.setText("");
							pfNovaLozinka.setText("");
							pfNovaLozinkaPonovo.setText("");
							
						} else {
							
							Poruka poruka = new Poruka(frmKlijent, "Greška prilikom promene lozinke", 1, true);
							poruka.prikazi();
						}
					} else {
						
						Poruka poruka = new Poruka(frmKlijent, "Uneti podaci se ne poklapaju", 1, true);
						poruka.prikazi();
					}
				}
			}
		});
		
		btnPromeniLozinku.setFocusable(false);
		btnPromeniLozinku.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnPromeniLozinku = new GridBagConstraints();
		gbc_btnPromeniLozinku.insets = new Insets(0, 0, 5, 5);
		gbc_btnPromeniLozinku.gridx = 1;
		gbc_btnPromeniLozinku.gridy = 10;
		panel_6.add(btnPromeniLozinku, gbc_btnPromeniLozinku);
	}
																					
	public void zatvori() {											
		frmKlijent.dispose();
		KlijentLoginForma.otvori();
	}
	
	public void otvori() {
		frmKlijent.setVisible(true);
	}
	
	
}