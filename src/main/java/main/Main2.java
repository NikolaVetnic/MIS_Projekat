package main;

import java.time.LocalDate;
import java.util.List;

import crud.ArtikalCrud;
import crud.DobavljacCrud;
import crud.DostavljacCrud;
import crud.KlijentCrud;
import crud.RadnikCrud;
import crud.RezervacijaCrud;
import crud.StoCrud;
import model.Klijent;
import model.Rezervacija;
import model.Sto;

public class Main2 {

	public static void main(String[] args) {
		
		ArtikalCrud artCrud = new ArtikalCrud();
		DobavljacCrud dobCrud = new DobavljacCrud();
		DostavljacCrud dosCrud = new DostavljacCrud();
		KlijentCrud kliCrud = new KlijentCrud();
		RadnikCrud radCrud = new RadnikCrud();
		StoCrud stoCrud = new StoCrud();
		
		Klijent k = kliCrud.pronadjiKlijenta("Dzemadan", "Dzemadan");
		
		System.out.println(k);
		
		System.out.println(kliCrud.listaRezervacijaZaKlijentaZaDan(k, LocalDate.of(2021, 6, 1)));
		
		RezervacijaCrud rc = new RezervacijaCrud();
		
		Sto s = stoCrud.pronadjiSto(1);
		System.out.println(s);
		
		rc.dodajRezervaciju(k, LocalDate.of(2021, 6, 2), s, "OPIS2");
		
		List<Rezervacija> rez = stoCrud.listaRezervacija(s);
		System.out.println(rez);
	}
}
