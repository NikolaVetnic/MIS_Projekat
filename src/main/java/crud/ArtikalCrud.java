package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Artikal;
import utils.PersistenceUtil;

public class ArtikalCrud {

	
	@SuppressWarnings("unchecked")
	public List<Artikal> listaArtikala() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select a from Artikal a";	// HQL->SQL : SELECT * FROM Student;
		List<Artikal> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list;
	}
}
