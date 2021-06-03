package gui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Poruka extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public Poruka(JFrame forma, String poruka, int sekunde, boolean greska) {
		super();
		super.setModal(true);
		super.setUndecorated(true);
		JLabel lbl = new JLabel(poruka);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl.setOpaque(true);
		lbl.setBackground(greska ? new Color(240, 80, 80) : new Color(39, 194, 76));
		super.getContentPane().add(lbl);
		super.setSize(lbl.getPreferredSize().width + 100, 75);
		super.setLocationRelativeTo(forma);
		new Nit(this, sekunde * 1000).start();
	}
	
	public Poruka(JDialog dijalog, String poruka, int sekunde, boolean greska) {
		super();
		super.setModal(true);
		super.setUndecorated(true);
		JLabel lbl = new JLabel(poruka);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl.setOpaque(true);
		lbl.setBackground(greska ? new Color(240, 80, 80) : new Color(39, 194, 76));
		super.getContentPane().add(lbl);
		super.setSize(lbl.getPreferredSize().width + 100, 75);
		super.setLocationRelativeTo(dijalog);
		new Nit(this, sekunde * 1000).start();
	}
	
	public Poruka(JPanel panel, String poruka, int sekunde, boolean greska) {
		super();
		super.setModal(true);
		super.setUndecorated(true);
		JLabel lbl = new JLabel(poruka);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl.setOpaque(true);
		lbl.setBackground(greska ? new Color(240, 80, 80) : new Color(39, 194, 76));
		super.getContentPane().add(lbl);
		super.setSize(lbl.getPreferredSize().width + 100, 75);
		super.setLocationRelativeTo(panel);
		new Nit(this, sekunde * 1000).start();
	}
	
	public void prikazi() {
		super.setVisible(true);
	}
	
	private class Nit extends Thread {
		private Poruka poruka;
		private int ms;
		
		public Nit(Poruka poruka, int ms) {
			this.poruka = poruka;
			this.ms = ms;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(ms);
				poruka.dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
