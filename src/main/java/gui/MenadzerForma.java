package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.Radnik;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenadzerForma {

	private static JFrame frmMenadzer;
	private Radnik menadzer;
	private JLabel lblRestoran;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MenadzerForma(Radnik menadzer) {
		initialize(menadzer);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Radnik menadzer) {
		this.menadzer = menadzer;
		frmMenadzer = new JFrame();
		frmMenadzer.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				zatvori();
			}

		});
		frmMenadzer.setTitle("Informacioni sistem Restorana VVV - menadzer " + menadzer.toString());
		frmMenadzer.setBounds(100, 100, 1280, 720);
		frmMenadzer.setMinimumSize(new Dimension(1280, 720));
		frmMenadzer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenadzer.getContentPane().setLayout(null);
		
		lblRestoran = new JLabel("Restoran VVV");
		lblRestoran.setBounds(0, 0, 1280, 63);
		frmMenadzer.getContentPane().add(lblRestoran);
		lblRestoran.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestoran.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblRestoran.setBorder(UIManager.getBorder("Button.border"));
		lblRestoran.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblRestoran.setOpaque(true);
		lblRestoran.setBackground(new Color(0, 128, 128));
		lblRestoran.setForeground(new Color(0, 0, 0));
		frmMenadzer.getContentPane().add(lblRestoran, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 63, 1280, 629);
		tabbedPane.setFocusable(false);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(new Color(0, 128, 128));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		frmMenadzer.getContentPane().add(tabbedPane);
		
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
		
		JButton btnObradarezervacija = new JButton("obradaRezervacija");
		btnObradarezervacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObradaRezervacijaForma orf = new ObradaRezervacijaForma();
				orf.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnObradarezervacija = new GridBagConstraints();
		gbc_btnObradarezervacija.insets = new Insets(0, 0, 5, 5);
		gbc_btnObradarezervacija.gridx = 2;
		gbc_btnObradarezervacija.gridy = 1;
		panel_7.add(btnObradarezervacija, gbc_btnObradarezervacija);
		
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
		gbl_panel_8.columnWeights = new double[]{};
		gbl_panel_8.rowWeights = new double[]{};
		panel_8.setLayout(gbl_panel_8);
		
		JButton btnObradaPorudzbina = new JButton("obradaPorudžbina");
		btnObradaPorudzbina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Poruka poruka = new Poruka(frmMenadzer, "Nije implementirano", 1, true);
				poruka.prikazi();
			}
		});
		GridBagConstraints gbc_btnObradanarudzbina = new GridBagConstraints();
		gbc_btnObradanarudzbina.insets = new Insets(0, 0, 5, 5);
		gbc_btnObradanarudzbina.gridx = 2;
		gbc_btnObradanarudzbina.gridy = 1;
		panel_8.add(btnObradaPorudzbina, gbc_btnObradanarudzbina);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Nabavke", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNabavke = new JLabel("Nabavke");
		lblNabavke.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNabavke.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNabavke, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.CENTER);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JButton btnNabavka = new JButton("Nova nabavka");
		btnNabavka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Poruka poruka = new Poruka(frmMenadzer, "Nije implementirano", 1, true);
				poruka.prikazi();
			}
		});
		
		GridBagConstraints gbc_btnNovaNabavka = new GridBagConstraints();
		gbc_btnNovaNabavka.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovaNabavka.gridx = 2;
		gbc_btnNovaNabavka.gridy = 1;
		panel_9.add(btnNabavka, gbc_btnNovaNabavka);
	}
	
	public static void zatvori() {
		frmMenadzer.dispose();
		KlijentLoginForma.otvori();
	}
	
	public void otvori() {
		frmMenadzer.setVisible(true);
	}
}
