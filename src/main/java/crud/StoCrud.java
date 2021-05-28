package crud;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import model.Rezervacija;
import model.Sto;
import utils.PersistenceUtil;

public class StoCrud {

	
	@SuppressWarnings("unchecked")
	public List<Sto> listaStolova() {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select s from Sto s";	// HQL->SQL : SELECT * FROM Student;
		List<Sto> list = em.createQuery(query).getResultList();
		
		em.close();
		
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Rezervacija> listaRezervacijaZaSto(int id) {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		
		String query = "select s from Sto s";	// HQL->SQL : SELECT * FROM Student;
		List<Sto> list = em.createQuery(query).getResultList();
		
		Sto sto = list.stream()
				.filter(s -> s.getIdSto() == id)
				.findFirst().orElse(null);
		
		if (sto == null) return null;
		
		em.close();
		
		return sto.getRezervacije();
	}
	
	
	public List<Rezervacija> listaRezervacijaZaSto(int id, Date poc, Date kraj) {
		
		return listaRezervacijaZaSto(id).stream()
				.filter(r -> r.getDatRez().compareTo(poc) > 0 && r.getDatRez().compareTo(kraj) < 0)
				.collect(Collectors.toList());
	}
	
	
	public boolean jeRezervisanZaPeriod(int id, Date poc, Date kraj) {
		
		return listaRezervacijaZaSto(id, poc, kraj) != null;
	}
}
