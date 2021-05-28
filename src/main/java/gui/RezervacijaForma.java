package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import crud.StoCrud;
import model.Sto;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class RezervacijaForma extends JDialog {
	
	public static class DateComboBoxRenderer extends DefaultListCellRenderer {

        // desired format for the date
        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Object item = value;

            // if the item to be rendered is date then format it
            if( item instanceof Date ) {
                item = dateFormat.format( ( Date ) item );
            }
            return super.getListCellRendererComponent( list, item, index, isSelected, cellHasFocus);
        }
    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final JPanel frmRezervacija = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RezervacijaForma() {
		setTitle("Nova rezervacija");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		frmRezervacija.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(frmRezervacija, BorderLayout.CENTER);
		frmRezervacija.setLayout(null);
		{
			JLabel lblUnesiDatum = new JLabel("Izaberi datum:");
			lblUnesiDatum.setBounds(74, 113, 103, 15);
			frmRezervacija.add(lblUnesiDatum);
		}
		{
			JLabel lblIzaberiSto = new JLabel("Izaberi sto:");
			lblIzaberiSto.setBounds(74, 47, 108, 15);
			frmRezervacija.add(lblIzaberiSto);
		}
		 StoCrud sc = new StoCrud();
		 List<Sto> stolovi = sc.listaStolova();
		{
			JComboBox<Sto> sto = new JComboBox<Sto>();
			for(Sto s: stolovi) {
					sto.addItem(s);
			}
			sto.setBounds(200, 42, 152, 24);
			frmRezervacija.add(sto);
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
		combo.setBounds(198, 108, 154, 24);
		frmRezervacija.add(combo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRezervisi = new JButton("Rezerviši");
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
