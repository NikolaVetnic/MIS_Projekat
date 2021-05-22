package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Klijent;
import model.KlijentFields;
import utils.PersistenceUtil;

public class KlijentCrud {
	
	
	public void dodajKlijenta(Klijent k) {
		
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
	
	
	public boolean promeniIme(Klijent k, String novoIme) {
		return promeni(k, novoIme, KlijentFields.IME);
	}
	
	
	public boolean promeniPassword(Klijent k, String noviPass) {
		return promeni(k, noviPass, KlijentFields.PASS);
	}
	
	
	public boolean promeniEmail(Klijent k, String noviEmail) {
		return promeni(k, noviEmail, KlijentFields.EMAIL);
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
				case IME:	tmp.setImeKli(val);		break;
				case PASS:	tmp.setPassKli(val);	break;
				case EMAIL:	tmp.setEmailKli(val);	break;
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
