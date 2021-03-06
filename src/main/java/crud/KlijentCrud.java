package crud;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Klijent;
import model.KlijentFields;
import model.Rezervacija;
import utils.DateConverter;
import utils.PersistenceUtil;

public class KlijentCrud {
	
	
	public boolean dodajKlijenta(Klijent k) {
		
		boolean ok;
		Klijent postojeci = nadjiKlijenta(k.getEmailKli());
		if(postojeci == null)
			ok = true;
		else
			ok = false;
		if(ok) {
			EntityManager em = PersistenceUtil.getEntityManager();
			EntityTransaction et = null;
			
			try {
				
				et = em.getTransaction();
				et.begin();
				
				em.persist(k);
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
	
	public Klijent nadjiKlijenta(String email) {
		EntityManager em = PersistenceUtil.getEntityManager();
		
		Query q = em.createQuery("select k from Klijent k where k.emailKli=:email");
		q.setParameter("email", email);
		Klijent k;
        @SuppressWarnings("unchecked")
		List<Klijent> klijenti = q.getResultList();
        if(klijenti.isEmpty())
        	k = null;
        else
        	k = klijenti.get(0);
	    em.close();
	        
	    return k;
	}
	
	public boolean promeniIme(Klijent k, String novoIme) {
		return promeni(k, novoIme, KlijentFields.IME);
	}
	
	
	public boolean promeniPrezime(Klijent k, String novoPrezime) {
		return promeni(k, novoPrezime, KlijentFields.PREZIME);
	}
	
	
	public boolean promeniAdresu(Klijent k, String novaAdresa) {
		return promeni(k, novaAdresa, KlijentFields.ADRESA);
	}
	
	
	public boolean promeniTelefon(Klijent k, String noviTel) {
		return promeni(k, noviTel, KlijentFields.TELEFON);
	}
	
	
	public boolean promeniEmail(Klijent k, String noviEmail) {
		return promeni(k, noviEmail, KlijentFields.EMAIL);
	}
	
	
	public boolean promeniPassword(Klijent k, String noviPass) {
		return promeni(k, noviPass, KlijentFields.PASS);
	}
	
	
	private boolean promeni(Klijent k, String val, KlijentFields field) {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		
		boolean res = false;
		
		try {
			
			et = em.getTransaction();
			et.begin();	
			
			Klijent tmp = em.merge(k);
			
			switch (field) {
				case IME:		tmp.setImeKli(val);		break;
				case PREZIME:	tmp.setPrzKli(val);		break;
				case ADRESA:	tmp.setAdrKli(val);		break;
				case TELEFON:	tmp.setTelKli(val);	break;
				case EMAIL:		tmp.setEmailKli(val);	break;
				case PASS:		tmp.setPassKli(val);	break;
				default:	
			}
			
			em.merge(tmp);
			
			em.flush();
			et.commit();
			
			res = true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			if (et != null)
				et.rollback();
			
			res = false;
			
		} finally {
			
			if (em != null)
				em.close();
		}
		
		return res;
	}
	
	
	public boolean obrisiKlijenta(Klijent k) {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		
		boolean res = false;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			
			Klijent tmp = em.merge(k);
			em.remove(tmp);
			
			em.flush();
			et.commit();
			
			res = true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			if (et != null)
				et.rollback();
			
		} finally {
			
			if (em != null)
				em.close();
		}
		
		return res;
	}

	
	@SuppressWarnings("unchecked")
	public List<Klijent> listaKlijenata() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select k from Klijent k";	// HQL->SQL : SELECT * FROM Student;
		List<Klijent> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list;
	}

	
	public List<Rezervacija> listaRezervacijaZaKlijentaZaDan(Klijent k, LocalDate date) {
		
		if (k != null)
			return k.getRezervacije().stream()
					.filter(r -> DateConverter.convertToLocalDateViaInstant(r.getDatRez()).equals(date))
					.collect(Collectors.toList());
		
		return null;
	}

	
	public List<Rezervacija> listaRezervacijaZaKlijentaZaDan(String ime, String pass, LocalDate date) {
		
		Klijent k = pronadjiKlijenta(ime, pass);
		
		if (k != null)
			return k.getRezervacije().stream()
					.filter(r -> DateConverter.convertToLocalDateViaInstant(r.getDatRez()).equals(date))
					.collect(Collectors.toList());
		
		return null;
	}

	
	public List<Rezervacija> listaRezervacijaZaDan(LocalDate date) {
		
		List<Klijent> klijenti = listaKlijenata();
		
		if (klijenti != null)
			return klijenti.stream()
					.flatMap(k -> k.getRezervacije().stream())
					.filter(r -> DateConverter.convertToLocalDateViaInstant(r.getDatRez()).equals(date))
					.collect(Collectors.toList());
		
		return null;
	}
	
	
	public static Klijent pronadjiKlijenta(String ime, String pass) {
		
        EntityManager em = PersistenceUtil.getEntityManager();
        
        Query q = em.createQuery("select k from Klijent k where k.imeKli=:ime and k.passKli=:pass");
        
        q.setParameter("ime", ime);
        q.setParameter("pass", pass);
        
        Klijent k = (Klijent) q.getSingleResult();
        
        em.close();
        
        return k;
    }
}
