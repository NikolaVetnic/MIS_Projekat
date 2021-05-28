package crud;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import model.Artikal;
import model.NabavkaArtikal;
import model.RacunArtikal;
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
	
	
	@SuppressWarnings("unchecked")
	public List<NabavkaArtikal> listaArtikalaZaNabavku() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select a from Artikal a";	// HQL->SQL : SELECT * FROM Student;
		List<Artikal> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list.stream().flatMap(a -> a.getNabavkaArtikli().stream()).collect(Collectors.toList());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<RacunArtikal> listaArtikalaUPonudi() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select a from Artikal a";	// HQL->SQL : SELECT * FROM Student;
		List<Artikal> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list.stream().flatMap(a -> a.getRacunArtikli().stream()).collect(Collectors.toList());
	}
}
