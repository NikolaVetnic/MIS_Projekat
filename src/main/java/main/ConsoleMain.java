package main;

import java.time.LocalDate;
import java.util.Date;

import crud.ArtikalCrud;
import crud.DobavljacCrud;
import crud.DostavljacCrud;
import crud.KlijentCrud;
import crud.RadnikCrud;
import crud.StoCrud;
import model.Klijent;
import utils.DateConverter;

public class ConsoleMain {
	

	public static void main(String[] args) {

		ArtikalCrud artCrud = new ArtikalCrud();
		DobavljacCrud dobCrud = new DobavljacCrud();
		DostavljacCrud dosCrud = new DostavljacCrud();
		KlijentCrud kliCrud = new KlijentCrud();
		RadnikCrud radCrud = new RadnikCrud();
		StoCrud stoCrud = new StoCrud();
		
		System.out.println("LISTA ARTIKALA : ");
		artCrud.listaArtikala().stream().forEach(System.out::println);
		
		System.out.println("LISTA DOBAVLJACA : ");
		dobCrud.listaDobavljaca().stream().forEach(System.out::println);

		System.out.println("LISTA DOSTAVLJACA : ");
		dosCrud.listaDostavljaca().stream().forEach(System.out::println);
		
		System.out.println("LISTA OSOBLJA : ");
		radCrud.listaRadnika().stream().forEach(System.out::println);

		System.out.println("KLIJENTI ");
		
		Klijent k = new Klijent();
		k.setImeKli("Gurbailo");
		k.setPrzKli("Gavric");
		k.setAdrKli("Dositejeva 19");
		k.setTelKli("060999888");
		k.setEmailKli("gurbailo.remadzenovski@telenor.rs");
		k.setPassKli("seselj");
		
		kliCrud.dodajKlijenta(k);
		kliCrud.listaKlijenata().stream().forEach(System.out::println);
		System.out.println();
		
		kliCrud.promeniIme(k, "Milisavac");
		kliCrud.listaKlijenata().stream().forEach(System.out::println);
		System.out.println();
		
		kliCrud.obrisiKlijenta(k);
		
		System.out.println("LISTA REGISTROVANIH KLIJENATA : ");
		kliCrud.listaKlijenata().stream().forEach(System.out::println);
		System.out.println();
		
		System.out.println("LISTA STOLOVA : ");
		stoCrud.listaStolova().stream().forEach(System.out::println);
		
		// lista svih rezervacija prema id stola
		System.out.println("LISTA REZERVACIJA ZA STO : ");
		stoCrud.listaRezervacijaZaSto(1).stream().forEach(System.out::println);
		
		// pretraga prema id stola i datumima od-do
		LocalDate ld0 = LocalDate.of(2021, 5, 31);
		LocalDate ld1 = LocalDate.of(2021, 6, 11);
		LocalDate ld2 = LocalDate.of(2021, 6, 21);
		
		Date d0 = DateConverter.convertToDateViaInstant(ld0);
		Date d1 = DateConverter.convertToDateViaInstant(ld1);
		Date d2 = DateConverter.convertToDateViaInstant(ld2);
		
		System.out.println("LISTA REZERVACIJA ZA STO : ");
		stoCrud.listaRezervacijaZaSto(1, d0, d1).stream().forEach(System.out::println);
		
		System.out.println("LISTA REZERVACIJA ZA STO : ");
		stoCrud.listaRezervacijaZaSto(1, d1, d2).stream().forEach(System.out::println);
		
		System.out.println("RADNIK : ");
		System.out.println(radCrud.pronadjiRadnika(1));
	}
}
