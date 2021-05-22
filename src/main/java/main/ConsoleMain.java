package main;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import crud.ArtikalCrud;
import crud.DobavljacCrud;
import crud.DostavljacCrud;
import crud.KlijentCrud;
import crud.RadnikCrud;
import model.Klijent;

public class ConsoleMain {
	

	public static void main(String[] args) {

		ArtikalCrud artCrud = new ArtikalCrud();
		DobavljacCrud dobCrud = new DobavljacCrud();
		DostavljacCrud dosCrud = new DostavljacCrud();
		KlijentCrud kliCrud = new KlijentCrud();
		RadnikCrud radCrud = new RadnikCrud();
		
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
	}
}
