package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import crud.KlijentCrud;
import crud.RadnikCrud;
import model.Klijent;
import model.Radnik;

public class RadnikLoginForma{
		
	private static JTextField tfKorisnickoIme;
	private static JFrame restoranForma;
	private static JLabel lblRestoran;
	private static JPasswordField pfLozinka;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		RadnikLoginForma.otvori();
	}

	/**
	 * Create the application.
	 */
	static {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Greška prilikom podešavanja GUI-ja");
		}
		restoranForma = new JFrame();
		restoranForma.setTitle("Informacioni sistem restorana VVV - zaposleni");
		restoranForma.setBounds(100, 100, 1280, 720);
		restoranForma.setMinimumSize(new Dimension(1280, 720));
		restoranForma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblRestoran = new JLabel("Restoran VVV");
		lblRestoran.setBounds(165, 12, 70, 15);
		restoranForma.getContentPane().add(lblRestoran);
		lblRestoran.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestoran.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRestoran.setBorder(UIManager.getBorder("Button.border"));
		lblRestoran.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblRestoran.setOpaque(true);
		lblRestoran.setBackground(new Color(0, 128, 128));
		lblRestoran.setForeground(new Color(0, 0, 0));
		restoranForma.getContentPane().add(lblRestoran, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		restoranForma.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("PRIJAVA");
		lblNewLabel_11.setBounds(485, 206, 299, 29);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_11);
		
		tfKorisnickoIme = new JTextField();
		tfKorisnickoIme.setBounds(524, 275, 226, 29);
		tfKorisnickoIme.setMinimumSize(new Dimension(400, 19));
		tfKorisnickoIme.setMaximumSize(new Dimension(400, 2147483647));
		tfKorisnickoIme.setHorizontalAlignment(SwingConstants.LEFT);
		tfKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(tfKorisnickoIme);
		tfKorisnickoIme.setColumns(10);
		
		pfLozinka = new JPasswordField();
		pfLozinka.setBounds(524, 326, 226, 29);
		pfLozinka.setHorizontalAlignment(SwingConstants.LEFT);
		pfLozinka.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(pfLozinka);
		
		JButton btnPrijava = new JButton("Prijava");
		btnPrijava.setBounds(597, 367, 84, 29);
		btnPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prijaviSe();
			}
		});
		btnPrijava.setFocusable(false);
		btnPrijava.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(btnPrijava);
		
		JLabel lbl = new JLabel("<html><body style=\"text-align:center\">\u00A9 2021 - Restoran VVV<br></body></html>");
		lbl.setBounds(558, 462, 157, 15);
		panel_1.add(lbl);
		
		JLabel lblKorisničkoIme = new JLabel("Korisničko ime");
		lblKorisničkoIme.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKorisničkoIme.setBounds(524, 259, 110, 15);
		panel_1.add(lblKorisničkoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka");
		lblLozinka.setBounds(534, 309, 70, 15);
		panel_1.add(lblLozinka);
	}
	
	public static void otvori() {
		restoranForma.setVisible(true);
	}
	
	public static void zatvori() {
		restoranForma.setVisible(false);
		tfKorisnickoIme.setText("");
		pfLozinka.setText("");
	}
	
	public static void prijaviSe() {
		String korisnickoIme = tfKorisnickoIme.getText();
		String lozinka = String.valueOf(pfLozinka.getPassword());
		if (!korisnickoIme.isEmpty() && !lozinka.isEmpty()) {
				try {
						Radnik r = RadnikCrud.pronadjiRadnika(korisnickoIme, lozinka);
						if(r.getRadnoMesto().getOpisRM().equals("Menadzer")) {
							Poruka poruka = new Poruka(restoranForma, "Uspešno ste se prijavili kao menadzer", 1, false);
							poruka.prikazi();
							zatvori();
							MenadzerForma menadzerForma = new MenadzerForma(r);
							menadzerForma.otvori();
						} else {
							Poruka poruka = new Poruka(restoranForma, "Forma za konobara nije implementirana", 1, true);
							poruka.prikazi();
						}
				} catch (Exception e) {
					Poruka poruka = new Poruka(restoranForma, "Uneti podaci nisu ispravni.", 1, true);
					poruka.prikazi();
				}
			} else if(korisnickoIme.isEmpty() || lozinka.isEmpty()) {
				Poruka poruka = new Poruka(restoranForma, "Nisu popunjena sva polja.", 1, true);
				poruka.prikazi();
			} else {
				Poruka poruka = new Poruka(restoranForma, "Podaci nisu validni.", 1, true);
				poruka.prikazi();
			}
		}
	}	
