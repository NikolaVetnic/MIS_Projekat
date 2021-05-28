package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Radnik;
import utils.PersistenceUtil;

public class RadnikCrud {

	
	@SuppressWarnings("unchecked")
	public List<Radnik> listaRadnika() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select r from Radnik r";	// HQL->SQL : SELECT * FROM Student;
		List<Radnik> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public Radnik pronadjiRadnika(int id) {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select r from Radnik r";	// HQL->SQL : SELECT * FROM Student;
		List<Radnik> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list.stream().filter(r -> r.getIdRad() == id).findFirst().orElse(null);
	}
	
	public static Radnik pronadjiRadnika(String ime, String pass) {
		 EntityManager em = PersistenceUtil.getEntityManager();
	        
	        Query q = em.createQuery("select r from Radnik r where r.imeRad=:ime and r.passRad=:pass");
	        
	        q.setParameter("ime", ime);
	        q.setParameter("pass", pass);
	        
	        Radnik r = (Radnik) q.getSingleResult();
	        
	        em.close();
	        
	        return r;
	}
}
