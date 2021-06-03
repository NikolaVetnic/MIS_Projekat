package crud;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Klijent;
import model.Rezervacija;
import model.Sto;
import utils.DateConverter;
import utils.PersistenceUtil;

public class RezervacijaCrud {
	
	
	public void dodajRezervaciju(Klijent k, LocalDate d, Sto s, String opis) {
		
		StoCrud stoCrud = new StoCrud();
		List<Rezervacija> rez = stoCrud.listaRezervacija(s);
		
		if (rez != null || rez.size() != 0) {
			
			System.err.println("!! Sto ZAUZET...");
			return;
		}
		
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
}
