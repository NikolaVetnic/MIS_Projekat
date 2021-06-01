package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Rezervacija;

public class TableModelRezervacije extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Rezervacija> rezervacije;
	String[] kolone = {"idRez", "datRez", "opisRez", "idKli", "emailKli"};
	
	public TableModelRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rezervacije.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Rezervacija r = rezervacije.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return r.getIdRez();
		case 1:
			return r.getDatRez();
		case 2:
			return r.getOpisRez();
		case 3:
			return r.getKlijent().getIdKli();
		case 4:
			return r.getKlijent().getEmailKli();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getColumnName(int i){
		return kolone[i];
	}

}
