package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import model.Klient;
import model.Laptop;
import model.Naprawa;
import model.TypNaprawy;

public class NaprawaDaoTest {

	private List<Naprawa> naprawy;
	private List<Klient> klienci;
	private List<Laptop> laptopy;

	@Rule
	public final ConnectionRule cr = new ConnectionRule();

	@Before
	public void init() {
		klienci = generujKlientów();
		laptopy = generujLaptopy();
		naprawy = generujNaprawy();
		for (Naprawa naprawy : naprawy) {
			cr.getNaprawaDao().persist(naprawy);
		}

	}

	@Test
	public void isConnectionOk() {
		assertTrue(cr.getEntMan() != null);
	}

	
	
	@Test
	public void isAllRepairsAdded() {
		for (Naprawa naprawa : naprawy) {
			assertTrue(naprawa.getId() > 0.0);
		}
	}

	@Test
	public void isAllRepairsFound() {
		List<Naprawa> lista = cr.getNaprawaDao().findAll();
		for (Naprawa naprawa : lista) {
			System.out.println(naprawa.getId());
		}
		assertNotNull(lista);
		assertTrue(lista.size() >= 4);
	}

	@Test
	public void isRepairsFoundById() {
		Naprawa naprawa = cr.getNaprawaDao().findById(3L);
		Naprawa naprawa2 = cr.getNaprawaDao().findById(2L);
		assertNotNull(naprawa);
		assertNotNull(naprawa2);
	}

	@Test
	public void findRepairsByAtr() {
		HashMap<String, String> atrMap = new HashMap<String, String>();
		List<Naprawa> foundRepairs = null;
		atrMap.put("opisUszkodzenia", "zalany");
		foundRepairs = cr.getNaprawaDao().findByAtrybutes(atrMap);
		assertNotNull(foundRepairs);
		assertTrue(foundRepairs.size() >= 1);

	}

	@Test
	public void deleteRepairs() {
		for (Naprawa naprawa : naprawy) {
			cr.getNaprawaDao().delete(naprawa);
			assertNull(cr.getNaprawaDao().findById((long) naprawa.getId()));
		}

	}



	public List<Naprawa> generujNaprawy() {
		List<Naprawa> naprawy = new ArrayList<Naprawa>();
		
		Naprawa naprawa1 = new Naprawa();
		naprawa1.setKlient(klienci.get(1));
		naprawa1.setSprzet(laptopy.get(1));
		naprawa1.setTypNaprawy(new TypNaprawy("Niegwarancyjna"));
		naprawa1.setOpisUszkodzenia("Laptop zalany");

		Naprawa naprawa2 = new Naprawa();
		naprawa2.setKlient(klienci.get(2));
		naprawa2.setSprzet(laptopy.get(2));
		naprawa2.setTypNaprawy(new TypNaprawy("Gwarancyjna"));
		naprawa2.setOpisUszkodzenia("Nie w³¹cza siê");

		
		Naprawa naprawa3 = new Naprawa();
		naprawa3.setKlient(klienci.get(3));
		naprawa3.setSprzet(laptopy.get(3));
		naprawa3.setTypNaprawy(new TypNaprawy("Niegwarancyjna"));
		naprawa3.setOpisUszkodzenia("Zawirusowany");

		
		Naprawa naprawa4 = new Naprawa();
		naprawa4.setKlient(klienci.get(4));
		naprawa4.setSprzet(laptopy.get(0));
		naprawa4.setTypNaprawy(new TypNaprawy("Niegwarancyjna"));
		naprawa4.setOpisUszkodzenia("Laptop zalany");

		
		Naprawa naprawa5 = new Naprawa();
		naprawa5.setKlient(klienci.get(1));
		naprawa5.setSprzet(laptopy.get(1));
		naprawa5.setTypNaprawy(new TypNaprawy("Pogwarancyjna"));
		naprawa5.setOpisUszkodzenia("Laptop zalany");

		naprawy.add(naprawa1);
		naprawy.add(naprawa2);
		naprawy.add(naprawa3);
		naprawy.add(naprawa4);
		naprawy.add(naprawa5);
		
		return naprawy;
	}

	public List<Klient> generujKlientów() {
		List<Klient> klienci = new ArrayList<Klient>();
		Klient klient1 = new Klient();
		klient1.setImie("Kamil");
		klient1.setNazwisko("Urbañski");
		klient1.setTelefon("500-355-022");
		klient1.setMiasto("Nowy S¹cz");

		Klient klient2 = new Klient();
		klient2.setImie("Andrzej");
		klient2.setNazwisko("Dro¿d¿");
		klient2.setTelefon("625562458");
		klient2.setMiasto("Kraków");

		Klient klient3 = new Klient();
		klient3.setImie("Jan");
		klient3.setNazwisko("Kowalski");
		klient3.setTelefon("7777777");
		klient3.setMiasto("Katowice");

		Klient klient4 = new Klient();
		klient4.setImie("Jakub");
		klient4.setNazwisko("Nowak");
		klient4.setTelefon("656312645");
		klient4.setMiasto("Nowy S¹cz");

		Klient klient5 = new Klient();
		klient5.setImie("Janina");
		klient5.setNazwisko("Nowak");
		klient5.setTelefon("99999999");
		klient5.setMiasto("Gdynia");

		klienci.add(klient1);
		klienci.add(klient2);
		klienci.add(klient3);
		klienci.add(klient4);
		klienci.add(klient5);
		return klienci;
	}

	public List<Laptop> generujLaptopy() {
		List<Laptop> laptopy = new ArrayList<Laptop>();
		Laptop laptop1 = new Laptop();
		laptop1.setNazwa("Lenovo G50");
		laptop1.setZasilacz("nie");
		laptop1.setNumerSeryjny("XXSD435DF");

		Laptop laptop2 = new Laptop();
		laptop2.setNazwa("Lenovo G70");
		laptop2.setZasilacz("tak");
		laptop2.setNumerSeryjny("625562458");

		Laptop laptop3 = new Laptop();
		laptop3.setNazwa("Samsung R50");
		laptop3.setZasilacz("tak");
		laptop3.setNumerSeryjny("DDDDSAS536");

		Laptop laptop4 = new Laptop();
		laptop4.setNazwa("Dell Vostro 5459");
		laptop4.setZasilacz("nie");
		laptop4.setNumerSeryjny("FGH3234D");

		laptopy.add(laptop1);
		laptopy.add(laptop2);
		laptopy.add(laptop3);
		laptopy.add(laptop4);
		return laptopy;
	}
}
