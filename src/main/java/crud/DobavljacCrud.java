package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Dobavljac;
import utils.PersistenceUtil;

public class DobavljacCrud {

	
	@SuppressWarnings("unchecked")
	public List<Dobavljac> listaDobavljaca() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select d from Dobavljac d";	// HQL->SQL : SELECT * FROM Student;
		List<Dobavljac> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list;
	}
}
