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
	private static JFrame frmKlijent;
	private JPasswordField pfNovaLozinkaPonovo;
	private JPasswordField pfNovaLozinka;
	private JPasswordField pfStaraLozinka;
	private JTextField tfBroj;
	private JLabel lblTrenutniBroj;
	private Klijent klijent;
	private JLabel lblRestoran;
	private JTextField tfAdresa;
	private JTextField textField;
	private JLabel lblTrenutnaAdresa;
	
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
				RezervacijaForma rf = new RezervacijaForma(klijent);
				rf.setVisible(true);
			}
		});
		
		btnRezervacija.setFocusable(false);
		btnRezervacija.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnRezervacija = new GridBagConstraints();
		gbc_btnRezervacija.insets = new Insets(0, 0, 5, 5);
		gbc_btnRezervacija.gridx = 2;
		gbc_btnRezervacija.gridy = 1;
		panel_7.add(btnRezervacija, gbc_btnRezervacija);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Porudžbine", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPorudžbine = new JLabel("Porudžbine");
		lblPorudžbine.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPorudžbine.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblPorudžbine, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.CENTER);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JButton btnNarudzbina = new JButton("Nova narudžbina");
		btnNarudzbina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NarudzbinaForma nf = new NarudzbinaForma();
				nf.setVisible(true);
			}
		});
		
		btnNarudzbina.setFocusable(false);
		btnNarudzbina.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNarudzbina = new GridBagConstraints();
		gbc_btnNarudzbina.insets = new Insets(0, 0, 5, 5);
		gbc_btnNarudzbina.gridx = 2;
		gbc_btnNarudzbina.gridy = 1;
		panel_8.add(btnNarudzbina, gbc_btnNarudzbina);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Podešavanje profila", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPodesavanje = new JLabel("Profil");
		lblPodesavanje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodesavanje.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblPodesavanje, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		JLabel lblPromenaBrojaTelefona = new JLabel("Promena broja telefona");
		lblPromenaBrojaTelefona.setBounds(664, 90, 182, 19);
		lblPromenaBrojaTelefona.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblPromenaBrojaTelefona);
		
		JLabel lblTrenutniKorisnički = new JLabel("Vaše trenutni korisnički broj:");
		lblTrenutniKorisnički.setBounds(346, 114, 221, 19);
		lblTrenutniKorisnički.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblTrenutniKorisnički);
		
		JLabel label = new JLabel(klijent.getTelKli());
		label.setBounds(674, 114, 149, 15);
		lblTrenutniBroj = klijent.getTelKli() == null ? new JLabel("nije podešeno") : label;
		lblTrenutniBroj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTrenutniBroj = new GridBagConstraints();
		gbc_lblTrenutniBroj.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrenutniBroj.gridx = 1;
		gbc_lblTrenutniBroj.gridy = 2;
		panel_6.add(lblTrenutniBroj, gbc_lblTrenutniBroj);
		
		JLabel lblNoviKorisnički = new JLabel("Unesite novi korisnički broj:");
		lblNoviKorisnički.setBounds(355, 145, 212, 19);
		lblNoviKorisnički.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblNoviKorisnički);
		
		tfBroj = new JTextField();
		tfBroj.setBounds(572, 140, 332, 29);
		tfBroj.setHorizontalAlignment(SwingConstants.CENTER);
		tfBroj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(tfBroj);
		tfBroj.setColumns(10);			
		
		JButton btnPromeniBroj = new JButton("Promeni broj");
		btnPromeniBroj.setBounds(664, 171, 182, 29);
		btnPromeniBroj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				KlijentCrud kCrud = new KlijentCrud();
				String broj = tfBroj.getText();
				
				if (!broj.trim().isEmpty()) {
					if (kCrud.promeniTelefon(klijent, broj)) {
						
						Poruka poruka = new Poruka(frmKlijent, "Uspešno ste promenili broj.", 1, false);
						poruka.prikazi();
						
						tfBroj.setText("");
						lblTrenutniBroj.setText(broj);
						
					} else {
						
						Poruka poruka = new Poruka(frmKlijent, "Greška prilikom promene broja.", 1, true);
						poruka.prikazi();
					}
				} else {
					Poruka poruka = new Poruka(frmKlijent, "Polje za novi broj je prazno", 1, true);
					poruka.prikazi();
				} 
			}
		});
		btnPromeniBroj.setFocusable(false);
		btnPromeniBroj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(btnPromeniBroj);
		
		JLabel lblPromenaAdrese = new JLabel("Promena adrese");
		lblPromenaAdrese.setBounds(664, 207, 133, 19);
		lblPromenaAdrese.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblPromenaAdrese);
		
		lblTrenutnaAdresa = new JLabel("Vaša trenutna adresa:");
		lblTrenutnaAdresa.setBounds(394, 229, 173, 19);
		lblTrenutnaAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblTrenutnaAdresa);
		
		JLabel label_1 = new JLabel(klijent.getAdrKli());
		label_1.setBounds(572, 231, 332, 15);
		lblTrenutnaAdresa = klijent.getAdrKli() == null ? new JLabel("nije podešeno") : label_1;
		lblTrenutnaAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTrenutnaAdresaaa = new GridBagConstraints();
		gbc_lblTrenutnaAdresaaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrenutnaAdresaaa.gridx = 1;
		gbc_lblTrenutnaAdresaaa.gridy = 2;
		panel_6.add(lblTrenutnaAdresa, gbc_lblTrenutnaAdresaaa);
		
		JLabel lblNovaAdresa = new JLabel("Unesite novu adresu:");
		lblNovaAdresa.setBounds(401, 260, 166, 19);
		lblNovaAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblNovaAdresa);
		
		tfAdresa = new JTextField();
		tfAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		tfAdresa.setFont(new Font("Dialog", Font.PLAIN, 16));
		tfAdresa.setColumns(10);
		tfAdresa.setBounds(572, 255, 332, 29);
		panel_6.add(tfAdresa);
		
		JButton btnPromeniAdresu = new JButton("Promeni adresu");
		btnPromeniAdresu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KlijentCrud kCrud = new KlijentCrud();
				String adresa = tfAdresa.getText();
				
				if (!adresa.trim().isEmpty()) {
					if (kCrud.promeniAdresu(klijent, adresa)) {
						
						Poruka poruka = new Poruka(frmKlijent, "Uspešno ste promenili adresu.", 1, false);
						poruka.prikazi();
						
						tfAdresa.setText("");
						lblTrenutnaAdresa.setText(adresa);
						
					} else {
						
						Poruka poruka = new Poruka(frmKlijent, "Greška prilikom promene adrese.", 1, true);
						poruka.prikazi();
					}
				} else {
					Poruka poruka = new Poruka(frmKlijent, "Polje za novu adresu je prazno", 1, true);
					poruka.prikazi();
				} 
			}
		});
		btnPromeniAdresu.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnPromeniAdresu.setFocusable(false);
		btnPromeniAdresu.setBounds(664, 286, 182, 29);
		panel_6.add(btnPromeniAdresu);
		
		JLabel lblStaraLozinka = new JLabel("Stara lozinka:");
		lblStaraLozinka.setBounds(463, 355, 104, 19);
		lblStaraLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblStaraLozinka);
		
		pfStaraLozinka = new JPasswordField();
		pfStaraLozinka.setBounds(572, 350, 332, 29);
		pfStaraLozinka.setHorizontalAlignment(SwingConstants.CENTER);
		pfStaraLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(pfStaraLozinka);
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		lblNovaLozinka.setBounds(463, 385, 103, 19);
		lblNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblNovaLozinka);
		
		pfNovaLozinka = new JPasswordField();
		pfNovaLozinka.setBounds(572, 383, 332, 29);
		pfNovaLozinka.setHorizontalAlignment(SwingConstants.CENTER);
		pfNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(pfNovaLozinka);
		
		JLabel lblNovaLozinkaPonovo = new JLabel("Ponovite novu lozinku:");
		lblNovaLozinkaPonovo.setBounds(392, 420, 175, 19);
		lblNovaLozinkaPonovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblNovaLozinkaPonovo);
		
		pfNovaLozinkaPonovo = new JPasswordField();
		pfNovaLozinkaPonovo.setBounds(572, 415, 332, 29);
		pfNovaLozinkaPonovo.setHorizontalAlignment(SwingConstants.CENTER);
		pfNovaLozinkaPonovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(pfNovaLozinkaPonovo);
		
		JButton btnPromeniLozinku = new JButton("Promeni lozinku");
		btnPromeniLozinku.setBounds(664, 446, 182, 29);
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
							zatvori();
							
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
		panel_6.add(btnPromeniLozinku);
		
		JLabel lblPromenaLozinke = new JLabel("Promena lozinke");
		lblPromenaLozinke.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblPromenaLozinke.setBounds(664, 326, 133, 15);
		panel_6.add(lblPromenaLozinke);
	}
																					
	public static void zatvori() {											
		frmKlijent.dispose();
		KlijentLoginForma.otvori();
	}
	
	public void otvori() {
		frmKlijent.setVisible(true);
	}
}