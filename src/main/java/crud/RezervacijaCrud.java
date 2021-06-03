package crud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Klijent;
import model.Rezervacija;
import model.Sto;
import utils.DateConverter;
import utils.PersistenceUtil;

public class RezervacijaCrud {
	
	
	public boolean dodajRezervaciju(Klijent k, LocalDate d, Sto s, String opis) {
		StoCrud stoCrud = new StoCrud();
		Rezervacija rez = stoCrud.listaRezervacija(s, d);
		boolean ok;
		if(rez == null) {
			ok = true;
		} else {
			ok = false;
		}
		if (ok) {	
			EntityManager em = PersistenceUtil.getEntityManager();
			EntityTransaction et = null;
		
			try {
				
				Rezervacija r = new Rezervacija();
				r.setKlijent(k);
				r.setDatRez(DateConverter.convertToDateViaInstant(d));
				r.setSto(s);
				r.setOpisRez(opis);
				
				et = em.getTransaction();
				et.begin();
				
				em.persist(r);
				
				em.flush();
				et.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				
				if (et != null)
					et.rollback();
			} finally {
				if (em != null)
					em.close();
			}
		}
		return ok;
	}
}
