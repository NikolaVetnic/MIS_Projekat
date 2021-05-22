package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Dostavljac;
import utils.PersistenceUtil;

public class DostavljacCrud {

	
	@SuppressWarnings("unchecked")
	public List<Dostavljac> listaDostavljaca() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select d from Dostavljac d";	// HQL->SQL : SELECT * FROM Student;
		List<Dostavljac> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list;
	}
}
