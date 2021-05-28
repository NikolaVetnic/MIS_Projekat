package crud;

import java.util.List;

import javax.persistence.EntityManager;

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
}
